
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoadBalancer {
    final private List<Server> servers;

    public LoadBalancer() {
        servers = new ArrayList<>();
    }

    public void addServer(String ipAddress, int currentLoad){
        servers.add(new Server(ipAddress, currentLoad));
    }

    public String getNextServer() {
        if(servers.isEmpty()){
            throw new IllegalStateException("No servers avaialable in the load balancer");
        }

        Server minLoadServer = servers.get(0);

        for(Server server: servers){
            if(server.getCurrentLoad() < minLoadServer.getCurrentLoad()){
                minLoadServer = server;
            }
        }

        minLoadServer.incrementLoad();

        return minLoadServer.getIpAddress();
    }

    public void removeServer(String ip){
        Iterator<Server> iterator = servers.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getIpAddress().equals(ip)) {
                iterator.remove();
                System.out.println("Server " + ip + " removed.");
                return;
            }
        }

        throw new IllegalArgumentException("No server found IP: " + ip);
    }

    public Server getNextServerObject() {
        if(servers.isEmpty()) {
            throw new IllegalArgumentException("No servers avaialble.");
        }

        Server minLoadServer = servers.get(0);

        for(Server server: servers){
            if(server.getCurrentLoad() < minLoadServer.getCurrentLoad()) {
                minLoadServer = server;
            }
        }

        return minLoadServer;
    }

    public void getCurrentLoad(String ip) {
        for(Server server: servers){
            if(server.getIpAddress().equals(ip)) {
                System.out.println("Server " + ip + " has a load of " + server.getCurrentLoad());
                return;
            }
        }

        throw new IllegalArgumentException("No matching server found.");
    }

    public void decayAllServers() {
        for(Server server: servers) {
            server.decayLoad();
        }

        System.out.println("Load decayed on all servers.");
    }

    public void getAllServersLoads() {
        for(Server server: servers){
            System.out.println("Server " + server.getIpAddress() + " | Load: " + server.getCurrentLoad());
        }
    }
}
