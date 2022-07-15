package com.example.mincongsituitunes.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mincongsituitunes.R
import com.example.mincongsituitunes.data.Itune
import com.example.mincongsituitunes.data.ItuneResponse
import com.example.mincongsituitunes.databinding.ClassicFragmentItunesListBinding
import com.example.mincongsituitunes.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



//rock
class ItunesListFragment(var genre: String): Fragment() {

    lateinit var binding: ClassicFragmentItunesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ClassicFragmentItunesListBinding.inflate(layoutInflater)

        fetchTracks()

        return binding.root
    }

    private fun fetchTracks(){
        ApiService.getRetrofitInstance()?.create(ApiService::class.java)
            ?.getTracks(genre)?.enqueue(object:Callback<ItuneResponse>{
                override fun onResponse(
                    call: Call<ItuneResponse>,
                    response: Response<ItuneResponse>
                ) {
                    if(response.isSuccessful){
                        val itunesAdapter = ItunesAdapter(response.body()!!.results, ::playSong)
                        binding.rvClassicItuneList.adapter = itunesAdapter
                    }
                }

                override fun onFailure(call: Call<ItuneResponse>, t: Throwable) {
                    Toast.makeText(context,t.message, Toast.LENGTH_LONG).show()
                }
            })
    }

    fun playSong(song: String){
        val intent: Intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.parse(song),"audio/mp4")
        startActivity(intent)
    }
}