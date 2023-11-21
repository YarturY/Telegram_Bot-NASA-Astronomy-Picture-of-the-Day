package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.NasaAnswer1;

import java.io.IOException;

public class Tools1 {
    public static String getUrl(String nasaUrl) {
        CloseableHttpClient client = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();

        CloseableHttpResponse response = null;
        NasaAnswer1 answer = null;

        try {
            response = client.execute(new HttpGet(nasaUrl));
            answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer1.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return answer.url;

    }

}
