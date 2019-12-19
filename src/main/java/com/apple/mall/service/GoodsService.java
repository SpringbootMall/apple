package com.apple.mall.service;

import com.apple.mall.entity.Goods;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.PageResult;

import java.util.List;

public interface GoodsService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallGoodsPage(PageQueryUtil pageUtil);

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    String saveNewBeeMallGoods(Goods goods);

    /**
     * 批量新增商品数据
     *
     * @param goodsList
     * @return
     */
    void batchSaveNewBeeMallGoods(List<Goods> goodsList);

    /**
     * 修改商品信息
     *
     * @param goods
     * @return
     */
    String updateNewBeeMallGoods(Goods goods);




    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    Goods getNewBeeMallGoodsById(Long id);

    /**
     * 批量修改销售状态(上架下架)
     *
     * @param ids
     * @return
     */
    Boolean batchUpdateSellStatus(Long[] ids,int sellStatus);

    /**
     * 商品搜索
     *
     * @param pageUtil
     * @return
     */
    PageResult searchNewBeeMallGoods(PageQueryUtil pageUtil);

    /****首页查询商品*****/
    List<Goods> searchPage(String keyword);
    /********商店商品**************/
    List<Goods> findgoods(int id);

    List<Goods> findre(String tag);
}
