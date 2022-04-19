package com.example.nuevoalkemy.view.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nuevoalkemy.data.Pelicula
import com.example.nuevoalkemy.databinding.PortadaBinding

class PeliculaAdapter(val listadoPelicula:List<Pelicula>):RecyclerView.Adapter<PeliculaAdapter.ViewHolder>() {
    inner class ViewHolder (val binding:PortadaBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PortadaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listadoPelicula[position]){
                binding.tvTitulo.text = title
                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500$poster_path").into(binding.ivPortada)

//                Glide.with(itemView.context).load(poster_path).into(binding.ivPortada)
            }
        }
    }

    override fun getItemCount() = listadoPelicula.size


}