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
    public void getUserList() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.getUserList();
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getUserById() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        }
    }

    @Test
    public void getUserById2() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserById2(1);
            System.out.println(user);
        }
    }

    @Test
    public void getUserByIdName() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserByIdName(1, "张三");
            System.out.println(user);
        }
    }


    @Test
    public void insertUser() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User(10, "一袋米", "11111");
            System.out.println(mapper.insertUser(user));
            session.commit();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User(10, "搜狗", "2222");
            System.out.println(mapper.updateUser(user));
            session.commit();
        }
    }

    @Test
    public void updateUser2() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.updateUser2(10, "优酷", "333"));
            session.commit();
        }
    }
}
