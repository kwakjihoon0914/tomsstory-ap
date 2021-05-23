package com.tomsstory.app.blog.service;


import com.tomsstory.app.blog.dto.content.ContentCountByMenuDto;
import com.tomsstory.app.blog.dto.content.ContentDto;
import com.tomsstory.app.blog.dto.content.CreatedContentDto;
import com.tomsstory.app.blog.dto.content.PartialContentDto;
import com.tomsstory.app.blog.dto.menu.MenuDto;

import java.util.List;

public interface ContentService {

    ContentDto getContentOne(Long id);
    List<ContentDto> getContentWithPage(Integer page, Integer size);
    List<PartialContentDto.Blog> getContentWithPageForBlog(Integer page, Integer size);
    List<PartialContentDto.Blog> getContentByTitleWithPageForBlog(Integer page, Integer size,String title);
    List<ContentDto> getContentsByMenuId(Long menuId);
    ContentDto getLastOneContentByMenuId(Long menuId);

    ContentDto createContent(CreatedContentDto content);

    List<ContentCountByMenuDto> getContentCountByMenu();


    List<MenuDto> getAllMenus();

}
