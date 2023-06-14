package connect.sink;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectivityTest {
    
    private final Logger log = LoggerFactory.getLogger(ConnectivityTest.class);

    private final String ENDPOINTS = "http://sl-schema-registry:8081,http://localhost:8081";

    @Test
    public void connectivityTest() {
        for (String endpoint : ENDPOINTS.split(",")) {
            try {
                String response = Connectivity.getResponse(endpoint);
                assertNotNull(response);
                log.info("Got response for endpoint " + endpoint + ": " + Connectivity.getResponse(endpoint));
            } catch (IOException e) {
                log.error("Failed to get response for endpoint " + endpoint + ". Error: " + e.getMessage());
            }
        }
    }

}
