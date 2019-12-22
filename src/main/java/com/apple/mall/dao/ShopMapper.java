package com.apple.mall.dao;


        import com.apple.mall.entity.Shop;
        import com.apple.mall.util.PageQueryUtil;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Param;

        import java.util.List;

@Mapper
public interface ShopMapper {

    List<Shop> findshop(String shopName);

    Shop shop(Long id);

    List<Shop> FindAllShopsWithSellerId(long sellerId);

    void insertShop(Shop shop);

    Shop findShopByName(String shopName);

    List<Shop> findShopList(PageQueryUtil pageUtil);

    int getTotalShops(PageQueryUtil pageUtil);

    int modifyShopApplyBatch(@Param("ids") Integer[] ids, @Param("applyStatus") int applyStatus);
}
