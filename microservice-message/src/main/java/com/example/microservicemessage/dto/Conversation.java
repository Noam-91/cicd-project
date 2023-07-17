package com.example.microservicemessage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {
    private int id;
    private int userId;
    private String title;
    private String status;
    private Timestamp updateTime;
}
