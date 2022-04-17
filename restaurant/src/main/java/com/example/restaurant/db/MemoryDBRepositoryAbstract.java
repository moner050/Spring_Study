package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDBRepositoryAbstract<T extends MemoryDBEntity> implements MemoryDBRepositoryIfs<T>{

    // 데이터를 저장할 ArrayList 가 필요
    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        // getIndex 의 값이 index 의 값과 동일하다고 한것중 첫번째를 찾기
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty())
        {   // db 에 데이터가 없는 경우
            index++;                    // 인덱스를 ++시켜주고
            entity.setIndex(index);     // 인덱스를 세팅해준다음
            db.add(entity);             // db 에 저장후
            return entity;              // 타입을 리턴시켜준다.
        }
        else
        {   // db 에 이미 데이터가 있는 경우

            // 이미 있던 데이터의 인덱스를 가져와서서
            var preIndex = optionalEntity.get().getIndex();
            // 인덱스를 세팅해주고
            entity.setIndex(preIndex);
            // 기존에 있던 데이터를 지워준다음
            deleteById(preIndex);
            // 새로운 entity 를 db 에 저장 후
            db.add(entity);
            // 타입을 리턴시켜준다.
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();

        // 만약 데이터가 이미 있는 경우
        if(optionalEntity.isPresent())
        {   // 해당 object 와 동일한 해당 Entity 를 찾아서 지운다.
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        // db 에 있는 모든 내용을 return
        return db;
    }
}
