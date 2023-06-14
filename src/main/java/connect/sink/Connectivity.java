package connect.sink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

public class Connectivity {
    
    public static String getResponse(String uriString) throws IOException {
        URI uri = URI.create(uriString);
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        return "" + conn.getResponseCode() + " " + conn.getResponseMessage();
    }
}
