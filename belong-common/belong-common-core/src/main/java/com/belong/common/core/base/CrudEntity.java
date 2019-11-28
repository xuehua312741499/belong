package com.belong.common.core.base;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 数据Entity类
 * @Author: fengyu
 * @CreateDate: 2019/11/28 15:35
 * @UpdateUser: fengyu
 * @UpdateDate: 2019/11/28 15:35
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
public abstract class CrudEntity extends DataEntity {

    /**
     * 创建者
     */
    @TableField("create_by")
    @ApiModelProperty(value = "创建者", required = false, hidden = true)
    private String createBy;

    /**
     * 更新者
     */
    @TableField("update_by")
    @ApiModelProperty(value = "更新者", required = false, hidden = true)
    private String updateBy;
}
