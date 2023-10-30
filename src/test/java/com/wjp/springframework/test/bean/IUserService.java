package com.wjp.springframework.test.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IUserService {
    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }
}
