package com.shadow.filter;

import com.alibaba.fastjson.JSON;
import com.shadow.entity.Msg;
import com.shadow.service.PermissionService;
import com.shadow.utils.SpringContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;

public class URLPathMatchingFilter extends PathMatchingFilter {
    @Autowired
    PermissionService permissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        if(null==permissionService){
            permissionService = SpringContextUtils.getContext().getBean(PermissionService.class);
        }
        String requestURI = getPathWithinApplication(request);
        System.out.println("requestURI:" + requestURI);

        Subject subject = SecurityUtils.getSubject();
        // 如果没有登录，就跳转到登录页面
        if (!subject.isAuthenticated()) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Msg msg = new Msg();
            msg.setCode(400);
            msg.setMsg("未登录");
            response.getWriter().write(JSON.toJSONString(msg));
            return false;
        }

        // 看看这个路径权限里有没有维护，如果没有维护，一律放行(也可以改为一律不放行)
        System.out.println("permissionService:"+permissionService);
        boolean needInterceptor = permissionService.needInterceptor(requestURI);
        System.out.println(needInterceptor);
        if (!needInterceptor) {
            return true;
        } else {
            boolean hasPermission = false;
            String userName = subject.getPrincipal().toString();
            Set<String> permissionUrls = permissionService.listPermissions(userName);
            for (String url : permissionUrls) {
                // 这就表示当前用户有这个权限
                if (url.equals(requestURI)) {
                    hasPermission = true;
                    break;
                }
            }
            if (hasPermission)
            {
                return true;
            }
            else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                Msg msg = new Msg();
                msg.setCode(401);
                msg.setMsg("无权限");
                response.getWriter().write(JSON.toJSONString(msg));
                return false;
            }

        }

    }
}