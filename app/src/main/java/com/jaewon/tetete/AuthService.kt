package com.jaewon.tetete

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var signUpView: SignUpView

    fun setSignUpView(signUpView: SignUpView){
        this.signUpView = signUpView
    }

    fun signUp(user : User) {
        RetrofitInstance.authApi.signUp(user).enqueue(object: Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                Log.d("SignUp-Success", response.toString())
                val response : BaseResponse = response.body()!!
                when(response.code) {
                    200 -> signUpView.onSignUpSuccess()
                    else -> Log.e("notSuccess","response.code")
                }
            }
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                Log.d("SignUp-Failure", t.message.toString())
            }
        })
        Log.d("SignUpActivity", "All Finished")
    }
}