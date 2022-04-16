package com.example.restaurant.controller;

import com.example.restaurant.wishList.dto.WishListDto;
import com.example.restaurant.wishList.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto)
    {
        log.info("{}", wishListDto);

        return wishListService.add(wishListDto);
    }

    // 전체 리스트 가져오기
    @GetMapping("/all")
    public List<WishListDto> findAll()
    {
        return wishListService.findAll();
    }
}
