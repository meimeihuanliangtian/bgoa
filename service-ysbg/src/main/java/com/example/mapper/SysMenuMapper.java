package com.example.mapper;

import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86181
* @description 针对表【sys_menu(菜单表)】的数据库操作Mapper
* @createDate 2023-05-02 15:22:30
* @Entity com.example.pojo.SysMenu
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> findMenuListByUserId(@Param("userId") Long userId);
}




