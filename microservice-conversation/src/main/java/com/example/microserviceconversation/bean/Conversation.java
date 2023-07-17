package com.example.microserviceconversation.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="CONVERSATION")
public class Conversation {
    @Id
    @SequenceGenerator(name = "conversation_id_seq_gen", sequenceName = "conversation_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "conversation_id_seq_gen", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int userId;
    @Column
    private String title;
    @Column
    private String status;
    @Column
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Timestamp updateTime;

//    @JsonManagedReference
//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH,mappedBy = "conversation")
//    List<Message> messageList;

//    public Conversation(int userId, String title, String status) {
//        this.userId = userId;
//        this.status = status;
//        this.messageList = new ArrayList<>();
//    }
}
