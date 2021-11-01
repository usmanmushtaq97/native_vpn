package com.tss.lithavpn;

public class PlainModels {
    String duration, descriptions,price;

    public PlainModels(String duration, String descriptions, String price) {
        this.duration = duration;
        this.descriptions = descriptions;
        this.price = price;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
