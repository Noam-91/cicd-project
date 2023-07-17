package com.example.microservicemessage.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="MESSAGE")
public class Message {
    @Id
    @SequenceGenerator(name = "message_id_seq_gen", sequenceName = "message_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "message_id_seq_gen", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String content;
    @Column
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Timestamp createTime;
    @Column
    private int conversationId;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
//    Conversation conversation;

}
