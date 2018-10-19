package com.example.maulana.portalberita.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseBerita{

	@SerializedName("data_berita")
	private List<DataBeritaItem> dataBerita;

	@SerializedName("status")
	private boolean status;

	public void setDataBerita(List<DataBeritaItem> dataBerita){
		this.dataBerita = dataBerita;
	}

	public List<DataBeritaItem> getDataBerita(){
		return dataBerita;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseBerita{" + 
			"data_berita = '" + dataBerita + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}