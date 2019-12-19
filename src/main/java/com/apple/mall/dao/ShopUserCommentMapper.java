package com.apple.mall.dao;

import com.apple.mall.entity.ShopUserComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ShopUserCommentMapper {
    int deleteByPrimaryKey(Long orderNo,Long goodsId);

    int insert(ShopUserComment record);

    int insertSelective(ShopUserComment record);

    ShopUserComment selectByPrimaryKey(Long orderNo,Long goodsId);

    ShopUserComment selectByUserIdAndGoodsId(@Param("UserId") Long shopUserId, @Param("orderId") Long goodsId);

    List<ShopUserComment> selectByUserId(@Param("UserId") Long shopUserId);

    int selectCountByUserId(Long newBeeMallUserId);

    int updateByPrimaryKeySelective(ShopUserComment record);

    int updateByPrimaryKey(ShopUserComment record);

    int deleteBatch(List<Long> ids);
}
