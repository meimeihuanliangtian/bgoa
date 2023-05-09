package com.example.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.vo.system.AssginRoleVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 86181
* @description 针对表【sys_role(角色)】的数据库操作Service
* @createDate 2023-05-01 15:10:30
*/
public interface SysRoleService extends IService<SysRole> {

    Map<String, Object> findRoleDataByUserId(Long userId);

    void doAssign(AssginRoleVo assginRoleVo);
}
