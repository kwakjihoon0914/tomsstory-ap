package com.tomsstory.app.common.config;


import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.domain.menu.Menu;
import com.tomsstory.app.blog.repository.CommentRepository;
import com.tomsstory.app.blog.repository.ContentRepository;
import com.tomsstory.app.blog.repository.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
@Profile("prod")
public class ApplicationInitializerProd {

    final private MenuRepository menuRepository;
    final private ContentRepository contentRepository;
    final private CommentRepository commentRepository;
    private List<Menu> createdMenus;

    private void initContents(){
        List<Menu> createdMenus = createDefaultMenu();
        List<Content> contents = new ArrayList<>();

        createdMenus.stream().filter(Menu::isMenu).forEach(menu->{
            Content content = new Content();

            String title = "Title - "+ menu.getName();
            String subTitle = "Sub Title -" + menu.getName();
            String text = "## 1."+title +" "+ subTitle + " "+menu.getId();

            content.setThumbnail(menu.getName());
            content.setTitle(title);
            content.setSubTitle(subTitle);
            content.setText(text);
            content.setType("md");
            content.setMenu(menu);
            contents.add(content);

        });
        contentRepository.saveAll(contents);
    }

    private List<Menu> createDefaultMenu(){
        List<Menu> createdMenus = new ArrayList<>();
        String [] parentMenus = {"Java","Javascript","DB","Server"};
        String [][] children = {{"Spring","JPA","Etc"},{"React","Web","Etc"},{},{}};
        for (int i = 0; i < parentMenus.length; i++) {
            Menu parent = new Menu();
            parent.setName(parentMenus[i]);
            parent.setPosition(i);
            if (children[i].length > 0) parent.setType("DIR");
            else parent.setType("MENU");
            createdMenus.add(menuRepository.save(parent)); // for getting parentId
        }

        for (int i = 0; i < parentMenus.length; i++) {
            for (int j = 0; j < children[i].length; j++) {
                Menu child = new Menu();
                child.setName(children[i][j]);
                child.setPosition(j);
                child.setType("MENU");
                child.setParent(createdMenus.get(i));
                menuRepository.save(child);
            }
        }
        return menuRepository.findAll();
    }



    @PostConstruct
    @Transactional
    @Profile("prod")
    public void initOnlyMenu() {

        if (menuRepository.count() == 0){
            log.info("##### init only menu");
            log.info("##### init only menu");
            log.info("##### init only menu");
            log.info("##### init only menu");
            log.info("##### init only menu");
            createDefaultMenu();}

    }

}
