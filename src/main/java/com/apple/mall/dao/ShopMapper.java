package com.apple.mall.dao;


        import com.apple.mall.entity.Shop;
        import org.apache.ibatis.annotations.Mapper;

        import java.util.List;

@Mapper
public interface ShopMapper {

    List<Shop> findshop(String shopName);

    Shop shop(Long id);

    List<Shop> FindAllShopsWithSellerId(long sellerId);

    void insertShop(Shop shop);

    Shop findShopByName(String shopName);
}
