package com.wjp.springframework.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    private String name;

    public void test() {
        System.out.println("我是user");
    }
}
