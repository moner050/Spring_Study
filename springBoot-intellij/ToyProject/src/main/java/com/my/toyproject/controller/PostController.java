package com.my.toyproject.controller;

import com.my.toyproject.domain.Post;
import com.my.toyproject.domain.User;
import com.my.toyproject.security.UserDetailsImpl;
import com.my.toyproject.service.PostService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping({"", "/"})
    public String getPostList(
        Model model, @PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {

        model.addAttribute("postList", postService.getPostList(pageable));
        return "welcome";
    }

    // 1:1 문의 사이트 이동하기
    @GetMapping("/post/insertPost")
    public String insertPost(){
        return "post/insertPost";
    }

    // 1:1 문의 글 올리기
    @PostMapping("/post/insertPost")
    public @ResponseBody String insertPost(@RequestBody Post post, @AuthenticationPrincipal
        UserDetailsImpl userDetailsImpl){
        // Post 객체를 등록하기 위해서는 반드시 User 객체를 Post 에 설정해줘야 한다.
        // 그래야 Post 가 POST 테이블에 등록될 때 FK(USER_ID) 컬럼에 회원의 PK(ID)를 등록해준다.
        User principal = userDetailsImpl.getUser();
        post.setUser(principal);
        postService.insertPost(post);

//        System.out.println(post.getUser());
        return "새로운 1:1 문의를 등록했습니다!";
    }
}
