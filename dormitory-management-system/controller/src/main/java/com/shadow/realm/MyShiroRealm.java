package com.shadow.realm;



import com.shadow.entity.User;
import com.shadow.service.PermissionService;
import com.shadow.service.RoleService;
import com.shadow.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
    private PermissionService permissionService;
	@Autowired
    private RoleService roleService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		//获取用户的输入的账号.
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String sid = token.getPrincipal().toString();
		//通过username从数据库中查找 User对象，如果找到，没找到.
		//实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		User user = userService.findUserBySid(sid);
		if(user == null){
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				sid, //用户名
				user.getPassword(), //密码
				ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
				getName()  //realm name
		);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 能进入到这里，表示账号已经通过验证了
        String sid = (String) principalCollection.getPrimaryPrincipal();
        // 通过service获取角色和权限
        Set<String> permissions = permissionService.listPermissions(sid);
        Set<String> roles = roleService.listRoleNames(sid);

        // 授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        // 把通过service获取到的角色和权限放进去
        s.setStringPermissions(permissions);
        s.setRoles(roles);
        return s;
	}
}