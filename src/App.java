public class App {
    public static void main(String[] args) throws Exception {
        LoadBalancer loadBalancer = new LoadBalancer();

        loadBalancer.addServer("192.168.1.10", 10);
        loadBalancer.addServer("192.168.1.11", 10);
        loadBalancer.addServer("192.168.1.12", 10);

        String ipAddress1 = loadBalancer.getNextServer();
        System.out.println("Request routed to server: " + ipAddress1);

        String ipAddress2 = loadBalancer.getNextServer();
        System.out.println("Request routed to server: " + ipAddress2);

        String ipAddress3 = loadBalancer.getNextServer();
        System.out.println("Request routed to server: " + ipAddress3);

        String ipAddress4 = loadBalancer.getNextServer();
        System.out.println("Request routed to server: " + ipAddress4);

        loadBalancer.getCurrentLoad("192.168.1.10");
        loadBalancer.getCurrentLoad("192.168.1.11");
        loadBalancer.getCurrentLoad("192.168.1.12");
    }
}
