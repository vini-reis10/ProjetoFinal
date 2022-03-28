package br.com.vinireis.projeto.repository

import android.content.Context
import br.com.vinireis.projeto.dao.DataBaseHelper
import br.com.vinireis.projeto.dao.StudentDAO
import br.com.vinireis.projeto.model.Students

class StudentsRepository(context: Context) {
    private val dbHelper = DataBaseHelper(context)
    private val dao = StudentDAO(dbHelper.connectionSource)

    fun insert(students: Students): Int{
        val result = dao.create(students)
        dao.connectionSource.close()
        return result

    }
    fun findAll() = dao.queryForAll()

    fun deleteForId(id:Int):Int{
        val result = dao.deleteById(id)
        dao.connectionSource.close()
        return result
    }
}