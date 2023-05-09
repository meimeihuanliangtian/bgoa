package com.example.service;

import com.atguigu.model.system.SysMenu;
import com.atguigu.vo.system.AssginMenuVo;
import com.atguigu.vo.system.RouterVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86181
* @description 针对表【sys_menu(菜单表)】的数据库操作Service
* @createDate 2023-05-02 15:22:30
*/
@Service
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> findMenuByRoleId(Long roleId);

    void doAssign(AssginMenuVo assginMenuVo);

    List<SysMenu> findNodes();

    void removeMenuById(Long id);

    List<RouterVo> findUserMenuListByUserId(Long userId);

    List<String> findUserPermsByUserId(Long userId);
}
