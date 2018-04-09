


import org.erp.myproductionsrc.Util.JedisUtils;
import org.erp.myproductionsrc.domain.authority.SysUser;
import org.erp.myproductionsrc.mapper.authority.SysUserDao;
import org.erp.myproductionsrc.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class ISysUserDaoTest {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void SysUserserviceTest(){
       /* List<SysUser> usrlist=  sysUserService.findAllUser();
        for(SysUser user: usrlist){
            System.out.print(user);
        }
*/
        SysUser sysUser = sysUserService.findUserByName("admin");
        System.out.print(sysUser);

    }
    @Test
    public void SysUserDaoTest(){
        List<SysUser> usrlist=  sysUserDao.findAllUser();
        for(SysUser user: usrlist){
            System.out.print(user);
        }

       /* SysUser sysUser = sysUserService.findUserByName("admin");
        System.out.print(sysUser);*/

    }

    @Test
    public void RedisPoolTEST(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("newname", "中文测试");
        byte[] aaa={01,02,03};
        byte[] bbb={04,05,06};
        jedis.set(aaa, bbb);
        System.out.println(JedisUtils.getJedis().get("newname"));
        for (byte a : aaa){
            System.out.println("byte-"+a);
        }

    }
}
