package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(value="MESSAGE")
public class MessageEntity {

   @Property(value="CREATETIME")
    private String createTime;

    @Property(value="TEACHERID")
    private Integer teacherID;

    @Property(value="TOPIC")
    private String topic;

    @Property(value="CONTENT")
    private String content;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
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
}
