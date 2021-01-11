import com.jackhance.dao.UserMapper;
import com.jackhance.pojo.User;
import com.jackhance.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void getUserListByLimit(){
        try(SqlSession session = MybatisUtils.openSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<>();
            map.put("offset", 0);
            map.put("pageSize", 2);

            List<User> users = mapper.getUserListByLimit(map);
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getUserListByRowBounds(){
        try(SqlSession session = MybatisUtils.openSession()){
            List<User> users = session.selectList("com.jackhance.dao.UserMapper.getUserListByRowBounds",null,new RowBounds(0,2));
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
