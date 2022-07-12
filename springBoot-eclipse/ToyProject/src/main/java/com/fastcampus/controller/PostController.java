package com.fastcampus.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.User;
import com.fastcampus.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
    @GetMapping({"", "/"})
    public String getPostList() {
        return "welcome";
    }
    
    @GetMapping("/post/insertPost")
    public String insertPost() {
        return "post/insertPost";
    }
    
    @PostMapping("/post/insertPost")
    public @ResponseBody String insertPost(@RequestBody Post post, HttpSession session) {
    	// Post객체를 등록하기 위해서는 반드시 User 객체를 Post 에 설정해줘야 한다.
    	// 그래야 Post 가 POST 테이블에 등록될 때 FK(USER_ID) 컬럼에 회원의 PK(ID)	를 등록해준다.
    	User principal = (User) session.getAttribute("principal");
    	post.setUser(principal);
    	postService.insertPost(post);
        return "새로운 1:1 문의를 등록했습니다.";
    }
}
