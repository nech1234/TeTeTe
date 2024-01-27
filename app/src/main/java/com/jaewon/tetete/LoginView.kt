package com.jaewon.tetete

interface LoginView {
    fun onLoginSuccess(code : Int)
    fun onLoginFailure(message : String)
}