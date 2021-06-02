package com.tomsstory.app.blog.controller;


import com.tomsstory.app.blog.dto.content.ContentCountByMenuDto;
import com.tomsstory.app.blog.dto.content.ContentDto;
import com.tomsstory.app.blog.dto.content.ContentListWithPageDto;
import com.tomsstory.app.blog.dto.content.PartialContentDto;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.blog.service.ContentService;
import com.tomsstory.app.blog.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class BlogController {

    final private ContentService contentService;
    final private MenuService menuService;

    @GetMapping("/blog/contents")
    public ContentListWithPageDto getContentsByPage(@RequestParam(required = false) String title,
                                                    @RequestParam(required = false) Integer page,
                                                    @RequestParam(required = false) Integer size){

        if (size == null || size > 30) size = 5;
        if (page == null) page = 0;

        List<PartialContentDto.Blog> contents;
        if (title!=null && !title.trim().equals("")){
            contents = contentService.getContentByTitleLikeAndSubTitleLikeForBlog(page,size,title);
        }else{
            contents = contentService.getContentWithPageForBlog(page,size);
        }

        return ContentListWithPageDto.of(contents,page,size);
    }
    @GetMapping("/blog/contents/{contentId}")
    public ContentDto getContentByContentId(@PathVariable Long contentId){
        return contentService.getContentOne(contentId);
    }

    @GetMapping("/blog/contents/menus/{menuId}")
    public List<ContentDto> getContentsByMenu(@PathVariable Long menuId){
        return contentService.getContentsByMenuId(menuId);
    }

    @GetMapping("/blog/contents/menus/{menuId}/last")
    public ContentDto getLastContentByMenu(@PathVariable Long menuId){
        return contentService.getLastOneContentByMenuId(menuId);
    }

    @GetMapping("/blog/menus")
    public List<MenuDto> getAllMenu(){
        return menuService.getAllMenus();
    }


    @GetMapping("/blog/contents/menus/count")
    public List<ContentCountByMenuDto> getContentCntByMenu(){
        return contentService.getContentCountByMenu();
    }


    @GetMapping("/blog/contents/hot")
    public ContentDto getHotContent(){
        return contentService.getContentOne(18L);
    }
}
