import com.mfs.dao.AccessTokenDao;
import com.mfs.entity.AccessToken;

import com.mfs.service.AccessTokenService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccessTokenDaoTest extends BaseTest {

    @Autowired
    AccessTokenDao accessTokenDao;

    @Autowired
    AccessTokenService accessTokenService;

    @Test
    public void queryById(){
        System.out.println(accessTokenDao.queryByUId("5953831002").toString());
    }

    @Test
    public void testQueryAll() throws Exception {
        List<AccessToken> books = accessTokenDao.queryAll(0, 4);
        for (AccessToken book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testServiceQueryAll() throws Exception {
        List<AccessToken> books = accessTokenService.queryAll(0, 4);
        for (AccessToken book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void InsertToken(){
        String rep = "{\"access_token\":\"2.00S7fvUGU1U7fEc0b2507207DoFMDB\",\"remind_in\":\"157679999\",\"expires_in\":157679999,\"uid\":\"5953831002\",\"isRealName\":\"true\"}";

        AccessToken accessToken = new AccessToken(rep);
        if(accessTokenDao.queryByUId("5953831002")==null){
            accessTokenDao.insert(accessToken);
        }
        System.out.println(accessToken.toString());

    }
}
