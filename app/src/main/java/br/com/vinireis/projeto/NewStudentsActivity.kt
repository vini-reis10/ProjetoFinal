package br.com.vinireis.projeto

import br.com.vinireis.projeto.databinding.ActivityNewStudentsBinding
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.vinireis.projeto.model.Students
import br.com.vinireis.projeto.repository.StudentsRepository
import com.google.android.material.snackbar.Snackbar

class NewStudentsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityNewStudentsBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_students)

        binding.btnSave.setBackgroundResource(R.drawable.ic_baseline_list_alt_24)

        binding.btnSave.setOnClickListener{
            val repository = StudentsRepository(applicationContext)
            val studentsName = binding.txtName.text.toString()
            val studentsEmail = binding.txtEmail.text.toString()

            if(validarNome(studentsName) && validarEmail(studentsEmail)){
                val students = Students(
                    name = studentsName,
                    email = studentsEmail
                )
                if (repository.insert(students) != 0){
                    Snackbar.make(it,R.string.label_msg_confirm,Snackbar.LENGTH_SHORT).show()
                }
            }else{Toast.makeText(applicationContext,R.string.unaccepted_data, Toast.LENGTH_SHORT).show()}


        }

        supportActionBar?.setTitle(R.string.title_new_student)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    private fun validarNome(nome: String): Boolean{
        val padrao = Regex("^[A-Za-z]{3,}\$")
        return padrao.containsMatchIn(nome)
    }

    private fun validarEmail(email: String): Boolean{
        val padrao = Regex("^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+\$")
        return padrao.containsMatchIn(email)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}