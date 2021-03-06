package org.mercury.oschina.synthesis.utils;


import org.mercury.oschina.synthesis.api.OsChinaApi;
import org.mercury.oschina.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CC on 2016/7/2.
 * Hello wolrd
 */
public class RetrofitUtil {
    private static OsChinaApi httpApi;

    public static OsChinaApi createHttpApiInstance() {
        if (httpApi == null) {
            if (httpApi == null) {
                httpApi = new Retrofit
                        .Builder()
                        .baseUrl(Constants.API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(OsChinaApi.class);
            }
        }
        return httpApi;
    }



}
