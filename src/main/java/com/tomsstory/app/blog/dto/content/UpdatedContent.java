package com.tomsstory.app.blog.dto.content;

import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.domain.menu.Menu;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.common.util.CommonMapper;
import com.tomsstory.app.common.validation.Checker;
import com.tomsstory.app.common.validation.Validator;
import lombok.Data;

import java.util.Objects;


@Data
public class UpdatedContent {

    private Long id;
    private String title;
    private String subTitle;
    private String text;
    private String type;
    private String thumbnail;
    private Long menuId;

    public Content toEntity(){
        this.validate();

        Content updated = new Content();
        if (title != null) updated.setTitle(title);
        if (subTitle != null) updated.setSubTitle(subTitle);
        if (text != null) updated.setText(text);
        if (type != null) updated.setType(type);

        if (menuId != null) {
            Menu updatedMenu = new Menu();
            updatedMenu.setId(menuId);
            updated.setMenu(updatedMenu);
        }

        return updated;
    }
    public boolean validate(){
        Validator.isNull.test(id,"contentId");
        return true;
    }

}
