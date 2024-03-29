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
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/users")
    public String usersPage(HttpServletRequest request) {
        request.setAttribute("path", "users");
        return "admin/mall_user";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(userService.getNewBeeMallUsersPage(pageUtil));
    }



    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     */
    @RequestMapping(value = "/users/lock/{lockStatus}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids, @PathVariable int lockStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (lockStatus != 0 && lockStatus != 1 && lockStatus != 2) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if (userService.lockUsers(ids, lockStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("禁用失败");
        }
    }

    /**
     * 用户类型权限修改 0-会员 1-商家
     */
    @RequestMapping(value = "/users/modifyRight/{rightStatus}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete1(@RequestBody Integer[] ids, @PathVariable int rightStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (rightStatus != 0 && rightStatus != 1) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if (userService.modifyUsersRight(ids, rightStatus) && userService.modifyUsersApply(ids, rightStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("禁用失败");
        }
    }

//    /**
//     * 用户申请 0-申请 1-通过 2-拒绝
//     */
//    @RequestMapping(value = "/users/modifyRight/{applyStatus}", method = RequestMethod.POST)
//    @ResponseBody
//    public Result delete2(@RequestBody Integer[] ids, @PathVariable int applyStatus) {
//        if (ids.length < 1) {
//            return ResultGenerator.genFailResult("参数异常！");
//        }
//        if (applyStatus != 0 && applyStatus != 1) {
//            return ResultGenerator.genFailResult("操作非法！");
//        }
//        if (userService.modifyUsersApply(ids, applyStatus)) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("禁用失败");
//        }
//    }
}