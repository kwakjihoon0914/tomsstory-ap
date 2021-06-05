package com.tomsstory.app.blog.dto.content;


import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.dto.comment.CommentDto;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.common.util.CommonMapper;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ContentDto {

    private Long id;
    private String title;
    private String subTitle;

    private String text;
    private String type;
    private String thumbnail;
    private Long viewCnt;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedAt;

    private MenuDto menu;

    private List<CommentDto> comments;
    public static ContentDto of(Content content){
        return CommonMapper.map(content,ContentDto.class);
    }

}
