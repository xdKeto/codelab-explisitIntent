package com.example.codelab_explisitintent

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class actIntent4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_act_intent4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val pegawaiList = intent.getParcelableArrayListExtra<Pegawai>(dataPegawai, Pegawai::class.java)

        val sb = StringBuilder()
        pegawaiList?.forEachIndexed { index, pegawai ->
            sb.append("Pegawai ${index + 1}:\n")
            sb.append("NIP: ${pegawai.NIP}\n")
            sb.append("Nama: ${pegawai.Nama}\n")
            sb.append("Dept: ${pegawai.Dept}\n\n")
        }

        val _getDataPegawai = findViewById<TextView>(R.id.getDataPegawai)
        _getDataPegawai.text = sb.toString()
    }

    companion object {
        const val dataPegawai = "kirimDataPegawai"
    }
}

