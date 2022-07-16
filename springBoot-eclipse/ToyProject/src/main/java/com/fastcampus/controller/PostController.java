package com.fastcampus.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.User;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.PostService;
import com.fastcampus.service.ReplyService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private ReplyService replyService;
	
	// 게시글 목록
    @GetMapping({"", "/"})
    public String getPostList(Model model, HttpSession session,
    						@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
    	session.removeAttribute("post");
    	session.removeAttribute("replyList");
    	model.addAttribute("postList", postService.getPostList(pageable));
        return "welcome";
    }
    
    // 게시글 조회
    @GetMapping("/post/{id}")
    public String getPost(@PathVariable("id") int id ,HttpSession session) {
    	session.setAttribute("post", postService.getPost(id));
    	session.setAttribute("replyList", replyService.getReplyList(id));
    	return "post/getPost";
    }
    
    // 게시글 작성페이지 가기
    @GetMapping("/post/insertPost")
    public String insertPost() {
        return "post/insertPost";
    }
    
    // 게시글 작성 처리
    @PostMapping("/post/insertPost")
    public @ResponseBody String insertPost(@RequestBody Post post, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
    	// Post객체를 등록하기 위해서는 반드시 User 객체를 Post 에 설정해줘야 한다.
    	// 그래야 Post 가 POST 테이블에 등록될 때 FK(USER_ID) 컬럼에 회원의 PK(ID)	를 등록해준다.
    	User principal = userDetailsImpl.getUser();
    	post.setUser(principal);
    	postService.insertPost(post);
        return "새로운 1:1 문의를 등록했습니다.";
    }
    
    // 게시글 수정페이지 가기
    @GetMapping("/post/updatePost/{id}")
    public String updatePost(@PathVariable("id") int id ,HttpSession session) {
    	session.setAttribute("post", postService.getPost(id));
    	return "post/insertPost";
    }
    
    // 게시글 수정하기
    @PostMapping("/post/updatePost")
    public String updatePost(@RequestBody Post post, HttpSession session) {
    	Post myPost = (Post)session.getAttribute("post");
    	
    	myPost.setTitle(post.getTitle());
    	myPost.setContent(post.getContent());
    	postService.updatePost(myPost);
    
    	return "welcome";
    }
    
    
    // 게시글 삭제하기
    @PostMapping("/post/deletePost")
    public String deletePost(HttpSession session) {
    	Post post = (Post) session.getAttribute("post");
    	postService.deletePost(post.getId());

    	return "welcome";
    }
}
