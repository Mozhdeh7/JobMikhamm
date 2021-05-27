package com.moj.jobmikham

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface APIService {

    @GET("https://jobs.github.com/positions.json?description=api")
    suspend fun getJob(): Response<List<JobInfo>>

    fun parseJson() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobs.github.com")
            .addConverterFactory(MoshiConverterFactory.create())

        // Create Service
        val service = retrofit.create(APIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.getJob()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val items = response.body()
                    if (items != null) {
                        for (i in 0 until items.count()) {
                            // ID
                            val id = items[i].employeeId ?: "N/A"
                            Log.d("title: ", title)

                            // Employee Name
                            val employeeName = items[i].employeeName ?: "N/A"
                            Log.d("Employee Name: ", employeeName)

                            // Employee Salary
                            val employeeSalary = items[i].employeeSalary ?: "N/A"
                            Log.d("Employee Salary: ", employeeSalary)

                            // Employee Age
                            val employeeAge = items[i].employeeAge ?: "N/A"
                            Log.d("Employee Age: ", employeeAge)

                        }
                    }

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }



    }


}