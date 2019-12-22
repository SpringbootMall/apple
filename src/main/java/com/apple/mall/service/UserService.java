package com.apple.mall.service;

import com.apple.mall.controller.vo.UserVO;
import com.apple.mall.entity.MallUser;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.PageResult;

import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil);

    /**
     * 后台分页--用户申请商家
     *
     * @param pageUtil
     * @return
     */
    PageResult getUserApplyPage(PageQueryUtil pageUtil);

    /**
     * 用户注册
     *
     * @param loginName
     * @param password
     * @return
     */
    String register(String loginName, String password);

    /**
     * 登录
     *
     * @param loginName
     * @param passwordMD5
     * @param httpSession
     * @return
     */
    String login(String loginName, String passwordMD5, HttpSession httpSession);

    /**
     * 用户信息修改并返回最新的用户信息
     *
     * @param mallUser
     * @return
     */
    UserVO updateUserInfo(MallUser mallUser, HttpSession httpSession);

    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    Boolean lockUsers(Integer[] ids, int lockStatus);

    /**
     * 修改用户类型
     *
     * @param ids
     * @param rightStatus
     * @return
     */
    Boolean modifyUsersRight(Integer[] ids, int rightStatus);

    /**
     * 表user_apply
     * 修改用户申请
     *
     * @param ids
     * @param applyStatus
     * @return
     */
    Boolean modifyUsersApply(Integer[] ids, int applyStatus);

}
