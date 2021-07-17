package com.lenguyenthaikhang.demotkthp;

public class UserModel {
    String name;
    String msv;
     String namsinh;
     String lop;
     String que;
   String sdt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;


    public UserModel(String name, String msv, String namsinh, String lop, String que, String sdt, String email) {
        this.name = name;
        this.msv = msv;
        this.namsinh = namsinh;
        this.lop = lop;
        this.que = que;
        this.sdt = sdt;
        this.email = email;
    }

    public UserModel() {
    }
}
