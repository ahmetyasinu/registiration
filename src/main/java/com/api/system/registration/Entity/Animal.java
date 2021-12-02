package com.api.system.registration.Entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "animal")
public class Animal implements Serializable {

    @Id
    @Column(name = "sequence_no")
    private Integer sequenceNo;
    @Column(name = "id")
    private Integer id;
    @Column(name = "live_weight")
    private Integer liveWeight;
    @Column(name = "price")
    private Integer price;
    @Column(name = "date")
    private String date;

    public Animal() {
    }

    public Animal(Integer sequenceNo,  Integer id, Integer liveWeight, Integer price, String date) {
        this.sequenceNo = sequenceNo;
        this.id = id;
        this.liveWeight = liveWeight;
        this.price = price;
        this.date = date;
    }


    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer cutNo) {
        this.id = id;
    }


    public Integer getLiveWeight() {
        return liveWeight;
    }

    public void setLiveWeight(Integer liveWeight) {
        this.liveWeight = liveWeight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "sequenceNo=" + sequenceNo +
                ", id=" + id +
                ", liveWeight=" + liveWeight +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
