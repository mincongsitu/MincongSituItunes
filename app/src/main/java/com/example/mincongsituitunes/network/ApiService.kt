package com.example.mincongsituitunes.network

import com.example.mincongsituitunes.data.ItuneResponse

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    fun getTracks(
        @Query("term") genre: String,
        @Query("amp;media") media: String = "music",
        @Query("amp;entity") entity: String = "song",
        @Query("limit") limit: Int = 50

    ): Call<ItuneResponse>

    companion object{
        private var baseUrl: String = "https://itunes.apple.com/"
        private var retrofit: Retrofit? = null

        fun getRetrofitInstance(): Retrofit?{
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}


// search?term=rock&amp;limit=50