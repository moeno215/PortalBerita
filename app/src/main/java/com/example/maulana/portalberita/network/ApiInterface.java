package com.example.maulana.portalberita.network;

import com.example.maulana.portalberita.model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("lihat_berita.php")
    Call<ResponseBerita> getBerita ( );

}
