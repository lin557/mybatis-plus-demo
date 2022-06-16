package com.lin.study.mybatis.sql.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lin.study.mybatis.sql.entity.common.BaseEntity;

/**
 * 测试表A 实体类
 * @see https://baomidou.com/pages/223848/#tablename
 * @author zhen.lin
 * @date 2022年6月16日
 */
@TableName("base_a")
public class BaseDemo extends  BaseEntity {

    private String carId;
    
    private String carName;
    
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    
    
}
