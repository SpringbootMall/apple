package com.apple.mall.dao;

import com.apple.mall.entity.ShopUserComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ShopUserCommentMapper {
    int deleteByPrimaryKey(Long orderNo,Long goodsId);

    int insert(ShopUserComment record);

    int insertSelective(ShopUserComment record);

    List<ShopUserComment> selectByOrderNo(Long orderNo);

    ShopUserComment selectByPrimaryKey(Long orderNo,Long goodsId);

    ShopUserComment selectByUserIdAndGoodsId(@Param("UserId") Long shopUserId, @Param("orderId") Long goodsId);

    List<ShopUserComment> selectByUserId(@Param("UserId") Long shopUserId);

    List<ShopUserComment> selectByGoodsId(@Param("GoodsId") Long GoodsId);

    int selectCountByUserId(Long newBeeMallUserId);

    int updateByPrimaryKeySelective(ShopUserComment record);

    int updateByPrimaryKey(ShopUserComment record);

    int updateByOrderNo(ShopUserComment record);

    int deleteBatch(List<Long> ids);

    int deleteByOrderNo(@Param("orderNo") Long orderNo);

    List<ShopUserComment> findComment(Long id);
}
