import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class TestAuthenticator {
    @Test
    public void testAuthenticator(){
        //1、获取 SecurityManager 工厂，此处使用 Ini 配置文件初始化 SecurityManager
        //SecurityManager必须完整包名，否则跟java.lang底下的类冲突，会引用错误
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2、得到SecurityManager实例，并绑定给 SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、获取subject 及创建用户名/密码身份验证 Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        try {
            //4、登录认证
            System.out.println("开始认证");
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、认证失败
            System.out.println("认证失败");
        }

        if (subject.isAuthenticated()) {
            System.out.println("认证成功");
        }

        //6、退出
        subject.logout();
        System.out.println("退出");
    }

    @Test
    public void testCustomRealm(){
        //1、获取 SecurityManager 工厂，此处使用 Ini 配置文件初始化 SecurityManager
        //SecurityManager必须完整包名，否则跟java.lang底下的类冲突，会引用错误
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2、得到SecurityManager实例，并绑定给 SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、获取subject 及创建用户名/密码身份验证 Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        try {
            //4、登录认证
            System.out.println("开始认证");
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、认证失败
            System.out.println("认证失败");
        }

        if (subject.isAuthenticated()) {
            System.out.println("认证成功");
        }

        //6、退出
        subject.logout();
        System.out.println("退出");
    }
}
