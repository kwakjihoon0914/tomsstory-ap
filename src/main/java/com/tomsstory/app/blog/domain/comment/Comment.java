package com.tomsstory.app.blog.domain.comment;


import com.tomsstory.app.blog.domain.content.Content;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Comment {

    @Id  @GeneratedValue
    Long id;

    String name;
    String text;

    @ManyToOne(fetch = FetchType.LAZY)
    Content content;
}
