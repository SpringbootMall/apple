package com.apple.mall.dao;

import com.apple.mall.entity.Goods;
import com.apple.mall.entity.StockNumDTO;
import com.apple.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> findNewBeeMallGoodsList(PageQueryUtil pageUtil);

    int getTotalNewBeeMallGoods(PageQueryUtil pageUtil);

    List<Goods> selectByPrimaryKeys(List<Long> goodsIds);

    List<Goods> findNewBeeMallGoodsListBySearch(PageQueryUtil pageUtil);

    int getTotalNewBeeMallGoodsBySearch(PageQueryUtil pageUtil);

    int batchInsert(@Param("goodsList") List<Goods> goodsList);

    int updateStockNum(@Param("stockNumDTOS") List<StockNumDTO> stockNumDTOS);

    int batchUpdateSellStatus(@Param("orderIds")Long[] orderIds,@Param("sellStatus") int sellStatus);

    /****推荐商品*******/
    List<Goods> findre(String tag);

    /*********查询商品*************/
    List<Goods> searchPage(String keyword);

    List<Goods> findgoods(Long id);

    //  宋中正
    List<Goods> ListGood();
    int FindGoodWithId(String goodsId);
    void InsertGood(Goods good);
    int DeleteGood(String goodsId);
    int UpdateGood(Goods Good);

    List<Goods> FindGoodWithStoreId(int shopId);

    /*********根据店铺打印商品信息*************/
//    List<Goods> findNewBeeMallGoodsList(PageQueryUtil pageUtil);
    List<Goods> ListGoodsByShopId(int shopId);

    /*********获取商品数量信息*************/
//    int getTotalNewBeeMallGoods(PageQueryUtil pageUtil);
    int getTotalShopGoods(int shopId);

}