package com.apple.mall.dao;

import com.apple.mall.entity.Post;
import java.util.List;


public interface PostMapper {
    List<Post> findAll();

    Post add(Post post);

    void addOne(int id);

    Post find(int id);
}
