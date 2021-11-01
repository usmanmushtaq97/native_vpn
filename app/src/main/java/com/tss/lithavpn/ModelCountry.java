package com.tss.lithavpn;

public class ModelCountry {
    int img;
    String country;

    public ModelCountry(int img, String country) {
        this.img = img;
        this.country = country;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
