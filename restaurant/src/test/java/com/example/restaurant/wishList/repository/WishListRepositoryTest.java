package com.example.restaurant.wishList.repository;

import com.example.restaurant.wishList.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create()
    {
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("RoadAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }

    @Test
    public void saveTest()
    {
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());            // 첫번째 인덱스를 가지고있으면 정상적으로 save

    }

    @Test
    public void updateTest()
    {
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);

        expected.setTitle("update test");
        var saveEntity = wishListRepository.save(expected);

        Assertions.assertEquals("update test", saveEntity.getTitle());      // title 의 내용이 update test 이면 정상
        Assertions.assertEquals(1, wishListRepository.findAll().size());    // listAll 의 사이즈가 1이어야 한다.
    }

    @Test
    public void findByIdTest()
    {
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        var expected= wishListRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());        // 안에 값이 있어야한다.
        Assertions.assertEquals(1, expected.get().getIndex());      // 안에 값이 있을때 1 이면 정상
    }

    @Test
    public void deleteTest()
    {
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);                             // 1번을 찾아 지워주고

        int count = wishListRepository.findAll().size();                    // 전체 리스트의 사이즈를 count 에 넣어줌

        Assertions.assertEquals(0, count);                          // 안에 값이 0일때 정상
    }

    @Test
    public void findAllTest()
    {
        var wishListEntity1 = create();
        wishListRepository.save(wishListEntity1);

        var wishListEntity2 = create();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.findAll().size();                    // 전체 리스트의 사이즈를 count 에 넣어줌
        Assertions.assertEquals(2, count);                          // count 의 값이 2이면 정상

    }
}
