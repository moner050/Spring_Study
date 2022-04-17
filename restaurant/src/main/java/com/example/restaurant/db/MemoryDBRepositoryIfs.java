package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDBRepositoryIfs<T> {

    // 타입에대해 옵셔녈하게 값을 리턴해줌.
    Optional<T> findById(int index);
    // 저장
    T save(T entity);
    // 삭제
    void deleteById(int index);
    // 전체리턴
    List<T> findAll();
}
