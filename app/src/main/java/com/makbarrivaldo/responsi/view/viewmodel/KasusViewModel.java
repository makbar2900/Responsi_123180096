package com.makbarrivaldo.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.makbarrivaldo.responsi.model.kasus.ContentItem;
import com.makbarrivaldo.responsi.model.kasus.Data;
import com.makbarrivaldo.responsi.model.kasus.KasusResponse;
import com.makbarrivaldo.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<ContentItem>> listContent = new MutableLiveData<>();

    public void setKasusData(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasus().getKasusResponse().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                assert response.body() != null;
                Data kasusResponse = response.body().getData();
                if (kasusResponse!=null){
                    ArrayList<ContentItem> contentItems = kasusResponse.getContent();
                    listContent.postValue(contentItems);
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<ContentItem>> getKasusContentItem(){
        return listContent;
    }
}
