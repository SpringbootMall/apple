package com.apple.mall.controller.mall;

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
public class ShopApplyController {

    @Resource
    private ShopService shopService;

    @GetMapping("/shopapply")
    public String usersPage(HttpServletRequest request) {
        request.setAttribute("path", "shopapply");
        return "admin/mall_shopapply";
    }

    @RequestMapping(value = "/shopapply/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list1(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(shopService.getShopApplyPage(pageUtil));
    }

    /**
     * 用户申请 0-申请 1-通过 2-拒绝
     */
    @RequestMapping(value = "/shopapply/modifyApply/{applyStatus}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids, @PathVariable int applyStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (applyStatus != 0 && applyStatus != 1 && applyStatus != 2) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if (shopService.modifyShopsApply(ids, applyStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("禁用失败");
        }
    }
}