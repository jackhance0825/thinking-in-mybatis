import com.jackhance.dao.UserMapper;
import com.jackhance.pojo.User;
import com.jackhance.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTest {

    @Test
    public void select() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.getUserList();
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Test// 老方式，不建议
    public void select2() {
        try (SqlSession session = MybatisUtils.openSession()) {
            List<User> users = session.selectList("com.jackhance.dao.UserMapper.getUserList");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getUserById() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User u = mapper.getUserById(3);
            System.out.println(u);
        }
    }

    @Test
    public void insertUser() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User(7, "小梦", "123456");
            System.out.println(mapper.insertUser(user));
            session.commit();
        }
    }

    @Test
    public void deleteUserById() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.deleteUserById(7));
            session.commit();
        }
    }

    @Test
    public void deleteUserByName() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.deleteUserByName("小张"));
            session.commit();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User u = new User(1, "张三", "12");
            System.out.println(mapper.updateUser(u));
            session.commit();
        }
    }

    @Test
    public void insertUser2() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>(4, 1);
            map.put("userid", 8);
            map.put("username", "碧落");
            map.put("userpassword", "11111");
            System.out.println(mapper.insertUser2(map));
            session.commit();
        }
    }

    @Test
    public void selectUserByKey() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
//            String value = "%王%";
            String value = "王";
            List<User> users = mapper.selectUserByKey(value);
            for (User user : users) {
                System.out.println(user);
            }
            session.commit();
        }
    }

}
