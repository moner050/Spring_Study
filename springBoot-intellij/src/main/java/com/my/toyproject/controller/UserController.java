package com.my.toyproject.controller;

import com.my.toyproject.domain.User;
import com.my.toyproject.persistence.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public String insertUser(@RequestBody User user) {
        userRepository.save(user); // save() 메소드는 등록, 수정을 모두 처리할 때 사용한다.
        return user.getUsername() + "님 회원가입 성공";
    }


    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id) {
        // 특정 id(회원 번호)에 해당하는 User 객체를 리턴한다.
        User findUser = userRepository.findById(id).get();
        return findUser;
    }

    @PutMapping("/user")
    @Transactional
    public String updateUser(@RequestBody User user){
        Optional<User> findEntity = userRepository.findById(user.getId());
        if(findEntity.isPresent()) {
            User findUser = findEntity.get();
            findUser.setUsername(user.getUsername());
            findUser.setPassword(user.getPassword());
            findUser.setEmail(user.getEmail());
            userRepository.save(findUser);
            return "회원 수정 성공";
        }
        else return user.getId() + "번 회원이 없습니다.";

    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "회원 삭제 성공";
    }
    @GetMapping("/user/list")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @GetMapping("/user/page")
    public Page<User> getUserListPaging(
        @PageableDefault(page = 0, size = 1, direction = Sort.Direction.DESC,
            sort = {"id"}) Pageable pageable) {
        // 첫 번째 페이지(0)에 해당하는 2개의 데이터를 조회하되 id를 내림 차순 정렬한다.
        return userRepository.findAll(pageable);
    }

}

