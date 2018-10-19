package com.example.maulana.portalberita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.maulana.portalberita.adapter.MyAdapter;
import com.example.maulana.portalberita.model.DataBeritaItem;
import com.example.maulana.portalberita.model.ResponseBerita;
import com.example.maulana.portalberita.network.ApiInterface;
import com.example.maulana.portalberita.network.InstanceRetrofit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recy)
    RecyclerView rBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadData();
    }

    private void loadData() {
//        ApiService apiService = InstanceRetrofit.getInstance();
        ApiInterface apiService = InstanceRetrofit.getClient().create(ApiInterface.class);
        Call<ResponseBerita> call = apiService.getBerita();
        call.enqueue(new Callback<ResponseBerita>() {

            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {

                if (response.isSuccessful()) {
                    List<DataBeritaItem> responseBerita = response.body().getDataBerita();
//               Log.d(" ", "onResponse data: " + responseMovie);
                    MyAdapter adapter = new MyAdapter(responseBerita, MainActivity.this);
                    rBerita.setAdapter(adapter);
                    rBerita.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                } else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }


            }


            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Log.d("", "onFailure: " + t.toString());
            }
        });
    }


}

