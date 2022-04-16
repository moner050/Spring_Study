package com.example.restaurant.wishList.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishList.dto.WishListDto;
import com.example.restaurant.wishList.entity.WishListEntity;
import com.example.restaurant.wishList.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    // 필요한 내용들을 만들어주는 서비스 개발
    private final NaverClient naverClient;
    // DB 를 불러오기 위해 불러오기
    private final WishListRepository wishListRepository;

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
            if(searchImageRes.getTotal() > 0)
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

    // 위시 리스트 추가
    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);
        var saveEntity = wishListRepository.save(entity);
        return entityToDto(saveEntity);

    }

    // dto 를 Entity 로 변화시키기
    private WishListEntity dtoToEntity(WishListDto wishListDto)
    {
        var entity = new WishListEntity();
        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setVisit(wishListDto.isVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        entity.setLastVisitDate(wishListDto.getLastVisitDate());
        return entity;
    }

    // Entity 를 dto 로 변화시키기
    private WishListDto entityToDto(WishListEntity wishListEntity)
    {
        var Dto = new WishListDto();
        Dto.setIndex(wishListEntity.getIndex());
        Dto.setTitle(wishListEntity.getTitle());
        Dto.setCategory(wishListEntity.getCategory());
        Dto.setAddress(wishListEntity.getAddress());
        Dto.setRoadAddress(wishListEntity.getRoadAddress());
        Dto.setHomePageLink(wishListEntity.getHomePageLink());
        Dto.setImageLink(wishListEntity.getImageLink());
        Dto.setVisit(wishListEntity.isVisit());
        Dto.setVisitCount(wishListEntity.getVisitCount());
        Dto.setLastVisitDate(wishListEntity.getLastVisitDate());
        return Dto;
    }

    public List<WishListDto> findAll() {


        return wishListRepository.listAll()
                .stream()               // listAll 에 stream 을 걸고
                .map(it -> entityToDto(it)) // map 을 통해서 entity 를 Dto 로 다 바꿔주고
                .collect(Collectors.toList()); // collect 를 통해서 toList 로 바꿔준다.

    }
}
