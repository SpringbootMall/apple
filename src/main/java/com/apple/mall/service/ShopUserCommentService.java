package com.apple.mall.service;

import com.apple.mall.controller.vo.ShopUserCommentVO;
import com.apple.mall.entity.ShopUserComment;

import java.util.List;

public interface ShopUserCommentService {
    /**
     * 保存评论
     *
     * @param shopUserComment
     * @return
     */
    String saveShopUserComment(ShopUserComment shopUserComment);

    /**
     * 修改评论
     *
     * @param shopUserComment
     * @return
     */
    String updateShopUserComment(ShopUserComment shopUserComment);

    /**
     * 获取评论详情
     *
     * @param orderNo
     * @param goodsId
     * @return
     */
    ShopUserComment getShopUserCommentById(Long orderNo, Long goodsId);

    /**
     * 删除评论
     *
     * @param orderNo
     * @param goodsId
     * @return
     */
    Boolean deleteById(Long orderNo, Long goodsId);

    /**
     * 获取我的评论数据
     *
     * @param shopUserId
     * @return
     */
    List<ShopUserCommentVO> getMyShopComment(Long shopUserId);
}
