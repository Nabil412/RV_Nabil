package com.example.rv_nabil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var InputNIS : EditText
    private lateinit var InputNAMA : EditText
    private lateinit var jklakilaki : RadioButton
    private lateinit var jkperempuan : RadioButton
    private lateinit var tambahData : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InputNIS = findViewById(R.id.txtInis)
        InputNAMA = findViewById(R.id.txtInama)
        jklakilaki = findViewById(R.id.rbLakiLaki)
        jkperempuan = findViewById(R.id.rbPerempuan)
        tambahData = findViewById(R.id.btnTambah)
        recyclerView = findViewById(R.id.listData)
        //membuat variabel kosong tipe array mutablelist untuk simpan data array
        //data array di simpan di data class SiswaData

        val data = mutableListOf<DataSiswa>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = SiswaAdapter(data)
        recyclerView.layoutManager = viewManager
        //setOnclicklistener umtuk tombol tambah data

        tambahData.setOnClickListener{
            // 1.membuat variabel menyimpan data
            val nis = InputNIS.text.toString()// edit text => string
            val nama = InputNAMA.text.toString()
            var jk = ""
            if (jklakilaki.isChecked){
                jk = "laki-laki"
            } else {
                jk = "Perempuan"
            }
            // simpan data ke array mutablelist
            val dataSiswa = DataSiswa(nis, nama, jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}