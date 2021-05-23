package com.tomsstory.app.blog.dto.content;

import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.common.util.CommonMapper;
import lombok.Data;

import java.time.LocalDateTime;

public class PartialContentDto {

    @Data
    public static class Blog{
        private Long id;
        private String title;
        private String subTitle;
        private String thumbnail;
        private String lastModifiedBy;
        private LocalDateTime lastModifiedAt;
        private MenuDto menu;

        public static PartialContentDto.Blog of(Content content){
            return CommonMapper.map(content,PartialContentDto.Blog.class);
        }
    }

}
