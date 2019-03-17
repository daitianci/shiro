package com.honor.shiro.realm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class CustomRealm implements Realm {
    private final static Log logger = LogFactory.getLog(CustomRealm.class);
    public String getName() {
        return "CustomRealm";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    /**
     * 用户登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String principal = (String) authenticationToken.getPrincipal();

        //获取密码
        String credentials = new String((char[])authenticationToken.getCredentials()); ;

        //这里填写用户名密码的验证规则，可以跟数据库进行交互操作
        if (!"zhang".equals(principal)){
            //用户名错误
            throw new UnknownAccountException();
        }

        if(!"123".equals(credentials)){
            //密码错误
            throw new IncorrectCredentialsException();
        }

        //验证通过，返回AuthenticationInfo信息
        System.out.println(getName());
        return new SimpleAuthenticationInfo(principal,credentials,getName());
    }
}
