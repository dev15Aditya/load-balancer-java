public class Request {
    final private String payload;
    final private int size;

    public Request(String payload, int size){
        this.payload = payload;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getPayload() {
        return payload;
    }
}
