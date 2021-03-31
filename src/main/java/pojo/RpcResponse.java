package pojo;

import java.io.Serializable;

/**
 * @author faye
 */
public class RpcResponse implements Serializable {
    private int code;
    private String msg;
    private Object object;

    public static RpcResponse success(Object object){
        RpcResponse r = new RpcResponse();
        r.object = object;
        r.code = 1;
        r.msg = "success";
        return r;
    }

    public static RpcResponse fail(){
        RpcResponse r = new RpcResponse();
        r.msg = "fail";
        r.code = 0;
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}
