package com.apple.mall.service.impl;

import com.apple.mall.common.ServiceResultEnum;
import com.apple.mall.controller.vo.SearchGoodsVO;
import com.apple.mall.dao.GoodsMapper;
import com.apple.mall.entity.Goods;
import com.apple.mall.service.GoodsService;
import com.apple.mall.util.BeanUtil;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Primary
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageResult getNewBeeMallGoodsPage(PageQueryUtil pageUtil) {
        List<Goods> goodsList = goodsMapper.findNewBeeMallGoodsList(pageUtil);
        int total = goodsMapper.getTotalNewBeeMallGoods(pageUtil);
        PageResult pageResult = new PageResult(goodsList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveNewBeeMallGoods(Goods goods) {
        if (goodsMapper.insertSelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public void batchSaveNewBeeMallGoods(List<Goods> goodsList) {
        if (!CollectionUtils.isEmpty(goodsList)) {
            goodsMapper.batchInsert(goodsList);
        }
    }

    @Override
    public String updateNewBeeMallGoods(Goods goods) {
        Goods temp = goodsMapper.selectByPrimaryKey(goods.getGoodsId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        goods.setUpdateTime(new Date());
        if (goodsMapper.updateByPrimaryKeySelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public Goods getNewBeeMallGoodsById(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public Boolean batchUpdateSellStatus(Long[] ids, int sellStatus) {
        return goodsMapper.batchUpdateSellStatus(ids, sellStatus) > 0;
    }

    @Override
    public PageResult searchNewBeeMallGoods(PageQueryUtil pageUtil) {
        List<Goods> goodsList = goodsMapper.findNewBeeMallGoodsListBySearch(pageUtil);
        int total = goodsMapper.getTotalNewBeeMallGoodsBySearch(pageUtil);
        List<SearchGoodsVO> searchGoodsVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodsList)) {
            searchGoodsVOS = BeanUtil.copyList(goodsList, SearchGoodsVO.class);
            for (SearchGoodsVO searchGoodsVO : searchGoodsVOS) {
                String goodsName = searchGoodsVO.getGoodsName();
                String goodsIntro = searchGoodsVO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 28) {
                    goodsName = goodsName.substring(0, 28) + "...";
                    searchGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 30) {
                    goodsIntro = goodsIntro.substring(0, 30) + "...";
                    searchGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        PageResult pageResult = new PageResult(searchGoodsVOS, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public List<Goods> searchPage(String keyword){
        return goodsMapper.searchPage(keyword);
    }

    @Override
    public List<Goods> findre(String tag){
        return goodsMapper.findre(tag);
    }

    @Override
    public List<Goods> findgoods(int id){
        return goodsMapper.findgoods(id);
    }

    //宋中正
    @Override
    public List<Goods> ListGood() {
        return goodsMapper.ListGood();
    }

    @Override
    public int FindGoodWithId(String goodsId) {
        return goodsMapper.FindGoodWithId(goodsId);
    }

    @Override
    public Goods InsertGood(Goods good) {
        goodsMapper.InsertGood(good);
        return good;
    }

    @Override
    public int DeleteGood(String goodsId) {
        return goodsMapper.DeleteGood(goodsId);
    }

    @Override
    public int UpdateGood(Goods Good) {
        return goodsMapper.UpdateGood(Good);
    }

    @Override
    public List<Goods> FindGoodWithStoreId(int goodsId) {
        return goodsMapper.FindGoodWithStoreId(goodsId);
    }

    @Override
    public PageResult getShopGoodsPage(PageQueryUtil pageUtil,int shopId) {
        List<Goods> goodsList = goodsMapper.ListGoodsByShopId(shopId);
        int total = goodsMapper.getTotalShopGoods(shopId);
        PageResult pageResult = new PageResult(goodsList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }
}
