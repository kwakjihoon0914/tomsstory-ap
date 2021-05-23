package com.tomsstory.app.blog.dto.content;

import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.common.util.CommonMapper;
import lombok.Data;


@Data
public class CreatedContentDto {

    private String title;
    private String subTitle;
    private String text;
    private String type;
    private String thumbnail;
    private String lastModifiedBy;
    private MenuDto menu;

    public static Content toEntity(CreatedContentDto createdContentDto){
        return CommonMapper.map(createdContentDto,Content.class);
    }

}
