package com.pingr.Pings.core.Pings;

import javax.persistence.*;

@Entity
@Table
public class Ping {
    @Id
    @SequenceGenerator(
            name = "ping_seq_generator",
            sequenceName = "ping_seq_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ping_seq_generator"
    )
    private Long id;

    @Column(nullable = false)
    private Long idAccount;

    @Column(
            nullable = false,
            length = 140
    )
    private String text;

    @Column
    private Long idPingReplied;

    public Ping() {
    }

    public Ping(Long id, Long idAccount, String text) {
        this.id = id;
        this.idAccount = idAccount;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getIdPingReplied() {
        return idPingReplied;
    }

    public void setIdPingReplied(Long idPingReplied) {
        this.idPingReplied = idPingReplied;
    }
}
