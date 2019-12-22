package com.apple.mall.controller.seller;

import com.apple.mall.controller.vo.UserVO;
import com.apple.mall.dao.UserApplyMapper;
import com.apple.mall.entity.MallUser;
import com.apple.mall.entity.UserApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserApplyController {
    @Autowired
    UserApplyMapper userApplyMapper;
    @RequestMapping("/becomeSeller")
    public String becomeSeller(){
        return "seller/becomeSeller";
    }
    @RequestMapping("/userApplyVerify")
    public String userApplyVerify(UserApply userApply, HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("newBeeMallUser");
        userApply.setApplyUserID(userVO.getUserId());
        Date date=new Date();
        userApply.setApplyTime(date);
        userApplyMapper.insertUserApply(userApply);
        return "seller/applySuccess";
    }
}
