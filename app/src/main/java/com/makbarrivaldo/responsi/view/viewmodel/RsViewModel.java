package com.makbarrivaldo.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.makbarrivaldo.responsi.model.rs.RsDataItem;
import com.makbarrivaldo.responsi.model.rs.RsResponse;
import com.makbarrivaldo.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RsViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<RsDataItem>> rsDataItem = new MutableLiveData<>();

    public void setRsData(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiRs().getRsResponse().enqueue(new Callback<RsResponse>() {
            @Override
            public void onResponse(Call<RsResponse> call, Response<RsResponse> response) {
                RsResponse rsResponse  = response.body();
                if (rsResponse != null){
                    ArrayList<RsDataItem> rsDataItems = rsResponse.getData();
                    rsDataItem.postValue(rsDataItems);
                }
            }

            @Override
            public void onFailure(Call<RsResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<RsDataItem>> getRsItem(){
        return rsDataItem;
    }
}
