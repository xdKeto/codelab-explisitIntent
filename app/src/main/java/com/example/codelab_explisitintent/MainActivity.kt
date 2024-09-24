package com.example.codelab_explisitintent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var _btnExplisit1 = findViewById<Button>(R.id.btnExplisit1)
        _btnExplisit1.setOnClickListener {
            val intent = Intent (this@MainActivity, actIntent2::class.java)
            startActivity(intent)
        }

        var _editExplisit = findViewById<EditText>(R.id.edtExplisit)
        var _btnExplisit2 = findViewById<Button>(R.id.btnExplisit2)
        _btnExplisit2.setOnClickListener {
            val intent = Intent(this@MainActivity, actIntent3::class.java).apply {
                putExtra(actIntent3.dataTerima, _editExplisit.text.toString())
            }
            startActivity(intent)
        }

        val isiPegawai : ArrayList<Pegawai> = arrayListOf()
        isiPegawai.add(Pegawai(1, "Yesto", "test"))
        isiPegawai.add(Pegawai(2, "Warren", "test"))

        var _btnExplisit3 = findViewById<Button>(R.id.btnExplisit3)
        _btnExplisit3.setOnClickListener {

            val nip = findViewById<EditText>(R.id.edtNIP).text.toString().toInt()
            val nama = findViewById<EditText>(R.id.edtNama).text.toString()
            val dept = findViewById<EditText>(R.id.edtDept).text.toString()

            isiPegawai.add(Pegawai(nip, nama, dept))
            val intent = Intent(this@MainActivity, actIntent4::class.java).apply {
                putParcelableArrayListExtra(actIntent4.dataPegawai, isiPegawai)
            }
            startActivity(intent)
        }

    }
}