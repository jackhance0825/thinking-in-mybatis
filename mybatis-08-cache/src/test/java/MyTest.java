import com.jackhance.dao.UserMapper;
import com.jackhance.pojo.User;
import com.jackhance.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void getUserById() {
        try (SqlSession session = MybatisUtils.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user1 = mapper.getUserById(1);
            System.out.println(user1);

//            session.clearCache();

            User user2 = mapper.getUserById(1);
            System.out.println(user2);

            // 默认开启一级缓存，即回话缓存SqlSession
            System.out.println(user1 == user2);
        }
    }

    @Test
    public void getUserById2() {
        SqlSession session1 = MybatisUtils.openSession();
        SqlSession session2 = MybatisUtils.openSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        User user1 = mapper1.getUserById(1);
        System.out.println(user1);
        session1.close();

        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        session2.close();

        // 开启二级缓存<cache/>，namespace级别
        System.out.println(user1 == user2);
    }

    @Test
    public void getUserById3() {
        SqlSession session1 = MybatisUtils.openSession();
        SqlSession session2 = MybatisUtils.openSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        User user1 = mapper1.getUserById(1);
        mapper1.getUserById(2);
        System.out.println(user1);

        // 刷新了二级缓存
        user1.setName("SpringMVC");
        mapper1.updateUser(user1);
        session1.commit();
        session1.close();

        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        session2.close();

        System.out.println(user1 == user2);
    }
}
