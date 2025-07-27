
import java.util.ArrayList;
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

    public void getCurrentLoad(String ip) {
        for(Server server: servers){
            if(server.getIpAddress().equals(ip)) {
                System.out.println("Server " + ip + " has a load of " + server.getCurrentLoad());
                return;
            }
        }

        System.out.println("So matching server found.");
    }
}
