package com.example.microservicesubscribe.bean;

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
@Table(name="SUBSCRIBE")
public class Subscription {
    @Id
    @SequenceGenerator(name = "subscription_id_seq_gen", sequenceName = "subscription_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "subscription_id_seq_gen", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String email;
    @Column
    private String status;
    @Column
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Timestamp createTime;
    @Column
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Timestamp updateTime;

    public Subscription(String email, String status) {
        this.email = email;
        this.status = status;
    }
}
