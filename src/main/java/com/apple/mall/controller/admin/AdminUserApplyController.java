package com.apple.mall.controller.admin;

import com.apple.mall.service.UserService;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.Result;
import com.apple.mall.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminUserApplyController {

    @Resource
    private UserService userService;

    /**
     * 用户申请成为商家
     * @param request
     * @return
     */
    @GetMapping("/userapply")
    public String userApplyPage(HttpServletRequest request) {
        request.setAttribute("path", "userapply");
        return "admin/mall_userapply";
    }

    @RequestMapping(value = "/userapply/list1", method = RequestMethod.GET)
    @ResponseBody
    public Result list1(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(userService.getUserApplyPage(pageUtil));
    }

    /**
     * 用户申请 0-申请 1-通过 2-拒绝
     */
    @RequestMapping(value = "/userapply/modifyApply/{applyStatus}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete3(@RequestBody Integer[] ids, @PathVariable int applyStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (applyStatus != 0 && applyStatus != 1 && applyStatus != 2) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if(applyStatus == 1){//成为商家
            System.out.println("执行分路1");


            if (userService.modifyUsersApply(ids, applyStatus) && userService.modifyUsersRight(ids, applyStatus)) {
                //若管理员同意申请，则user_apply表apply_flag置1，user表right_flag置1
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("禁用失败");
            }

//            Integer[] ids1 = ids;
//            Integer[] ids2 = ids;
//            int applyStatus1 = applyStatus;
//            int applyStatus2 = applyStatus;
//
//            userService.modifyUsersRight(ids2, applyStatus2);
//            userService.modifyUsersApply(ids1, applyStatus1);
//
//                //若管理员同意申请，则user_apply表apply_flag置1，user表right_flag置1
//                return ResultGenerator.genSuccessResult();


        }
        else {
            System.out.println("执行分路2");
            if (userService.modifyUsersApply(ids, applyStatus)) {
                //若管理员同意申请，则user_apply表apply_flag置1，user表right_flag置1
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("禁用失败");
            }
        }

    }
}
