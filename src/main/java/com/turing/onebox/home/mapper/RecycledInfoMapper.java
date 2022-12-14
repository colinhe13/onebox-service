package com.turing.onebox.home.mapper;

import com.turing.onebox.common.model.dto.RecycledInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RecycledInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByFileId(Integer id);

    RecycledInfo selectByFileId(Integer id);

    int insert(RecycledInfo recycledInfo);

    RecycledInfo selectByPrimaryKey(Integer id);

    List<RecycledInfo> selectAll();

    int updateByPrimaryKey(RecycledInfo record);
}