package client;

import pojo.Blog;
import pojo.User;
import service.BlogService;
import service.UserService;

/**
 * @author faye
 */
public class Client {
    public static void main(String[] args) {

        NettyRpcClient client = new NettyRpcClient("127.0.0.1",8888);
        ClientProxy clientProxy = new ClientProxy(client);

        UserService UserServiceProxy = clientProxy.getProxy(UserService.class);
        BlogService blogServiceProxy = clientProxy.getProxy(BlogService.class);

        User user = UserServiceProxy.getUserByName("aaa");
        System.out.println(user);

        System.out.println(UserServiceProxy.addUser("bbb", 123));

        Blog blogById = blogServiceProxy.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);

    }

}
