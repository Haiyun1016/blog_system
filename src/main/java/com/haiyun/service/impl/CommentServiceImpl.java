package com.haiyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haiyun.dao.CommentMapper;
import com.haiyun.dao.StatisticMapper;
import com.haiyun.model.domain.Comment;
import com.haiyun.model.domain.Statistic;
import com.haiyun.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public PageInfo<Comment> getComments(Integer aid, int page, int count) {

        // 根据文章id 查询所有评论数据
        PageHelper.startPage(page, count);
        List<Comment> commentList = commentMapper.selectCommentWithPage(aid);

        PageInfo<Comment> commentPageInfo = new PageInfo<>(commentList);

        return commentPageInfo;
    }

    // 用户发表评论
    @Override
    public void pushComment(Comment comment) {
        // 把评论的数据进行插入
        commentMapper.pushComment(comment);
        // 更新文章评论数据量
        Statistic statistic = statisticMapper.selectStatisticWithArticleId(comment.getArticleId());
        statistic.setCommentsNum(statistic.getCommentsNum()+1);
        statisticMapper.updateArticleCommentsWithId(statistic);
    }
}
