package com.example.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.system.SysUserRole;
import com.atguigu.vo.system.AssginRoleVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.SysUserRoleMapper;
import com.example.service.SysRoleService;
import com.example.mapper.SysRoleMapper;
import com.example.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 86181
* @description 针对表【sys_role(角色)】的数据库操作Service实现
* @createDate 2023-05-01 15:10:30
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService{

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public Map<String, Object> findRoleDataByUserId(Long userId) {
        List<SysRole> allRoleList = baseMapper.selectList(null);

        LambdaQueryWrapper<SysUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserRole::getUserId,userId);
        List<SysUserRole> existUserRoleList = sysUserRoleMapper.selectList(lambdaQueryWrapper);

        List<Long> existRoleIdList = existUserRoleList.stream().map(c -> c.getRoleId()).collect(Collectors.toList());

        List<SysRole> assignRoleList = new ArrayList<>();
        for(SysRole sysRole : allRoleList) {
            //比较
            if(existRoleIdList.contains(sysRole.getId())) {
                assignRoleList.add(sysRole);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assginRoleList", assignRoleList);
        roleMap.put("allRolesList", allRoleList);
        return roleMap;
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        //把用户之前分配角色数据删除，用户角色关系表里面，根据userid删除
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId,assginRoleVo.getUserId());
        sysUserRoleService.remove(wrapper);

        //重新进行分配
        List<Long> roleIdList = assginRoleVo.getRoleIdList();
        for(Long roleId:roleIdList) {
            if(StringUtils.isEmpty(roleId)) {
                continue;
            }
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assginRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleService.save(sysUserRole);
        }
    }
}




