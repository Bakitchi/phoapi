package com.bakitchi.phoapi.dto;

import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/16 下午4:23
 * @Description:
 */
public class MsgDTO {
    private String createTime;
    private String topic;
    private String content;
    private List<ReplyDTO> replyDTOList;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ReplyDTO> getReplyDTOList() {
        return replyDTOList;
    }

    public void setReplyDTOList(List<ReplyDTO> replyDTOList) {
        this.replyDTOList = replyDTOList;
    }


}
