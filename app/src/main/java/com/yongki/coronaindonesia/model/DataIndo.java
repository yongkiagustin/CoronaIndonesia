package com.yongki.coronaindonesia.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataIndo {
    @SerializedName("positif")
    @Expose
    private Integer positif;
    @SerializedName("sembuh")
    @Expose
    private Integer sembuh;
    @SerializedName("meninggal")
    @Expose
    private Integer meninggal;

    public Integer getPositif() {
        return positif;
    }

    public Integer getSembuh() {
        return sembuh;
    }

    public Integer getMeninggal() {
        return meninggal;
    }

    public void setPositif(Integer positif) {
        this.positif = positif;
    }

    public void setSembuh(Integer sembuh) {
        this.sembuh = sembuh;
    }

    public void setMeninggal(Integer meninggal) {
        this.meninggal = meninggal;
    }
}
