package server;

import java.util.HashMap;
import java.util.Map;

/**
 * @author faye
 */
public class ServiceProvider {
    private final Map<String,Object> serviceMap;

    public ServiceProvider() {
        this.serviceMap = new HashMap<>();
    }

    public void addServiceInterface(Object service){
        Class<?>[] T =  service.getClass().getInterfaces();
        for (Class<?> c:T){
            serviceMap.put(c.getName(),service);
        }
    }

    public Object getService(String interfaceName){
        return serviceMap.get(interfaceName);
    }
}
