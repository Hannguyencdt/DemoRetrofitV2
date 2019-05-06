package net.ilightning.demoretrofitv2.api;


import net.ilightning.demoretrofitv2.config.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestManager {

    private static API api;

    public static API getApi() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(API.class);
        }
        return api;
    }
}
