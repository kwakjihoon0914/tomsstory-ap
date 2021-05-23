package com.tomsstory.app.blog.dto.content;

import lombok.Data;

import java.util.List;


@Data
class Page{
    private int page;
    private int size;
    private int dataSize;
    public Page(int page, int size, int dataSize){
        this.page = page;
        this.size = size;
        this.dataSize = dataSize;
    }
}
@Data
public class ContentListWithPageDto  {

    private List<PartialContentDto.Blog> contents;
    private Page pageRequest;
    public ContentListWithPageDto(List<PartialContentDto.Blog> contents,int page,int size){
        this.contents = contents;
        this.pageRequest = new Page(page,size,contents.size());
    }


    public static ContentListWithPageDto of(List<PartialContentDto.Blog> contents,int page,int size){
        return new ContentListWithPageDto(contents,page,size);
    }



}
