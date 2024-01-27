package com.jaewon.tetete

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("member")
    fun signUp(@Body user: User) : Call<BaseResponse>
}