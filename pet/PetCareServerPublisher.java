package pet;

import javax.xml.ws.Endpoint;

public class PetCareServerPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9876/pet", new PetCareServerImpl());
    }
}
