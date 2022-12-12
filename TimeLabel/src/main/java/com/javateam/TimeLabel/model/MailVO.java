package com.javateam.TimeLabel.model;

import lombok.Data;

@Data
public class MailVO {

    private String mailFrom;

    private String mailTo;
    // 메일 제목
    private String mailSubject;
    // 메일 내용
    private String mailContent;
    // 내용 타입
    private String contentType;

    public MailVO() {
        contentType = "text/plain";
    }
}
