package br.com.vinireis.projeto.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.vinireis.projeto.R

class StudentsAdapter(private val students: List<Students>,private val observer:IDelete): RecyclerView.Adapter<StudentsHolder>(){
    override fun getItemCount(): Int = students.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false)
        return StudentsHolder(view)
    }


    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        holder.txt_name.text = students[position].name
        holder.txt_email.text = students[position].email
        holder.btnTrash.setOnClickListener { observer.deleteID(id = students[position].id) }

    }

}

class StudentsHolder(view: View): RecyclerView.ViewHolder(view){
    var txt_name:TextView = view.findViewById(R.id.txt_name)
    var txt_email:TextView = view.findViewById(R.id.txt_email)
    var btnTrash:ImageButton = view.findViewById(R.id.btnTrash)
}