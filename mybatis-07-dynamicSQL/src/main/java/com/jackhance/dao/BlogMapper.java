package com.jackhance.dao;

import com.jackhance.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Blog> getBlogs();

    int insertBlog(Blog blog);

    List<Blog> getBlogsIf(Map<String, Object> map);

    List<Blog> getBlogsWhen(Map<String, Object> map);

    int updateBlog(Map<String, Object> map);

    List<Blog> getBlogsForeach(Map<String, Object> map);

}
