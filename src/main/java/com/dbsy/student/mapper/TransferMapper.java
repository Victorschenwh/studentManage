package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Transfer;

public interface TransferMapper {
    int insert(Transfer record);

    int insertSelective(Transfer record);
}