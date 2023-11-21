package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {

        new MyTelegramBot("@Nasa_Pictureofday_bot", "6696549606:AAGLIRm9Pg87i2rghidrgm6uobAbz6cVG3w");
    }

}
//        String url = "https://api.nasa.gov/planetary/apod?api_key=FVxCIdXfwDlOTzghLkfghHFFbpG7e5EsPd1o5Hw9";
//        CloseableHttpClient client = HttpClients.createDefault();
//        ObjectMapper mapper = new ObjectMapper();
//
//        CloseableHttpResponse response = client.execute(new HttpGet(url));
////        Scanner sc = new Scanner(response.getEntity().getContent());
////        System.out.println(sc.nextLine());
//
//
//        NasaAnswer1 answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer1.class);
//
//        String urlImage = answer.url;
//        String[] separated = urlImage.split("/");
//        String filename = separated[separated.length - 1];
//
//        CloseableHttpResponse image = client.execute(new HttpGet(answer.url));
//        FileOutputStream fos = new FileOutputStream(filename);
//        image.getEntity().writeTo(fos);




