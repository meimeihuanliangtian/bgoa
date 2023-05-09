package com.example.service.impl;

import com.atguigu.model.system.SysUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.service.SysUserService;
import com.example.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86181
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2023-05-01 14:39:20
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Override
    public void updateStatus(Long id, Integer status) {
        SysUser sysUser = baseMapper.selectById(id);
        sysUser.setStatus(status);
        baseMapper.updateById(sysUser);
    }

    @Override
    public SysUser getUserByUserName(String username) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername,username);
        SysUser sysUser = baseMapper.selectOne(lambdaQueryWrapper);
        return sysUser;
    }

}




