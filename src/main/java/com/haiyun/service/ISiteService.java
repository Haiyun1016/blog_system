package com.haiyun.service;

import com.haiyun.model.ResponseData.StaticticsBo;
import com.haiyun.model.domain.Article;
import com.haiyun.model.domain.Comment;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ISiteService {
    // 最新收到的评论
    public List<Comment> recentComments(int count);

    // 最新发表的文章
    public List<Article> recentArticles(int count);

    // 最新自己发表的文章
    public List<Article> recentMyArticles(String id, int count);

    // 获取后台统计数据
    public StaticticsBo getStatistics();

    // 更新某个文章的统计数据
    public void updateStatistics(Article article);
}
