package com.tomsstory.app.blog.repository;

import com.tomsstory.app.blog.domain.content.Content;
import com.tomsstory.app.blog.domain.content.ContentCountByMenu;
import com.tomsstory.app.blog.domain.menu.Menu;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content,Long>,ContentCustomRepository {

    List<Content> findByMenuEqualsOrderByCreatedAtDesc(Menu menu);
    Optional<Content> findFirstByMenuEqualsOrderByCreatedAtDesc(Menu menu);

    Long countByTitleLikeOrSubTitle(String title,String subTitle);

    @Query( "SELECT c " +
            "  FROM Content c " +
            " WHERE LOWER(c.title)    LIKE %:title% " +
            "    OR LOWER(c.subTitle) LIKE %:title% ORDER BY c.title,c.subTitle")
    List<Content> findByTitleLikeAndSubTitleWithPageRequest(@Param(value="title") String title, Pageable pageable);

    @Query(nativeQuery = true,value ="SELECT (SELECT NAME " +
                                     "          FROM MENU" +
                                     "         WHERE ID = G.P_ID) AS name" +
                                     "        ,P_ID AS id" +
                                     "        ,P_CNT AS count" +
                                     "  FROM (SELECT ISNULL(M.PARENT_ID,M.ID) AS P_ID, COUNT(*) AS P_CNT" +
                                     "          FROM CONTENT C" +
                                     "         INNER JOIN MENU M ON C.MENU_ID = M.ID" +
                                     "         GROUP BY P_ID) G")
    List<ContentCountByMenu> findCountByMenu();

}
