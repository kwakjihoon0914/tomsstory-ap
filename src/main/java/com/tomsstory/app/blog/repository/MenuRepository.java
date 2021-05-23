package com.tomsstory.app.blog.repository;

import com.tomsstory.app.blog.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {


}
