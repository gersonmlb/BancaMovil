package itsight.bancamovil.io.service.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BancaMovilApiAdapter {

    private static Retrofit API_ADAPTER;
    public static Retrofit getInstance(){

        //The adapter will be a singleton
        if(API_ADAPTER == null)
            API_ADAPTER = new Retrofit.Builder()
//                    .setLogLevel(Retrofit.LogLevel.BASIC)
//                    .setEndpoint(BancaMovilApiConstants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BancaMovilApiConstants.BASE_URL)
                    .build();


        return API_ADAPTER;
    }
}
