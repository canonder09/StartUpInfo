package com.example.startupinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startupinfo.databinding.ItemStartupBinding

class StartupAdapter(
    private val startups: List<Startup>,
    private val onItemClicked: (Startup) -> Unit
) : RecyclerView.Adapter<StartupAdapter.StartupViewHolder>() {

    inner class StartupViewHolder(private val binding: ItemStartupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(startup: Startup) {
            binding.tvStartupName.text = startup.name
            binding.tvFoundedYear.text = "Kuruluş Yılı: ${startup.foundedYear}"
            binding.tvSector.text = "Sektör: ${startup.sector}"
            binding.root.setOnClickListener { onItemClicked(startup) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartupViewHolder {
        val binding = ItemStartupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StartupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StartupViewHolder, position: Int) {
        holder.bind(startups[position])
    }

    override fun getItemCount() = startups.size
}