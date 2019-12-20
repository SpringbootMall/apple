package com.apple.mall.service.impl;

import com.apple.mall.dao.PostMapper;
import com.apple.mall.entity.Post;
import com.apple.mall.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    PostMapper postMapper;

    @Override
    public List<Post> findAll(){
    return postMapper.findAll();
}

    @Override
    public Post add(Post post){
        return postMapper.add(post);
    }

    @Override
    public void addOne(int id){
        postMapper.addOne(id);
    }

    @Override
    public Post find(int id){
        return postMapper.find(id);
    }
}
