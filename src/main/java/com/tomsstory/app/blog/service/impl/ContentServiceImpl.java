package com.tomsstory.app.blog.service.impl;

import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.domain.menu.Menu;
import com.tomsstory.app.blog.dto.content.*;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.blog.repository.CommentRepository;
import com.tomsstory.app.blog.repository.ContentRepository;
import com.tomsstory.app.blog.repository.MenuRepository;
import com.tomsstory.app.blog.service.ContentService;
import com.tomsstory.app.common.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ContentServiceImpl implements ContentService {

    final private ContentRepository contentRepository;
    final private CommentRepository commentRepository;
    final private MenuRepository menuRepository;


    @Override
    public List<ContentDto> getContentWithPage(Integer page, Integer size){
        Validator.isNull.test(page,"Page should be not null");
        Validator.isNull.test(size,"Size should be not null");

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return contentRepository.findAll(pageRequest)
                .stream().map(ContentDto::of).collect(Collectors.toList());
    }

    @Override
    public List<PartialContentDto.Blog> getContentWithPageForBlog(Integer page, Integer size) {
        Validator.isNull.test(page,"Page should be not null");
        Validator.isNull.test(size,"Size should be not null");

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return contentRepository.findAll(pageRequest)
                .stream().map(PartialContentDto.Blog::of).collect(Collectors.toList());
    }



    @Override
    public List<PartialContentDto.Blog> getContentByTitleLikeAndSubTitleLikeForBlog(Integer page, Integer size, String title) {
        Validator.isNull.test(page,"Page should be not null");
        Validator.isNull.test(size,"Size should be not null");
        Validator.isNull.test(title,"Title should be not null");

        title = title.toLowerCase();

        return contentRepository.findByTitleLikeAndSubTitleLikeWithPageable(title,PageRequest.of(page,size))
                .stream().map(PartialContentDto.Blog::of)
                .collect(Collectors.toList());
    }

    @Override
    public ContentDto getContentOne(Long id){
        return ContentDto.of(contentRepository.findById(id).get());
    }


    @Override
    public List<ContentDto> getContentsByMenuId(Long menuId){
        Menu menu = menuRepository.findById(menuId).get();
        return contentRepository.findByMenuEqualsOrderByCreatedAtDesc(menu).stream()
                .map(ContentDto::of)
                .sorted(Comparator.comparing(ContentDto::getCreatedAt))
                .collect(Collectors.toList());

    }
    @Override
    public List<ContentCountByMenuDto> getContentCountByMenu() {
        return contentRepository.findCountByMenu().stream().map(ContentCountByMenuDto::of).collect(Collectors.toList());
    }

    @Override
    public ContentDto getLastOneContentByMenuId(Long menuId){
        Menu menu = menuRepository.findById(menuId).get();
        return ContentDto.of(contentRepository.findFirstByMenuEqualsOrderByCreatedAtDesc(menu).get());
    }

    @Override
    public ContentDto createContent(CreatedContentDto createdContentDto) {
        if (!menuRepository.existsById(createdContentDto.getMenu().getId())) throw new NoSuchElementException("Menu Not Found");
        Content created = contentRepository.save(createdContentDto.toEntity());
        return ContentDto.of(created);
    }

    @Override
    public ContentDto updateContent(UpdatedContent updatedContent) {
        if (!contentRepository.existsById(updatedContent.getId())) throw new NoSuchElementException("Content Not Found");

        Content updated = contentRepository.save(updatedContent.toEntity());
        return ContentDto.of(contentRepository.findById(updated.getId()).get());
    }

    @Override
    public Long deleteContent(Long id) {
        contentRepository.deleteById(id);
        return id;
    }


}
