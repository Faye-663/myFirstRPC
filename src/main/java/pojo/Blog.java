package pojo;

import java.io.Serializable;

/**
 * @author faye
 */
public class Blog implements Serializable {
    private int blogId;
    private int userId;
    private String title;

    public Blog() {}

    public Blog(int blogId, int userId, String title) {
        this.blogId = blogId;
        this.userId = userId;
        this.title = title;
    }

    public int getBlogId() {
        return blogId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}
