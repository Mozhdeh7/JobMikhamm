package com.moj.jobmikham

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.moj.jobmikham.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val request = ServiceBuilder.buildService(JobEndpoints::class.java)
        val call = request.getJob()

        call.enqueue(object : retrofit2.Callback<List<Resultt>> {
            override fun onResponse(call: Call<List<Resultt>>, response: Response<List<Resultt>>) {
                if (response.isSuccessful)
                    Log.d("oktag", "its okeey")
            }

            override fun onFailure(call: Call<List<Resultt>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
            }


        })


    }

}
