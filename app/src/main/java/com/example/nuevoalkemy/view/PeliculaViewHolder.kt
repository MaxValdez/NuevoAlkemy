package com.example.nuevoalkemy.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevoalkemy.databinding.PortadaBinding
import com.squareup.picasso.Picasso

class PeliculaViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    private val binding = PortadaBinding.bind(view)
    fun bind (portada:String){
        Picasso.get().load(portada).into(binding.ivPortada)

    }
}