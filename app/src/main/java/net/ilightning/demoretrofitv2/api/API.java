package net.ilightning.demoretrofitv2.api;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {

    @GET("/app/api/data.json")
    Call<ResponseBody> getData();

    @GET("/app/api/login.json")
    Call<ResponseBody> getDataHome();

    @POST("/app/api/data.json")
    Call<ResponseBody> getLogin(Header header, RequestBody requestBody);


}
