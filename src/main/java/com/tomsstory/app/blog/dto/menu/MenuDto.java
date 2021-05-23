package com.tomsstory.app.blog.dto.menu;


import com.tomsstory.app.blog.domain.menu.Menu;
import com.tomsstory.app.common.util.CommonMapper;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class MenuDto {

    private Long id;
    private String name;
    private Integer position;
    private MenuDto parent;
    private String type;


    public boolean isMenu(){
        return type.equals("MENU");
    }
    public boolean isDir(){
        return type.equals("DIR");
    }
    public boolean isParentMenu(){
        return Objects.isNull(parent);
    }

    public static MenuDto of(Menu menu){
        return CommonMapper.map(menu,MenuDto.class);
    }
}
