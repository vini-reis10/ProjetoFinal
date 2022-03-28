// Classe que cria o arquivo no banco de dados.

package br.com.vinireis.projeto.dao

import br.com.vinireis.projeto.model.Students
import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource


class StudentDAO(connectionSource: ConnectionSource) : BaseDaoImpl<Students, Int>(Students::class.java) {

    init{
        setConnectionSource(connectionSource)
        initialize()
    }
}