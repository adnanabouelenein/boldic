package com.adnanabouelenein.boldic.data;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Callable {

    @POST("register")
    @FormUrlEncoded
    Call<CreateAccountModel> registerUrl(@Field("name") String name,
                                         @Field("phone") String phone,
                                         @Field("email") String email,
                                         @Field("password") String password);

}
