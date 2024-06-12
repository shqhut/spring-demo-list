package com.shq.demo.orderFeign.interceptor;

import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MiddleRequestInterceptor implements RequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MiddleRequestInterceptor.class);

    private static final String HEADER_X_CONTENT_MD5 = "X-Content-MD5";
    private static final String HEADER_X_VERSION = "X-Sign-Version";
    private static final String HEADER_X_TIMESTAMP = "X-Timestamp";
    private static final String HEADER_X_NONCE = "X-Nonce";
    private final String accessKey;
    private final String secretKey;

    public MiddleRequestInterceptor(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public void apply(RequestTemplate template) {
        Request.Body body = template.requestBody();
        template.header(HEADER_X_CONTENT_MD5, buildContentMD5(body));
        template.header(HEADER_X_VERSION, "1.0");
        template.header(HEADER_X_NONCE, UUID.randomUUID().toString().replace("-", ""));
        template.header(HEADER_X_TIMESTAMP, Long.toString(System.currentTimeMillis() / 1000));
        template.header("Authorization", "wayz " + accessKey + ":" + sign(template));
        Map<String, Collection<String>> headers = template.request().headers();
        Collection<String> authorization = headers.get("Authorization");
        System.out.println(authorization);
    }
    private String sign(RequestTemplate template) {
        byte[] sha = Hashing.hmacSha1(secretKey.getBytes())
                .hashString(buildStringToSign(template), StandardCharsets.UTF_8)
                .asBytes();
        return BaseEncoding.base64().encode(sha);
    }
    private String buildStringToSign(RequestTemplate template) {
        return accessKey + "\r\n"
                + template.method() + "\r\n"
                + template.path() + "\r\n"
                + sortedParamStr(template) + "\r\n"
                + "application/json" + "\r\n"
                + getHeader(template, HEADER_X_CONTENT_MD5) + "\r\n"
                + "application/json;charset=UTF-8" + "\r\n"
                + getHeader(template, HEADER_X_TIMESTAMP) + "\r\n"
                + getHeader(template, HEADER_X_VERSION) + "\r\n"
                + getHeader(template, HEADER_X_NONCE);
    }
    private String sortedParamStr(RequestTemplate template) {
        String paramStr = template.queries().entrySet().stream()
                .filter(e -> e.getValue() != null && !e.getValue().isEmpty())
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + "=" + e.getValue().iterator().next())
                .collect(Collectors.joining("&"));
        System.out.println(paramStr);
        return paramStr;
    }
    private Object getHeader(RequestTemplate template, String key) {
        Collection<String> values = template.headers().get(key);
        return values == null || values.isEmpty() ? "" : values.iterator().next();
    }
    private String buildContentMD5(Request.Body body) {
        if (body == null || body.length() == 0) {
            return Hashing.md5().hashString("", StandardCharsets.UTF_8).toString();
        }
        return Hashing.md5().hashBytes(body.asBytes()).toString();
    }


}
