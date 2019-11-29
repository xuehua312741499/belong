package com.belong.service.wechat.applet.info.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.belong.service.wechat.applet.info.api.domain.WxUserInfoDO;

/**
 * @Description:    微信用户信息表
 * @Author:          BelongFeng
 * @CreateDate:      2019-11-29 10:49:27
 * @UpdateUser:      BelongFeng
 * @UpdateDate:     2019-11-29 10:49:27
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Mapper
public interface WxUserInfoMapper extends BaseMapper<WxUserInfoDO> {
}
