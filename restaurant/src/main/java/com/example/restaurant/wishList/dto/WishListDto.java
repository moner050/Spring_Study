package com.example.restaurant.wishList.dto;

import com.example.restaurant.db.MemoryDBEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListDto extends MemoryDBEntity {

    // db의 Entity 가 변경되어버리면 프론트까지 변수명을 변경해야 하기 때문에
    // 그런 귀찮은 점을 없에기 위해서 따로 분리를 시킴

    private int index;
    private String title;                   // 음식명, 장소명
    private String category;                // 카테고리
    private String address;                 // 주소
    private String roadAddress;             // 도로명 주소
    private String homePageLink;            // 홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문 여부
    private int visitCount;                 // 방문 카운트
    private LocalDateTime lastVisitDate;    // 마지막 방문일자



}
