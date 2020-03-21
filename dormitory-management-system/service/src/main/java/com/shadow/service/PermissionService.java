package com.shadow.service;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface PermissionService {

    boolean needInterceptor(String url);

    Set<String> listPermissions(String sid);
}
