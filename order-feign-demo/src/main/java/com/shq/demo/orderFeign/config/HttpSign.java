package com.shq.demo.orderFeign.config;

import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
public class HttpSign {
    private static final String HEADER_X_CONTENT_MD5 = "X-Content-MD5";
    private static final String HEADER_X_VERSION = "X-Sign-Version";
    private static final String HEADER_X_TIMESTAMP = "X-Timestamp";
    private static final String HEADER_X_NONCE = "X-Nonce";
    private static final String HEADER_X_ACCEPT = "Accept";
    private static final String HEADER_X_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private final String accessKey;
    private final String secretKey;
    public HttpSign(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }
    public void sendRequest(String uri, String method, String content) throws IOException {
        URL url = new URL(uri);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(method);
        httpURLConnection.setInstanceFollowRedirects(false);
        signReq(httpURLConnection, url, content);
        if (content != "") {
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(content.getBytes());
            os.flush();
            os.close();
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println(getResponse(httpURLConnection.getInputStream()));
        } else {
            System.out.println(getResponse(httpURLConnection.getErrorStream()));
        }
        httpURLConnection.disconnect();
    }
    private String getResponse(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    private void signReq(HttpURLConnection conn, URL url, String content) {
        conn.setRequestProperty(HEADER_X_CONTENT_MD5, buildContentMD5(content));
        conn.setRequestProperty(HEADER_X_VERSION, "1.0");
        conn.setRequestProperty(HEADER_X_TIMESTAMP, Long.toString(System.currentTimeMillis() / 1000));
        conn.setRequestProperty(HEADER_X_NONCE, UUID.randomUUID().toString().replace("-", ""));
        conn.setRequestProperty(HEADER_X_ACCEPT, "application/json");
        conn.setRequestProperty(HEADER_X_CONTENT_TYPE, "application/json;charset=UTF-8");
        conn.setRequestProperty(HEADER_AUTHORIZATION, "wayz " + accessKey + ":" + sign(conn, url));
    }
    private String sign(HttpURLConnection conn, URL url) {
        String s = buildStringToSign(conn, url);
        byte[] sha = Hashing.hmacSha1(secretKey.getBytes())
                .hashString(s, StandardCharsets.UTF_8)
                .asBytes();
        return BaseEncoding.base64().encode(sha);
    }
    private String buildStringToSign(HttpURLConnection conn, URL url) {
        return accessKey + "\r\n"
                + conn.getRequestMethod() + "\r\n"
                + url.getPath() + "\r\n"
                + sortedParamStr(url.getQuery()) + "\r\n"
                + getHeader(conn, HEADER_X_ACCEPT) + "\r\n"
                + getHeader(conn, HEADER_X_CONTENT_MD5) + "\r\n"
                + getHeader(conn, HEADER_X_CONTENT_TYPE) + "\r\n"
                + getHeader(conn, HEADER_X_TIMESTAMP) + "\r\n"
                + getHeader(conn, HEADER_X_VERSION) + "\r\n"
                + getHeader(conn, HEADER_X_NONCE);
    }
    private String sortedParamStr(String query) {
        Map<String, String> queries = new TreeMap<>();
        if (query != null && query.length() > 0) {
            String[] pars = query.split("&");
            for (int i = 0, len = pars.length; i < len; i++) {
                String[] param = pars[i].split("=");
                if (param.length == 2) {
                    queries.put(param[0], param[1]);
                }
            }
        }
        return queries.entrySet().stream()
                .filter(e -> e.getValue() != null && !e.getValue().isEmpty())
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }
    private Object getHeader(HttpURLConnection conn, String key) {
        String value = conn.getRequestProperty(key);
        return value;
    }
    private String buildContentMD5(String content) {
        if (content == null || content.length() == 0) {
            return Hashing.md5().hashString("", StandardCharsets.UTF_8).toString();
        }
        return Hashing.md5().hashBytes(content.getBytes()).toString();
    }
}
