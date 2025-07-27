public class Server {
    final private String ipAddress;
    private int currentLoad;

    public Server(String ipAddress, int currentLoad){
        this.ipAddress = ipAddress;
        this.currentLoad = currentLoad;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void incrementLoad() {
        currentLoad++;
    }

    public void decayLoad() {
        if(currentLoad > 0) currentLoad--;
    }

    public void handleRequest(Request request){
        incrementLoad();
        System.out.println("Server " + ipAddress + " handled request: " + request.getPayload());
    }
}
