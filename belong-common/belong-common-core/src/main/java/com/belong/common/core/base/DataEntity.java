package com.belong.common.core.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.belong.common.util.RandomHelper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**

* @Description:    数据Entity类
* @Author:         fengyu
* @CreateDate:     2019/11/28 15:37
* @UpdateUser:     fengyu
* @UpdateDate:     2019/11/28 15:37
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public abstract class DataEntity extends BaseEntity {

    /**
     * 删除标记0：正常
     */
    public static final String DEL_FLAG_NORMAL = "0";
    /**
     * 删除标记1：删除
     */
    public static final String DEL_FLAG_DELETE = "1";

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("create_date")
    @ApiModelProperty(value = "创建时间", required = false, hidden = true)
    private Date createDate;
    /**
     * 更新日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("update_date")
    @ApiModelProperty(value = "修改时间", required = false, hidden = true)
    private Date updateDate;
    /**
     * 删除标记(0:正常;1:删除;)
     */
    @TableLogic(delval = DEL_FLAG_DELETE, value = DEL_FLAG_NORMAL)
    @TableField("del_flag")
    @ApiModelProperty(value = "逻辑删除 0:正常;1:删除;", required = false, hidden = true)
    private String delFlag;

    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(String id) {
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (this.getIsNewRecord()) {
            setId(RandomHelper.uuid());
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        this.updateDate = new Date();
    }

    public Date getCreateDate() {
        return createDate == null ? null : (Date) createDate.clone();
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate == null ? null : (Date) createDate.clone();
    }

    public Date getUpdateDate() {
        return updateDate == null ? null : (Date) updateDate.clone();
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate == null ? null : (Date) updateDate.clone();
    }

    @JsonIgnore
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}
