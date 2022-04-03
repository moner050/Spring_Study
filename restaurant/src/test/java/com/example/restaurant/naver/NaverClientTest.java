package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;


    // 검색 테스트
    @Test
    public void searchLocalTest()
    {
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result =  naverClient.searchLocal(search);

        // 카테고리의 값이 Null 값이면 안된다.
        Assertions.assertNotNull(result.getItems().stream().findFirst().get().getCategory());
        System.out.println(result);
    }

    // 이미지 검색 테스트
    @Test
    public void searchImageTest()
    {
        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClient.searchImage(search);
        System.out.println(result);
    }


}
