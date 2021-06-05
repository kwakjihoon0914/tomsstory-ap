package com.tomsstory.app.blog.domain.content;


import com.tomsstory.app.blog.domain.comment.Comment;
import com.tomsstory.app.blog.domain.menu.Menu;
import com.tomsstory.app.common.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@DynamicUpdate
@ToString
public class Content extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String subTitle;
    @Column(columnDefinition = "LONGTEXT")
    private String text;
    private String type;
    private String thumbnail;


    private Long viewCnt = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    @OneToMany(mappedBy = "content" ,fetch = FetchType.LAZY)
    List<Comment> comments = new ArrayList<>();

    public void addViewCnt(){
        this.viewCnt++;
    }
}
