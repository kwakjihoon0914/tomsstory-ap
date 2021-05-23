package com.tomsstory.app.blog.dto.content;

import com.tomsstory.app.blog.domain.content.ContentCountByMenu;
import com.tomsstory.app.common.util.CommonMapper;
import lombok.Data;

@Data
public class ContentCountByMenuDto {

    private String name;
    private Long id;
    private Long count;


    public static ContentCountByMenuDto of(ContentCountByMenu contentCountByMenu){
        return CommonMapper.map(contentCountByMenu, ContentCountByMenuDto.class);
    }
}
