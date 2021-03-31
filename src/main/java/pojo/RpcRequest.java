package pojo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author faye
 */
public class RpcRequest implements Serializable{
    private String interfaceName;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] paramaters;

    public RpcRequest(String interfaceName, String methodName, Class<?>[] parameterTypes, Object[] paramaters) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.paramaters = paramaters;
    }

    public RpcRequest() {
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParamaters() {
        return paramaters;
    }

    public void setParamaters(Object[] paramaters) {
        this.paramaters = paramaters;
    }

    @Override
    public String toString() {
        return "Request{" +
                "interfaceName='" + interfaceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", paramaters=" + Arrays.toString(paramaters) +
                '}';
    }
}
