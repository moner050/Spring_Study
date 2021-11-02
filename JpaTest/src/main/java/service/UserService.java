package service;


import domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Set;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    public void get()
    {
        Set<User> setUser = userRepository.findByEmail("test1@naver.com");
    }

    @Transactional
    public void put()
    {
//        User user = new User();
//        user.setId(30L);
//        user.setEmail("test1@abc.com");
//        user.setName("홍길동");

//        user = userRepository.save(user);

//        User user = userRepository.findById(30L).get();

//        entityManager.persist(user);    // 영속(persistance) 상태로 진입
//        user.setName("Alex");
//        userRepository.delete(user);      // 실제 삭제

//        entityManager.detach(user);   // 준영속성(depersistance) 상태로 진입
//        entityManager.clear();
//        entityManager.close();
//        entityManager.flush();
//        entityManager.merge(user);
//        entityManager.remove(user);     // 삭제

//        User user1 = userRepository.findById(31L).get();
////        User user1 = null;
//        entityManager.remove(user1);
//        entityManager.remove(user);

//        user1.setName("aaaaaaaaaaaa");
//        entityManager.merge(user1);
    }
}
