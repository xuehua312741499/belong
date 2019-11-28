//package com.belong.service.wechat.base.security;
//
//import cn.lioncity.platform.admin.base.security.model.AuthUserFactory;
//import cn.lioncity.platform.common.constant.DubboVersion;
//import cn.lioncity.platform.common.constant.ServiceNameConstants;
//import cn.lioncity.platform.system.api.sys.domain.SysUserDO;
//import cn.lioncity.platform.system.api.sys.service.ISystemService;
//import com.alibaba.dubbo.config.annotation.Reference;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * Security User Detail Service
// *
// * @author lioncity
// */
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    /**
//     * 系统服务
//     */
//    @Autowired(required = false)
//    @Reference(version = DubboVersion.V1, group = ServiceNameConstants.ADMIN_SYS_SERVICE, check = false)
//    private ISystemService systemService;
//
//    @Override
//    public UserDetails loadUserByUsername(String loginName) {
//        SysUserDO user = systemService.getUserByLoginName(loginName);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
//        } else {
//            return AuthUserFactory.create(user);
//        }
//    }
//}
