package com.apple.mall.controller.admin;

import com.apple.mall.service.ShopManageService;
import com.apple.mall.service.ShopService;
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
public class AdminShopController {

    @Resource
    private ShopManageService shopManageService;

    /*未实现*/
    @GetMapping("/shops")
    public String usersPage(HttpServletRequest request) {
        request.setAttribute("path", "shops");
        return "admin/mall_shop";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/shops/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(shopManageService.getMallShopsPage(pageUtil));
    }

    /**
     * 商铺禁用与解除禁用(0-未锁定 1-已锁定)
     */
    @RequestMapping(value = "/shops/lock/{lockStatus}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids, @PathVariable int lockStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (lockStatus != 0 && lockStatus != 1 && lockStatus != 2) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if (shopManageService.lockShops(ids, lockStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("禁用失败");
        }
    }
}