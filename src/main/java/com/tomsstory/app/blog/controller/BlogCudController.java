package com.tomsstory.app.blog.controller;


import com.tomsstory.app.blog.dto.content.ContentDto;
import com.tomsstory.app.blog.dto.content.CreatedContentDto;
import com.tomsstory.app.blog.dto.content.UpdatedContent;
import com.tomsstory.app.blog.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BlogCudController {

    final private ContentService contentService;


    @PostMapping("/blog/contents")
    public ContentDto saveContent(@RequestBody CreatedContentDto createdContentDto){
        return contentService.createContent(createdContentDto);
    }

    @PutMapping("/blog/contents")
    public ContentDto updateContent(@RequestBody UpdatedContent updatedContent){
        return contentService.updateContent(updatedContent);
    }

    @DeleteMapping("/blog/contents")
    public Long deleteContent(@RequestParam Long contentId){
        return contentService.deleteContent(contentId);
    }



}
