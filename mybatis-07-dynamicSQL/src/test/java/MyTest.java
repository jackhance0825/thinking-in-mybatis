import com.jackhance.dao.BlogMapper;
import com.jackhance.pojo.Blog;
import com.jackhance.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void getBlogsForeach() {
        try (SqlSession session = MybatisUtils.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            map.put("ids", ids);
            List<Blog> blogs = mapper.getBlogsForeach(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void updateBlog() {
        try (SqlSession session = MybatisUtils.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", "2");
            map.put("title", "SpringBoot如此简单");
            map.put("views", 500);
            System.out.println(mapper.updateBlog(map));
            session.commit();
        }
    }

    @Test
    public void getBlogsWhen() {
        try (SqlSession session = MybatisUtils.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("author", "小张");
//            map.put("title", "微服务如此简单");
            map.put("views", 200);

            List<Blog> blogs = mapper.getBlogsWhen(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void getBlogsIf() {
        try (SqlSession session = MybatisUtils.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("author", "小张");
            map.put("views", 200);

            List<Blog> blogs = mapper.getBlogsIf(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void getBlogs() {
        try (SqlSession session = MybatisUtils.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<Blog> blogs = mapper.getBlogs();
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void insertBlog() {
        try (SqlSession session = MybatisUtils.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog b = new Blog("1", "Mybatis如此简单", "小张", new Date(), 100);
            mapper.insertBlog(b);
            b.setId("2");
            b.setTitle("微服务如此简单");
            mapper.insertBlog(b);

            b.setId("3");
            b.setTitle("Spring如此简单");
            mapper.insertBlog(b);

            b.setId("4");
            b.setTitle("JVM如此简单");
            mapper.insertBlog(b);

            b.setId("5");
            b.setTitle("设计模式如此简单");
            mapper.insertBlog(b);

            session.commit();
        }
    }
}
