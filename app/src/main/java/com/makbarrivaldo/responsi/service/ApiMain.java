package com.makbarrivaldo.responsi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public RsRepository getApiRs(){
        String BASE_URL ="https://covid19-public.digitalservice.id/api/v1/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RsRepository.class);
    }

    public KasusRepository getApiKasus(){
        String BASE_URL ="https://covid19-public.digitalservice.id/api/v1/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(KasusRepository.class);
    }
}
