package com.apple.mall.controller.mall;

import com.apple.mall.controller.vo.UserVO;
import com.apple.mall.entity.Post;
import com.apple.mall.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @RequestMapping("/post")
    public String getAll(Model model){
        List<Post>posts = postService.findAll();
        model.addAttribute("posts",posts);
        return "mall/post";
    }

    @RequestMapping("/add")
    public int add(HttpServletRequest request){
        Post post = new Post();
        UserVO userVO = new UserVO();
        userVO= ((UserVO) request.getSession().getAttribute("newBeeMallUser"));
        String content =  request.getParameter("content");
        Date date = new Date();
        String str = "yyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        String time = sdf.format(date);
        post.setPostContent(content);
        post.setUser(userVO.getNickName());
        post.setThumbNumber(0);
        post.setPostTime(time);
        postService.add(post);
        return 1;
    }

    @RequestMapping("/addOne")
    @ResponseBody
    public int addOne(@RequestParam("id") int id){
        postService.addOne(id);
        return postService.find(id).getThumbNumber();
    }



}
