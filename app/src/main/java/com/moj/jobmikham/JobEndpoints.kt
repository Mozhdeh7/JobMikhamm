package com.moj.jobmikham

import retrofit2.Call
import retrofit2.http.GET

interface JobEndpoints {

    @GET("/positions.json?description=api")
    fun getJob(): Call<List<Resultt>>
}