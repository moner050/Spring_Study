package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalRes {

    // naver api 의 출력결과를 위한 변수선언

    private String lastBuildDate;

    private int total;

    private int start;

    private int display;

    private String category;

    private List<SearchLocalItem> items;

    // items 를 보관하기 위한 클래스 생성
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchLocalItem
    {
        private String title;
        private String link;
        private String description;
        private String telephone;
        private String address;
        private String roadAddress;
        private String mapx;
        private String mapy;

    }
}
