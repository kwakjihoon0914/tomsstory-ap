package com.tomsstory.app.blog.service.impl;

import com.tomsstory.app.blog.domain.menu.Menu;
import com.tomsstory.app.blog.dto.content.ContentDto;
import com.tomsstory.app.blog.dto.menu.MenuDto;
import com.tomsstory.app.blog.repository.ContentRepository;
import com.tomsstory.app.blog.repository.MenuRepository;
import com.tomsstory.app.blog.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    final private ContentRepository contentRepository;
    final private MenuRepository menuRepository;

    @Override
    public List<MenuDto> getAllMenus(){
        return menuRepository.findAll().stream().map(MenuDto::of).collect(Collectors.toList());
    }

}
