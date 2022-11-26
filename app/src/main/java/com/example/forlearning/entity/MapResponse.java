package com.example.forlearning.entity;

public class MapResponse {
    private String address;
    private String cont;
    private int status;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public String getCont() {
        return cont;
    }

    public int getStatus() {
        return status;
    }
}
