package com.shadow.service.impl;

import com.shadow.entity.DormInfo;
import com.shadow.mapper.DormMapper;
import com.shadow.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WCZ
 * @date 2020-05-18
 * @Description:
 **/
@Service
public class DormServiceImpl implements DormService {

    @Autowired
    DormMapper dormMapper;

    @Override
    public DormInfo selectById(String id) {
        try{
            return dormMapper.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DormInfo> selectDorm(String dormitoryId, String name) {
        try{
            return dormMapper.selectDorm(dormitoryId,name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
