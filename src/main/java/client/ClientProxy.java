package client;

import pojo.RpcRequest;
import pojo.RpcResponse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author faye
 */
public class ClientProxy implements InvocationHandler {

    private NettyRpcClient client;

    public ClientProxy() {}

    public ClientProxy(NettyRpcClient client) {
        this.client = client;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest(method.getDeclaringClass().getName(),
                method.getName(),method.getParameterTypes(),args);
        RpcResponse response = client.sendRequest(request);
        assert response != null;
        return response.getObject();
    }

    <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }
}
