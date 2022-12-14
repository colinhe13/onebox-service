package com.turing.onebox.home.mapper;

import com.turing.onebox.common.model.dto.ShareInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ShareInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareInfo record);

    ShareInfo selectByPrimaryKey(Integer id);

    List<ShareInfo> selectAll();

    int updateByPrimaryKey(ShareInfo record);
}