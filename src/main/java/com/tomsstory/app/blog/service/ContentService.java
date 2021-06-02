package com.tomsstory.app.blog.service;


import com.tomsstory.app.blog.dto.content.*;
import com.tomsstory.app.blog.dto.menu.MenuDto;

import java.util.List;

public interface ContentService {

    /*********************************************************************************************/
    // SELECT Content
    /*********************************************************************************************/
    ContentDto getContentOne(Long id);
    List<ContentDto> getContentWithPage(Integer page, Integer size);
    List<PartialContentDto.Blog> getContentWithPageForBlog(Integer page, Integer size);
    List<PartialContentDto.Blog> getContentByTitleLikeAndSubTitleLikeForBlog(Integer page, Integer size,String title);

    List<ContentDto> getContentsByMenuId(Long menuId);
    ContentDto getLastOneContentByMenuId(Long menuId);

    List<ContentCountByMenuDto> getContentCountByMenu();

    /*********************************************************************************************/
    // CUD Content
    /*********************************************************************************************/
    ContentDto createContent(CreatedContentDto content);
    ContentDto updateContent(UpdatedContent content);
    Long deleteContent(Long id);





}
