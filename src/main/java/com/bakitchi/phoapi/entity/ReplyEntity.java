package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import com.oracle.webservices.internal.api.message.PropertySet;

@Entity(value="REPLY")
public class ReplyEntity {

    @Property(value="REPLYTIME")
    private String replyTime;

    @Property(value="TOPIC")
    private String topic;

    @Property(value="CONTENT")
    private String content;

    @Property(value = "TEACHERID")
    private Integer teacherId;

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}

