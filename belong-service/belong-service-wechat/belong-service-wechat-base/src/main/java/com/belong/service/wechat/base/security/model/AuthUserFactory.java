//package com.belong.service.wechat.base.security.model;
//
//
//import cn.lioncity.platform.common.utils.StringHelper;
//import cn.lioncity.platform.system.api.sys.domain.SysMenuDO;
//import cn.lioncity.platform.system.api.sys.domain.SysRoleDO;
//import cn.lioncity.platform.system.api.sys.domain.SysUserDO;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * The type Auth user factory.
// *
// * @author lioncity
// */
//public final class AuthUserFactory {
//
//    private AuthUserFactory() {
//    }
//
//    /**
//     * Create auth user.
//     *
//     * @param user the user
//     * @return the auth user
//     */
//    public static AuthUser create(SysUserDO user) {
//        AuthUser authUser = new AuthUser(user.getId());
//        authUser.setLoginName(user.getLoginName());
//        authUser.setName(user.getName());
//        authUser.setEmail(user.getEmail());
//        authUser.setMobile(user.getMobile());
//        authUser.setDeptId(user.getDeptId());
//        authUser.setPassword(user.getPassword());
//        authUser.setEnabled(user.getEnabled());
//        authUser.setAuthorities(mapToGrantedAuthorities(user.getRoles(), user.getMenus()));
//        return authUser;
//    }
//
//    /**
//     * 权限转换
//     *
//     * @param sysRoles 角色列表
//     * @param sysMenus 菜单列表
//     * @return 权限列表
//     */
//    private static List<SimpleGrantedAuthority> mapToGrantedAuthorities(List<SysRoleDO> sysRoles, List<SysMenuDO> sysMenus) {
//
//        List<SimpleGrantedAuthority> authorities =
//                sysRoles.stream().filter(SysRoleDO::getEnabled)
//                        .map(sysRole -> new SimpleGrantedAuthority(sysRole.getName())).collect(Collectors.toList());
//
//        // 添加基于Permission的权限信息
//        sysMenus.stream().filter(menu -> StringHelper.isNotBlank(menu.getPermission())).forEach(menu -> {
//            // 添加基于Permission的权限信息
//            for (String permission : StringHelper.split(menu.getPermission(), "")) {
//                authorities.add(new SimpleGrantedAuthority(permission));
//            }
//        });
//
//        return authorities;
//    }
//
//}
