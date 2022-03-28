package br.com.vinireis.projeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vinireis.projeto.R.*
import br.com.vinireis.projeto.databinding.ActivityMainBinding
import br.com.vinireis.projeto.model.IDelete
import br.com.vinireis.projeto.model.StudentsAdapter
import br.com.vinireis.projeto.repository.StudentsRepository

class MainActivity : AppCompatActivity(),IDelete {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout.activity_main)

        binding.btnAddStudants.setOnClickListener {
            val intent = Intent(applicationContext,NewStudentsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        updateList()

    }

    private fun updateList() {
        val repository = StudentsRepository(applicationContext)

        val students = repository.findAll()

        binding.rvStudants.adapter = StudentsAdapter(students, this)
        binding.rvStudants.hasFixedSize()
        binding.rvStudants.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun deleteID(id: Int) {
        val repository = StudentsRepository(applicationContext)

        val deleteID = repository.deleteForId(id)

        if (deleteID != 0 ){
            updateList()
            Toast.makeText(applicationContext,string.remove_accepted,Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(applicationContext,string.error_removing,Toast.LENGTH_SHORT).show()
        }
    }
}