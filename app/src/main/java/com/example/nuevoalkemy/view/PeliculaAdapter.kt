package com.example.nuevoalkemy.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevoalkemy.R

class PeliculaAdapter(val titulo:List<String>):RecyclerView.Adapter<PeliculaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  PeliculaViewHolder(layoutInflater.inflate(R.layout.portada,parent,false))
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val item = titulo[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = titulo.size

}