package com.apple.mall.service;
import com.apple.mall.entity.Post;
import java.util.List;


public interface PostService {


   List<Post> findAll();

   Post add(Post post);
   void addOne(int id);

   Post find(int id);
}
