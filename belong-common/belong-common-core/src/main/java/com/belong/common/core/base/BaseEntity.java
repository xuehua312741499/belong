package com.belong.common.core.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**

* @Description:    Entity 基类
* @Author:         fengyu
* @CreateDate:     2019/11/28 15:36
* @UpdateUser:     fengyu
* @UpdateDate:     2019/11/28 15:36
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public abstract class BaseEntity implements Serializable {

    /**
     * 实体编号（唯一标识）
     */
    @TableId
    private String id;

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    @TableField(exist = false)
    private boolean isNewRecord = false;

    public BaseEntity() {

    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return 是否是新记录
     */
    @JsonIgnore
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @param isNewRecord 是否为新数据
     */
    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
