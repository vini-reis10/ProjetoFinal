//classe que faz conexão com o banco de dados


package br.com.vinireis.projeto.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.com.vinireis.projeto.model.Students
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class DataBaseHelper(context: Context) : OrmLiteSqliteOpenHelper(context,db,null,version) {
    companion object{
        private const val db = "students.db"
        private const val version = 1
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTable(connectionSource, Students::class.java)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {}

}