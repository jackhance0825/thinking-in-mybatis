import com.jackhance.dao.StudentMapper;
import com.jackhance.pojo.Student;
import com.jackhance.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void getStudentById() {
        try (SqlSession session = MybatisUtils.openSession();) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.getStudentById(1);
            System.out.println(student);
        }
    }

    @Test
    public void getStudentById2() {
        try (SqlSession session = MybatisUtils.openSession();) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.getStudentById2(1);
            System.out.println(student);
        }
    }
}
