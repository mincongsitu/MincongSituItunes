package com.example.mincongsituitunes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mincongsituitunes.R
import com.example.mincongsituitunes.data.Itune
import com.example.mincongsituitunes.databinding.ItuneListItemBinding

class ItunesAdapter(
    private val list: List<Itune>,
    private val playSong: (String) -> Unit
    ):
    RecyclerView.Adapter<ItunesAdapter.ItunesViewHolder>(){


        inner class ItunesViewHolder(private val binding: ItuneListItemBinding)
            :RecyclerView.ViewHolder(binding.root){
                fun onBind(ituneTrack: Itune){

                    binding.tvCollectionName.text = ituneTrack.collectionName
                    binding.tvArtist.text = ituneTrack.artistName
                    binding.tvTrackPrice.text = ituneTrack.getPrice()

                    Glide.with(binding.ivCollectionPhoto)
                        .load(ituneTrack.artworkUrl60)
                        .placeholder(R.drawable.loading_icon)
                        .into(binding.ivCollectionPhoto)

                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItunesViewHolder {
        return ItunesViewHolder(
            ItuneListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItunesViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}