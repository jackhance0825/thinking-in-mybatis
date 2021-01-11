import com.jackhance.dao.UserMapper;
import com.jackhance.pojo.User;
import com.jackhance.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BaseTest {

    @Test
    public void getUserList(){
        try(SqlSession session = MybatisUtils.openSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.getUserList();
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
