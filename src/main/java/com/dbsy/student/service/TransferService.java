package com.dbsy.student.service;

import com.dbsy.student.pojo.Transfer;

import java.util.List;
import java.util.Map;

public interface TransferService {

    int insert(Transfer record);

    int insertSelective(Transfer record);

    int batchInsert(List<Transfer> list);

    int listCount(Map map);

    List<Map> list(Map map);

    Transfer get(int id);

    Map getOpposite(int id);

    public int insert(Map map);

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

    int updateSelective(Transfer transfer);

}
