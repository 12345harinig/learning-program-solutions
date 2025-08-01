package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code")
    private String code;

    @Column(name = "st_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "st_open", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal open;

    @Column(name = "st_close", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal close;

    @Column(name = "st_volume")
    private long volume;

    // ✅ Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    // ✅ toString() for logging

    @Override
    public String toString() {
        return "Stock [id=" + id + ", code=" + code + ", date=" + date +
                ", open=" + open + ", close=" + close + ", volume=" + volume + "]";
    }
}
