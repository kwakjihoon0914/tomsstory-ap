package com.tomsstory.app.blog.service;


import com.tomsstory.app.blog.dto.content.ContentDto;
import com.tomsstory.app.blog.dto.menu.MenuDto;

import java.util.List;

public interface MenuService {

    /*********************************************************************************************/
    // SELECT Menu
    /*********************************************************************************************/
    List<MenuDto> getAllMenus();
}
