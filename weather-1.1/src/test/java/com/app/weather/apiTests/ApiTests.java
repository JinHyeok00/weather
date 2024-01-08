package com.app.weather.apiTests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest
@Slf4j
public class ApiTests {

    //    중기 육상 예보 조회
    @Test
    public void getMid() throws IOException, InterruptedException {
        String key = "Ro42m3hfgXWsb0ZtX%2FVATvRW%2F027tmCoXL2ODMTYHH9IehqBIU9%2BoPraT67HNlst7MsbISk0CxiLTyYjdB1IaA%3D%3D";

        URI uri = URI.create("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst" +
                "?serviceKey=" + key +
                "&pageNo=1" +
                "&numOfRows=10" +
                "&dataType=JSON" +
                "&stnId=109" +
                "&tmFc=202401080600");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    //단기 예보조회
    @Test
    public void getShortService() throws IOException, InterruptedException {
        String key = "Ro42m3hfgXWsb0ZtX%2FVATvRW%2F027tmCoXL2ODMTYHH9IehqBIU9%2BoPraT67HNlst7MsbISk0CxiLTyYjdB1IaA%3D%3D";

        URI uri = URI.create("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst" +
                "?serviceKey=" + key +
                "&pageNo=1" +
                "&numOfRows=1000" +
                "&dataType=JSON" +
                "&base_date=20240108" +
                "&base_time=0800" +
                "&nx=55" +
                "&ny=127");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    //초단기 예보조회
    @Test
    public void getVeryShortService() throws IOException, InterruptedException {
        String key = "Ro42m3hfgXWsb0ZtX%2FVATvRW%2F027tmCoXL2ODMTYHH9IehqBIU9%2BoPraT67HNlst7MsbISk0CxiLTyYjdB1IaA%3D%3D";

        URI uri = URI.create("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst" +
                "?serviceKey=" + key +
                "&pageNo=1" +
                "&numOfRows=100" +
                "&dataType=JSON" +
                "&base_date=20231213" +
                "&base_time=2330" +
                "&nx=55" +
                "&ny=127");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
