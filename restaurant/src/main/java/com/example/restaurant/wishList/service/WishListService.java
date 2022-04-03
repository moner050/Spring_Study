package com.example.restaurant.wishList.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishList.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {

    // 필요한 내용들을 만들어주는 서비스 개발
    private final NaverClient naverClient;

    public WishListDto search(String query)
    {
        // 지역검색 후
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        // 만약 검색결과가 있다면
        if(searchLocalRes.getTotal() > 0)
        {   // 첫번째 아이템을 담아준다.
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            // 이상한 문자열(특수문자)을 전부 제거하기 위해 정규식 사용
            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.searchImage(searchImageReq);

            // 이미지 검색 결과가 있을때
            if(searchLocalRes.getTotal() > 0)
            {   // 결과 출력
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());

                return result;
            }
        }
        // 검색 결과가 없으면 빈값을 리턴 시켜준다.
        return new WishListDto();
    }

}
