package com.apple.mall.service.impl;


import com.apple.mall.common.ServiceResultEnum;
import com.apple.mall.controller.vo.ShopUserCommentVO;
import com.apple.mall.dao.OrderMapper;
import com.apple.mall.dao.ShopUserCommentMapper;
import com.apple.mall.entity.ShopUserComment;
import com.apple.mall.service.ShopUserCommentService;
import com.apple.mall.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShopUserCommentServiceImpl implements ShopUserCommentService {

    @Autowired
    private ShopUserCommentMapper shopUserCommentMapper;

    @Autowired
    private OrderMapper orderMapper;

    //todo 修改session中购物项数量

    @Override
    public String saveShopUserComment(ShopUserComment shopUserComment) {
        System.out.println(shopUserComment.getOrderNo());
        System.out.println(shopUserComment.getGoodsId());

        //保存记录
        ShopUserComment temp = shopUserCommentMapper.selectByPrimaryKey(shopUserComment.getOrderNo(),shopUserComment.getGoodsId());
        if (temp!=null){
            shopUserCommentMapper.updateByPrimaryKeySelective(shopUserComment);
            //修改订单状态
            orderMapper.commentSuccess(shopUserComment.getOrderNo().toString());
            return ServiceResultEnum.SUCCESS.getResult();
        }
        else if (shopUserCommentMapper.insertSelective(shopUserComment) > 0) {
            //修改订单状态
            orderMapper.commentSuccess(shopUserComment.getOrderNo().toString());
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateShopUserComment(ShopUserComment shopUserComment) {
        ShopUserComment temp = shopUserCommentMapper.selectByUserIdAndGoodsId(shopUserComment.getUserId(), shopUserComment.getGoodsId());
        if (temp != null) {
            //已存在则修改该记录
            temp.setUserEvaluation(shopUserComment.getUserEvaluation());
            temp.setGoodsScore(shopUserComment.getGoodsScore());
            temp.setServiceScore(shopUserComment.getServiceScore());
            temp.setLogisticsScore(shopUserComment.getLogisticsScore());
            return updateShopUserComment(temp);
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public ShopUserComment getShopUserCommentById(Long orderNo, Long orderId) {
        return shopUserCommentMapper.selectByPrimaryKey(orderNo,orderId);
    }

    @Override
    public Boolean deleteById(Long orderNo, Long goodsId) {
        return shopUserCommentMapper.deleteByPrimaryKey(orderNo,goodsId) > 0;
    }

    @Override
    public List<ShopUserCommentVO> getMyShopComment(Long shopUserId) {
        List<ShopUserCommentVO> shopUserCommentVOS = new ArrayList<>();
        List<ShopUserComment> shopUserComments = shopUserCommentMapper.selectByUserId(shopUserId);
        if (!CollectionUtils.isEmpty(shopUserComments)) {
            //添加查询信息
            for (ShopUserComment shopUserComment : shopUserComments) {
                ShopUserCommentVO shopUserCommentVO = new ShopUserCommentVO();
                BeanUtil.copyProperties(shopUserComment, shopUserCommentVO);
                shopUserCommentVOS.add(shopUserCommentVO);

            }
        }
        return shopUserCommentVOS;
    }

    @Override
    public List<ShopUserComment> getGoodsCommentById(Long goodsId) {
        return shopUserCommentMapper.selectByGoodsId(goodsId);
    }

    @Override
    public int deleteByOrderNo(Long orderNo) {
        return shopUserCommentMapper.deleteByOrderNo(orderNo);
    }

    @Override
    public List<ShopUserComment> getShopUserCommentByOrderNo(Long orderNo) {
        return shopUserCommentMapper.selectByOrderNo(orderNo);
    }

}
