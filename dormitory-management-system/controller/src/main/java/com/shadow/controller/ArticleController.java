package com.shadow.controller;


import com.shadow.entity.Article;
import com.shadow.entity.Msg;
import com.shadow.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepo articleDao;

    @GetMapping("getArticles")
    public Msg getArticles(){
        List<Article> articleList = new ArrayList<>();
        articleList = articleDao.findAll();
        return Msg.success().add("list",articleList);
    }
}
