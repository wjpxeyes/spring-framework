package com.wjp.springframework.test.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDao {
    private int userId;
    private String name;
}
