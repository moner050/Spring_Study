package com.apitest.finlife.controller;

import com.apitest.finlife.dto.FinDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.apitest.config.ApiKeyConfiguration.FIN_BASE;
import static com.apitest.config.ApiKeyConfiguration.FIN_KEY;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FinController {

    private final WebClient.Builder webClient;

    // 금융상품 검색
    @GetMapping("/search")
    public FinDto searchFinProduct(){
        String result = "", line;
        BufferedReader br = null;

        FinDto finDto = null;

        try{
            String urlstr = FIN_BASE + "?auth=" + FIN_KEY + "&topFinGrpNo=020000&pageNo=1&financeCd=" + "0010927";

            log.info(urlstr);

            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // GET 방식으로 데이터를 가져오기
            urlConnection.setRequestMethod("GET");
            // UTF-8 로 인코딩 후 br 에 넣어주기
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            // br 에 넣은 값이 비어있지 않을 때 까지 result 에 값 넣어주기
            while((line = br.readLine()) != null) {
                result += line;
            }
            log.info(result);

            // Gson 으로 finDto 정보 받아오기
            Gson gson = new Gson();
            finDto = gson.fromJson(result, FinDto.class);

            return finDto;
        } catch (Exception e) {
            e.printStackTrace();
            return new FinDto();
        }
    }

}
