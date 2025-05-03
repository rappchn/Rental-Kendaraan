/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalkendaraan.model;

/**
 *
 * @author Rappchn
 */
public class kendaraan {
    private String merk;
    private String tahun;
    private String plat;

    // Konstruktor
    public kendaraan(String merk, String tahun, String plat) {
        this.merk = merk;
        this.tahun = tahun;
        this.plat = plat;
    }

    // Getter dan Setter
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }
}
