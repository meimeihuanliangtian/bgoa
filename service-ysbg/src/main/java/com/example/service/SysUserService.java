package com.example.service;

import com.atguigu.model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86181
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2023-05-01 14:39:20
*/
public interface SysUserService extends IService<SysUser> {

    void updateStatus(Long id, Integer status);

    SysUser getUserByUserName(String username);
}
