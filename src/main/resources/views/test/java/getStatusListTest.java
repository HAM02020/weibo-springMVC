import com.mfs.dao.AccessTokenDao;
import com.mfs.entity.AccessToken;
import com.mfs.http.NetworkManager;
import com.mfs.viewmodel.StatusListViewModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;

public class getStatusListTest extends BaseTest {
    StatusListViewModel listViewModel = new StatusListViewModel();

    @Autowired
    AccessTokenDao accessTokenDao;

    public getStatusListTest() throws IOException {
    }

    @Test
    public void getStatus() throws IOException {

        AccessToken accessToken = accessTokenDao.queryAll(0,2).get(0);

        NetworkManager.Shared().setAccess_token(accessToken);
        listViewModel.getStatusList(false);

        System.out.println(listViewModel.statusList.get(0));

    }
}
