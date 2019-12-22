package com.apple.mall.dao;
import com.apple.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallUserApplyMapper {
//    int deleteByPrimaryKey(Long applyUserId);
//
//    int insert(MallUserApply record);
//
//    int insertSelective(MallUserApply record);
//
//    MallUserApply selectByPrimaryKey(Long applyUserId);
//
//    int updateByPrimaryKeySelective(MallUserApply record);
//
//    int updateByPrimaryKey(MallUserApply record);
//
//    List<MallUserApply> findMallUserApplyList(PageQueryUtil pageUtil);
//
//    int getTotalMallUserApplys(PageQueryUtil pageUtil);

    int modifyUserApplyBatch(@Param("ids") Integer[] ids, @Param("applyStatus") int applyStatus);
}