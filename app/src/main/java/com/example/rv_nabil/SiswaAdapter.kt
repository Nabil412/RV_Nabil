package com.example.rv_nabil


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SiswaAdapter(private val dataSet: MutableList<DataSiswa>):
    RecyclerView.Adapter<SiswaAdapter.SiswaHolder>() {
    class SiswaHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nis = view.findViewById<TextView>(R.id.txtDataNis)
        val nama = view.findViewById<TextView>(R.id.txtDataNama)
        val jekel = view.findViewById<TextView>(R.id.txtDataJK)
        val btnEdit = view.findViewById<Button>(R.id.btnEdit)
        val btnHapus = view.findViewById<Button>(R.id.btnHapus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_siswa_adapter, parent, false
        )


        return SiswaHolder(view)
    }

    override fun onBindViewHolder(holder: SiswaHolder, position: Int) {
        holder.nis.text = dataSet[position].nis
        holder.nama.text = dataSet[position].nama
        holder.jekel.text = dataSet[position].jekel
        holder.btnHapus.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position, dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
