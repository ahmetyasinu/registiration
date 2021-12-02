package com.api.system.registration.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @Column(name = "name_surname")
    private String nameSurname;
    @Column(name = "sequence_no")
    private Integer sequenceNo;
    @Column(name = "tel_no")
    private String telNo;
    @Column(name = "reference")
    private String reference;
    @Column(name = "paid_price")
    private Integer paidPrice;
    @Column(name = "remaining_price")
    private Integer remainingPrice;
    @Column(name="client_no")
    private  Integer clientNo;

    public Client() {
    }

    public Client(String nameSurname, String telNo, String reference, Integer paidPrice, Integer remainingPrice, Integer sequenceNo,Integer clientNo) {
        this.nameSurname = nameSurname;
        this.telNo = telNo;
        this.reference = reference;
        this.paidPrice = paidPrice;
        this.remainingPrice = remainingPrice;
        this.sequenceNo = sequenceNo;
        this.clientNo = clientNo;

    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(Integer paidPrice) {
        this.paidPrice = paidPrice;
    }

    public Integer getRemainingPrice() {
        return remainingPrice;
    }

    public void setRemainingPrice(Integer remainingPrice) {
        this.remainingPrice = remainingPrice;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Integer getClientNo() {
        return clientNo;
    }

    public void setClientNo(Integer clientNo) {
        this.clientNo = clientNo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nameSurname='" + nameSurname + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", telNo='" + telNo + '\'' +
                ", reference='" + reference + '\'' +
                ", paidPrice=" + paidPrice +
                ", remainingPrice=" + remainingPrice +
                ", clientNo=" + clientNo +
                '}';
    }
}
