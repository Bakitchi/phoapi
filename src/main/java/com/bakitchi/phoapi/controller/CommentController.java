package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import com.bakitchi.phoapi.dto.MsgDTO;
import com.bakitchi.phoapi.dto.ReplyDTO;
import com.eharmony.pho.api.DataStoreApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/16 下午4:33
 * @Description:
 */

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    BaseDAO baseDAO;


    //新建评论
    @RequestMapping(value = "newComment/{tid}",method = RequestMethod.POST)
    public void newComment(@PathVariable(value = "tid") Integer tid,@RequestParam(value = "topic") String topic, @RequestParam(value = "content") String content){
        baseDAO.daoNewMessageBox(tid, topic, content);
    }

    //新建回复
    @RequestMapping(value = "newReply/{tid}",method = RequestMethod.POST)
    public void newReply(@PathVariable(value = "tid") Integer tid,@RequestParam(value = "topic") String topic, @RequestParam(value = "content") String content){
        baseDAO.daoNewReply(tid, topic, content);
    }

    //获得某个帖子的所有回复
    @RequestMapping(value = "allReply/{tid}",method = RequestMethod.GET)
    public List<ReplyDTO> getAllReply(@PathVariable(value = "tid") Integer tid, @RequestParam(value = "topic") String topic){
        return baseDAO.daoGetAllReply(tid, topic);
    }

    //获得教师留言板信息
    @RequestMapping(value = "allMsg/{tid}",method = RequestMethod.GET)
    public List<MsgDTO> getAllMsg(@PathVariable(value = "tid") Integer tid){
        return baseDAO.daoGetAllMsgByTeacherId(tid);
    }



}
