package com.haiyun.service;

import com.github.pagehelper.PageInfo;
import com.haiyun.model.domain.Article;

import java.util.List;

public interface IArticleService {
    // 做文件分页 查询文章列表  需要使用mybatis pagehelper插件
    // 分页查询文章列表
    public PageInfo<Article> selectArticleWithPage(Integer page, Integer count);

    // 统计前10的热度文章信息
    public List<Article> getHeatArticles();

    // 根据id查询单个文件详情
    public Article selectArticleWithId(Integer id);

    // 文章发布
    public void publish(Article article);

    // 根据主键更新文章
    public void updateArticleWithId(Article article);

    // 根据主键删除文章
    public void deleteArticleWithId(int id);
}
