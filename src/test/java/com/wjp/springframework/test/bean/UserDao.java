package com.wjp.springframework.test.bean;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("10001", "周三");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }
}
