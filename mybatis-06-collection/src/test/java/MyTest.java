import com.jackhance.dao.TeacherMapper;
import com.jackhance.pojo.Teacher;
import com.jackhance.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void getTeacherById() {
        try (SqlSession session = MybatisUtils.openSession()) {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacherById(1);
            System.out.println(teacher);
        }
    }

    @Test
    public void getTeacherById2() {
        try (SqlSession session = MybatisUtils.openSession()) {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacherById2(1);
            System.out.println(teacher);
        }
    }
}
