package com.jackhance.dao;

import com.jackhance.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 使用注解来映射简单语句会使代码显得更加简洁，但对于稍微复杂一点的语句，Java 注解不仅力不从心，还会让你本就复杂的 SQL 语句更加混乱不堪。 因此，如果你需要做一些很复杂的操作，最好用 XML 来映射语句。
 * 比如association（多对一） 、 collection（一对多）、动态Sql
 */
public interface UserMapper {

    @Select("select * from `user`")
    List<User> getUserList();

    @Select("select * from `user` where id=#{uid}")
    User getUserById(@Param("uid") int id);

    @Select("select * from `user` where id=#{uid}")
    User getUserById2(int id);

    /**
     * 单个参数可以不用使用 @Param
     * 多个参数时，全部参数都要使用 @Param
     * 建议参数都加上 @Param
     */
    @Select("select * from `user` where id=#{id} and name=#{name}")
    User getUserByIdName(@Param("id") int id, @Param("name") String name);

    @Insert("insert into `user`(id, name, pwd) values(#{id}, #{name}, #{password})")
    int insertUser(User user);

    @Update("update `user` set name=#{name}, pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Update("update `user` set name=#{name}, pwd=#{password} where id=#{id}")
    int updateUser2(@Param("id") int id, @Param("name") String name, @Param("password") String password);
}
