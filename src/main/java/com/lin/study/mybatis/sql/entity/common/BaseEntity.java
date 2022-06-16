package com.lin.study.mybatis.sql.entity.common;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 数据实体基类
 * @author zhen.lin
 * @date 2019年9月8日
 */
public abstract class BaseEntity {

    /**
     * 实体编号 自增长id
     * 这里要设为自己增长 IdType.AUTO 不然会产生一个很大的id值
     */
    @TableId(type = IdType.AUTO)
    protected Long id;
    
    /**
     * 创建时间(由Sql维护 不需处理)
     */
    @JsonIgnore
    protected Date createTime;
    
    /**
     * 更新时间(由Sql维护 不需处理)
     */
    @JsonIgnore
    protected Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
}
