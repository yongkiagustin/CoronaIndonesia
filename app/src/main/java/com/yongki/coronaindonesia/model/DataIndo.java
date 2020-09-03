package com.yongki.coronaindonesia.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataIndo {
    @SerializedName("positif")
    @Expose
    private String positif;
    @SerializedName("sembuh")
    @Expose
    private String sembuh;
    @SerializedName("meninggal")
    @Expose
    private String meninggal;
    @SerializedName("dirawat")
    @Expose
    private String dirawat;

    public String getDirawat() {
        return dirawat;
    }

    public void setDirawat(String dirawat) {
        this.dirawat = dirawat;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }
}
