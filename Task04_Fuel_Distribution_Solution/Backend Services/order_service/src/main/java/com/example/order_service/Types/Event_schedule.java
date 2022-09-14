package com.example.order_service.Types;

public class Event_schedule {
    private String from;
    private String type;
    private  String key;
    private  String qty;
    private String orderid;
    private String stockid;
    private  String result;
    private String date;
    private  String time;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Event_schedule(String from, String type, String key, String qty, String orderid, String stockid, String result, String date, String time) {
        this.from = from;
        this.type = type;
        this.key = key;
        this.qty = qty;
        this.orderid = orderid;
        this.stockid = stockid;
        this.result = result;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event_schedule{" +
                "from='" + from + '\'' +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", qty='" + qty + '\'' +
                ", orderid='" + orderid + '\'' +
                ", stockid='" + stockid + '\'' +
                ", result='" + result + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
