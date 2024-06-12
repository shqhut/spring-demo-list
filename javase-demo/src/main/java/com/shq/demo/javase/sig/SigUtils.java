package com.shq.demo.javase.sig;

import com.google.common.hash.Hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SigUtils {

    public final static String key = "f04a80f1767a6194ffb270ca522edfe9";

    public static String sig(Map<String,Object> map) {
        // ba5d22e06dfdfc9068abc1208e99e308
        // f04a80f1767a6194ffb270ca522edfe9
        //签名格式：sig=MD5(请求参数键值对（按参数名的升序排序），加（请注意“加”字无需输入）私钥)。
        //例如：
        //请求服务为“testservice”；请求参数分别为“a=23，b=12，d=48，f=8，c=67”；私钥为“bbbbb”。
        //则数字签名为：sig=md5(a=23&b=12&c=67&d=48&f=8bbbbb)
        if (!(map instanceof TreeMap)){
            // 按字母顺序排序
            map = new TreeMap<>(map);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.toString() != null && !value.toString().isEmpty()) {
                stringBuilder.append(key).append("=").append(signStr(value)).append("&");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).append(key).toString();
    }

    public static String signStr(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return buildSign((Map<String,Object>) obj).insert(0,'{').append('}').toString();
        }
        if (obj instanceof List) {
            return buildSign((List<Object>) obj).insert(0,'[').append(']').toString();
        }
        return obj.toString();
    }

    public static StringBuilder buildSign(Map<String,Object> map) {
        if (!(map instanceof TreeMap)){
            // 按字母顺序排序
            map = new TreeMap<>(map);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.toString() != null && !value.toString().isEmpty()) {
                stringBuilder.append(key).append("=").append(signStr(value)).append("&");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }

    public static StringBuilder buildSign(List<Object> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list == null || list.isEmpty()) {
            return stringBuilder;
        }
        for (Object obj : list) {
            stringBuilder.append(signStr(obj)).append(",");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        Map<String,Object> param = new HashMap<>();
        param.put("adcode","310000");
        param.put("keywords","大丸百货");
        param.put("showPolygon",1);
        String sig = SigUtils.sig(param);
        String finalSig = Hashing.md5().hashBytes(sig.getBytes()).toString();
        System.out.println(sig);
        System.out.println(finalSig);
    }

}
