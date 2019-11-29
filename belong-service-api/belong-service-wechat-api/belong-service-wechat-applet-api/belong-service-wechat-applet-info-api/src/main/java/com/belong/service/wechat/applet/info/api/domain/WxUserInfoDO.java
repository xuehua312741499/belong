package com.belong.service.wechat.applet.info.api.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.belong.common.core.base.CrudEntity;
import lombok.*;

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
@TableName("wx_user_info")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WxUserInfoDO extends CrudEntity {
    private static final long serialVersionUID = -1L;

    public static final String REDIS_KEY = "wx_user_info:" ;

    /**
     * appid 微信平台id
     */
    @TableField("app_id")
    private String appId;
    /**
     * openid 对应平台唯一用户id
     */
    @TableField("open_id")
    private String openId;
    /**
     * union_id 跨平台统一id
     */
    @TableField("union_id")
    private String unionId;
    /**
     * 微信名称 微信名称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 真实名称 真实名称
     */
    @TableField("real_name")
    private String realName;
    /**
     * 微信头像地址 微信头像地址
     */
    @TableField("avatar_url")
    private String avatarUrl;
    /**
     * 位置 位置信息，json存储
     */
    @TableField("addre")
    private String addre;
    /**
     * 积分 积分信息
     */
    @TableField("integral")
    private Integer integral;
    /**
     * 性别 0女，1男
     */
    @TableField("sex")
    private Integer sex;
    /**
     * 手机号 手机号
     */
    @TableField("mobile")
    private String mobile;
    /**
     * 国家 国家
     */
    @TableField("country")
    private String country;
    /**
     * 省份 省份
     */
    @TableField("province")
    private String province;
    /**
     * 城市 城市
     */
    @TableField("city")
    private String city;
    /**
     * 最近一次登录时间 最近一次登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 是否可用 是否可用 是否可用0：可用，1：冻结
     */
    @TableField("enabled")
    private Boolean enabled;
    /**
     * 乐观锁 乐观锁
     */
    @TableField("version")
    private Integer version;
    /**
     * 备注 备注
     */
    @TableField("remark")
    private String remark;
}
