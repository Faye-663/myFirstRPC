package server;

import service.BlogService;
import service.BlogServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * @author faye
 */
public class Server {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.addServiceInterface(userService);
        serviceProvider.addServiceInterface(blogService);

        NettyRpcServer nettyRpcServer = new NettyRpcServer(8888,serviceProvider);
        nettyRpcServer.run();
    }
}
