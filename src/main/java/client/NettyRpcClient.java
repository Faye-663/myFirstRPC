package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import pojo.RpcRequest;
import pojo.RpcResponse;

/**
 * @author faye
 */
public class NettyRpcClient {
    private final int port;
    private final String host;
    private static final Bootstrap boot;
    private static final EventLoopGroup workerGroup;

    public NettyRpcClient(String host,int port) {
        this.port = port;
        this.host = host;
    }

    static {
        workerGroup = new NioEventLoopGroup();
        boot = new Bootstrap();
        boot.group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new NettyRpcClientInitializer());
    }

    public RpcResponse sendRequest(RpcRequest request){
        try {
            ChannelFuture channelFuture  = boot.connect(host, port).sync();
            Channel channel = channelFuture.channel();
            // 发送数据
            channel.writeAndFlush(request);
            channel.closeFuture().sync();

            AttributeKey<RpcResponse> key = AttributeKey.valueOf("RpcResponse");
            RpcResponse response = channel.attr(key).get();

            System.out.println(response);
            return response;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }
}
