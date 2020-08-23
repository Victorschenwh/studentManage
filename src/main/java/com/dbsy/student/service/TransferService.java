package com.dbsy.student.service;

import com.dbsy.student.pojo.Transfer;

import java.util.List;
import java.util.Map;

public interface TransferService {

    int insert(Transfer record);

    int insertSelective(Transfer record);

    int listCount(Map map);

    List<Transfer> list(Map map);

    Transfer get(int id);

    int delete(int id);

    int update(Transfer transfer);

    int batchRemove(int[] ids);

    List<Transfer> getAll();

    List<Transfer> getTransferByStudentId(int studentId);

    List<Transfer> getTransferByOldDepartmentId(int oldDepartmentId);

    List<Transfer> getTransferByOldMajorId(int oldMajorId);

    List<Transfer> getTransferByOldClazzId(int oldClazzId);

    List<Transfer> getTransferByNewDepartmentId(int newDepartmentId);

    List<Transfer> getTransferByNewMajorId(int newMajorId);

    List<Transfer> getTransferByNewClazzId(int newClazzId);
}