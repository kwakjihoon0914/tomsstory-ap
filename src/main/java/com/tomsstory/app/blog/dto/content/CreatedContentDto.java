package com.tomsstory.app.blog.dto.content;

import com.sun.istack.NotNull;
import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.common.util.CommonMapper;
import com.tomsstory.app.common.validation.Validator;
import lombok.Data;


@Data
public class CreatedContentDto {

    private String title;
    private String subTitle;
    private String text;
    private String type;
    private String thumbnail;
    private MenuDto menu;

    public Content toEntity(){
        this.validate();
        return CommonMapper.map(this,Content.class);
    }

    public boolean validate(){
        Validator.isNullWithMsg.test(title,"title");
        Validator.isNullWithMsg.test(subTitle,"subTitle");
        Validator.isNullWithMsg.test(text,"text");
        Validator.isNullWithMsg.test(menu,"menu");

        return true;
    }

}
