package com.mkadiri.entity;

import com.mkadiri.model.HooverDetailsInput;
import com.mkadiri.model.HooverDetailsOutput;
import javax.persistence.*;
import java.util.Date;

@Entity
public class HooverHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Embedded
    private HooverDetailsInput hooverDetailsInput;

    @Embedded
    private HooverDetailsOutput hooverDetailsOutput;

    private Date created;

    @PrePersist
    protected void onCreate() {
        this.created = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HooverDetailsInput getHooverDetailsInput() {
        return hooverDetailsInput;
    }

    public void setHooverDetailsInput(HooverDetailsInput hooverDetailsInput) {
        this.hooverDetailsInput = hooverDetailsInput;
    }

    public HooverDetailsOutput getHooverDetailsOutput() {
        return hooverDetailsOutput;
    }

    public void setHooverDetailsOutput(HooverDetailsOutput hooverDetailsOutput) {
        this.hooverDetailsOutput = hooverDetailsOutput;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}