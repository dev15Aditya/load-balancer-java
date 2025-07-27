
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LoadBalancer loadBalancer = new LoadBalancer();

        loadBalancer.addServer("192.168.1.10", 5);
        loadBalancer.addServer("192.168.1.11", 6);
        loadBalancer.addServer("192.168.1.12", 7);

        // String ipAddress1 = loadBalancer.getNextServer();
        // System.out.println("Request routed to server: " + ipAddress1);

        // String ipAddress2 = loadBalancer.getNextServer();
        // System.out.println("Request routed to server: " + ipAddress2);

        // String ipAddress3 = loadBalancer.getNextServer();
        // System.out.println("Request routed to server: " + ipAddress3);

        // String ipAddress4 = loadBalancer.getNextServer();
        // System.out.println("Request routed to server: " + ipAddress4);

        // loadBalancer.getCurrentLoad("192.168.1.10");
        // loadBalancer.getCurrentLoad("192.168.1.11");
        // loadBalancer.getCurrentLoad("192.168.1.12");

        Scanner sc = new Scanner(System.in);

        while (true) { 
            System.out.println("\n=== Load Balancer Menu ===");
            System.out.println("1. Route request");
            System.out.println("2. Show Server Load");
            System.out.println("3. Remove Server");
            System.out.println("4. Decay Load (Simulate completion)");
            System.out.println("5. Show All Server Loads");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter request payload: ");
                    String payload = sc.nextLine();
                    Request req = new Request(payload, 1);
                    Server server = loadBalancer.getNextServerObject();
                    server.handleRequest(req);
                }
                case 2 -> {
                    System.out.print("Enter IP to get load: ");
                    String ip = sc.nextLine();
                    loadBalancer.getCurrentLoad(ip);
                }
                case 3 -> {
                    System.out.print("Enter IP to remove: ");
                    String removeIp = sc.nextLine();
                    loadBalancer.removeServer(removeIp);
                }
                case 4 -> loadBalancer.decayAllServers();
                case 5 -> loadBalancer.getAllServersLoads();
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }

    }
}
