package com.belong.service.wechat.applet.info.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.belong.service.wechat.applet.info.api.domain.WxUserInfoDO;
import com.belong.service.wechat.applet.info.mapper.WxUserInfoMapper;
import com.belong.service.wechat.applet.info.service.IWxUserInfoService;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description:    微信用户信息表
 * @Author:          BelongFeng
 * @CreateDate:      2019-11-29 10:49:27
 * @UpdateUser:      BelongFeng
 * @UpdateDate:     2019-11-29 10:49:27
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@org.springframework.stereotype.Service
@Transactional(readOnly = true)
public class WxUserInfoServiceImpl extends ServiceImpl<WxUserInfoMapper, WxUserInfoDO> implements IWxUserInfoService {
    /**
     * 查询WxUserInfoDO列表
     *
     * @param WxUserInfoDO
     * @return WxUserInfoDO集合
     */

    @Override
    public IPage<WxUserInfoDO> selectWxUserInfoDOList(IPage<WxUserInfoDO> page, QueryWrapper<WxUserInfoDO> queryWrapper){
        return baseMapper.selectPage(page, queryWrapper);
    }
}
