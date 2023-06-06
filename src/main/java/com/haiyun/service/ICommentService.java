package com.haiyun.service;

import com.github.pagehelper.PageInfo;
import com.haiyun.model.domain.Comment;

public interface ICommentService {
    // 获取文章下的评论  查询所有评论 需要文章id 以及page count
    public PageInfo<Comment> getComments(Integer aid, int page, int count);

    // 用户发表评论
    public void pushComment(Comment comment);
}
