package com.yongki.coronaindonesia.service;

import com.yongki.coronaindonesia.model.DataIndo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetServices {
    @GET("/indonesia")
    Call<List<DataIndo>> getListCall();
}
