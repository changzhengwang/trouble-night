package com.shadow.service;

import com.shadow.entity.DormInfo;

import java.util.List;

/**
 * @author WCZ
 * @date 2020-05-18
 * @Description:
 **/
public interface DormService {

    List<DormInfo> selectDorm(String dormitoryId,String name);

    DormInfo selectById(String id);
}
