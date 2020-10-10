import com.mfs.dao.UserDao;
import com.mfs.entity.User;
import com.mfs.tools.NetworkManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getUser(){
        User user = userDao.queryById("1");
        System.out.println(user);
    }
    @Test
    public void getAllUser(){
        List<User> user = userDao.queryAll(0,2);
        System.out.println(user);
    }
//    @Test
//    public void InsertUser(){
//        User user = new User();
//        user.idstr ="2";
//        user.screen_name="ruru";
//        user.profile_image_url="jjj";
//        userDao.insert(user);
//        System.out.println(user);
//    }
    @Test
    public void UpdateUser(){
        User user = new User();
        user.idstr ="2";
        user.screen_name="guoqing";
        user.profile_image_url="ggg";
        userDao.update(user);
        System.out.println(user);
    }
    @Test
    public void Show() throws IOException {
        //获取用户信息
        String userinfo_resp = NetworkManager.Shared().getUserInfo(Long.parseLong("5953831002"));
        User user = User.getInstance(userinfo_resp);
        if(userDao.queryById(user.getIdstr())==null)
            userDao.insert(user);
        else
            userDao.update(user);
    }
}
