package com.tomsstory.app.blog.domain.menu;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer position;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu parent;

    public boolean isMenu(){
        return type.equals("MENU");
    }
    public boolean isDir(){
        return type.equals("DIR");
    }
    public boolean isParentMenu(){
        return Objects.isNull(parent);
    }


}
