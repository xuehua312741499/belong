package com.belong.service.wechat.applet.info.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 微信用户信息表
 * @Author: BelongFeng
 * @CreateDate: 2019-11-29 10:49:27
 * @UpdateUser: BelongFeng
 * @UpdateDate: 2019-11-29 10:49:27
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "WxUserInfoVO", description = "微信用户信息表详情")
public class WxUserInfoVO implements Serializable {
    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appid 微信平台id")
    private String appId;
    @ApiModelProperty(value = "openid 对应平台唯一用户id")
    private String openId;
    @ApiModelProperty(value = "union_id 跨平台统一id")
    private String unionId;
    @ApiModelProperty(value = "微信名称 微信名称")
    private String nickName;
    @ApiModelProperty(value = "真实名称 真实名称")
    private String realName;
    @ApiModelProperty(value = "微信头像地址 微信头像地址")
    private String avatarUrl;
    @ApiModelProperty(value = "位置 位置信息，json存储")
    private String addre;
    @ApiModelProperty(value = "积分 积分信息")
    private Integer integral;
    @ApiModelProperty(value = "性别 0女，1男")
    private Integer sex;
    @ApiModelProperty(value = "手机号 手机号")
    private String mobile;
    @ApiModelProperty(value = "国家 国家")
    private String country;
    @ApiModelProperty(value = "省份 省份")
    private String province;
    @ApiModelProperty(value = "城市 城市")
    private String city;
    @ApiModelProperty(value = "最近一次登录时间 最近一次登录时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date lastLoginTime;
    @ApiModelProperty(value = "是否可用 是否可用 是否可用0：可用，1：冻结")
    private Boolean enabled;
    @ApiModelProperty(value = "乐观锁 乐观锁")
    private Integer version;
    @ApiModelProperty(value = "备注 备注")
    private String remark;
}
