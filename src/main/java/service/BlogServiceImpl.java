package service;

import pojo.Blog;

/**
 * @author faye
 */
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(int id) {
        System.out.println("客户端查询了"+id+"博客");
        return new Blog(8888,1001,"testBlog");
    }
}
