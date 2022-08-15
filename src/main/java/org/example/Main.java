package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import static org.example.FileUtils.*;

public class Main {
    public static String REMOTE_SERVICE_URL =
        "https://api.nasa.gov/planetary/apod?api_key=iyE88zh5pFaQm5ySu0eylI2tGvkDLxcSbFTq1yyk";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(30000)
                .setRedirectsEnabled(false)
                .build())
            .build()
        ) {
            String userProjectPath = "C://Work//Netology//javacore-9-http-extra";
            HttpGet request = new HttpGet(REMOTE_SERVICE_URL);

            try(CloseableHttpResponse response = httpClient.execute(request)) {
                NasaResponse post = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});
                downloadPicture(httpClient, post.getUrl(), userProjectPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void downloadPicture(CloseableHttpClient httpClient, String url, String userProjectPath) {
        HttpGet request = new HttpGet(url);

        try(CloseableHttpResponse response = httpClient.execute(request)) {
            byte[] post = response.getEntity().getContent().readAllBytes();
            String fileName = getFileNameFromUrl(url);
            createNewFile(userProjectPath, fileName);
            writeBytesToFile(userProjectPath, fileName, post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
