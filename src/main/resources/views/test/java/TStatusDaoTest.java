import com.mfs.dao.TStatusDao;
import com.mfs.entity.TStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class TStatusDaoTest extends BaseTest {

    @Qualifier("TStatusDao")
    @Autowired
    TStatusDao tStatusDao;

    @Test
    public void loadStatus(){
        long userId = Long.parseLong("5953831002");
        long sinceId = Long.parseLong("0");
        long maxId = Long.parseLong("0");

        List<TStatus> array =  tStatusDao.loadStatus(userId,sinceId,maxId);
        System.out.println(array);
    }

    @Test
    public void insertStatus(){
        long userId = Long.parseLong("1");
        tStatusDao.insertStatus(1,6,"jjjjjjjjj");
    }

    @Test
    public void updateStatus(){
        tStatusDao.updateStatus(1,6,"ssssssss");
    }
}
