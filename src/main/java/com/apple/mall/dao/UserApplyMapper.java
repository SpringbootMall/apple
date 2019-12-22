package com.apple.mall.dao;

import com.apple.mall.entity.UserApply;
import com.apple.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserApplyMapper {
    void insertUserApply(UserApply userApply);

    //用户申请商家
    List<UserApply> findUserApplyList(PageQueryUtil pageUtil);

    List<UserApply> findAll();

    int getTotalUserApply(PageQueryUtil pageUtil);

    int modifyUserApplyBatch(@Param("ids") Integer[] ids, @Param("applyStatus") int applyStatus);
}
