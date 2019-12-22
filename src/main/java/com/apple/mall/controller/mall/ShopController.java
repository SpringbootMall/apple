package com.apple.mall.controller.mall;


import com.apple.mall.controller.vo.UserVO;
import com.apple.mall.dao.ShopMapper;
import com.apple.mall.entity.Shop;
import com.apple.mall.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    ShopMapper shopMapper;

    @RequestMapping("/shopRegister")
    public String register(HttpSession session){
//        if (session.getAttribute("newbeeMallUser").getLockedFlag()==null){ 这里我打算写一个判断登录权限
////            return ""
////        }
        return "mall/shopRegister";
    }
    @RequestMapping("/shopRegisterVerify")
    public String registerVerify(Shop shop, HttpSession session, @RequestParam("file")MultipartFile file,Model model) throws IOException {
        UserVO userVO = new UserVO();
        userVO = (UserVO) session.getAttribute("newBeeMallUser");
        shop.setSellerId(userVO.getUserId());
        shop.setShopOwner(userVO.getNickName());

//        Date date = new Date();
//        shop.setShopCreatTime(date.toString());
//
//        File path2 = new File(ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ").replace('/', '\\'));
//        if(!path2.exists()) path2 = new File("");
//        //如果上传目录为/static/images/upload/，则可以如下获取：
//        File upload2 = new File(path2.getAbsolutePath(),"img/upfile/");
//        if(!upload2.exists()) upload2.mkdirs();
//        String path=upload2.getAbsolutePath()+"/";
//        FileUploadUtils.upload(path, upload);



        byte[] bytes = file.getBytes();

        Path path = Paths.get("src\\main\\resources\\static\\mall\\image\\shops\\"+file.getOriginalFilename());

        Files.write(path, bytes);
        String image=path.toString();
        image=image.replace("\\","/");
        image=image.substring(25);
        System.out.println(image);
        shop.setShopImage(image);
        shopService.register(shop);
        return "seller/registerSuccess";
    }
//    @RequestMapping("storeOfPerson")
//    public String selectStoreByCreatorID(Model model, HttpSession session){
//        NewBeeMallUserVO newBeeMallUserVO = new NewBeeMallUserVO();
//        newBeeMallUserVO = (NewBeeMallUserVO) session.getAttribute("newBeeMallUser");
//        long creatorID = newBeeMallUserVO.getUserId();
//        List<Store> stores = storeMapper.selectStoreByCreatorID(creatorID);
//        model.addAttribute("stores",stores);
//        Store store=stores.get(0);
//        System.out.println(store.getStoreName());
//        return  "mall/storeOfPerson";
//    }


}