package com.wjp.springframework.test.bean;

import com.wjp.springframework.beans.factory.DisposableBean;
import com.wjp.springframework.beans.factory.InitializingBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + ", 公司：" + company + ", 地点" + location;
    }
}
