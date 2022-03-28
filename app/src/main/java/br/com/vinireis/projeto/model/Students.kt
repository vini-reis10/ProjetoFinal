package br.com.vinireis.projeto.model

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "Students")      //Construtor dos itens "estudantes"
data class Students(
    @DatabaseField(generatedId = true)  //Criar um novo Id pro estudante criado que vai substituir no item na tela partindo de 0...
    val id: Int = 0, // Igual a zero significa que está iniciando
    @DatabaseField
    val name: String = "",
    @DatabaseField
    val email: String = ""
)