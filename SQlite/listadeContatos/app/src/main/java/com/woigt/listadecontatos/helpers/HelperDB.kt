package com.woigt.listadecontatos.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.woigt.listadecontatos.ContatosVO

class HelperDB(
    context: Context
): SQLiteOpenHelper(context, NOME_BANCO, null , VERSAO_ATUAL) {

    companion object {
        private val NOME_BANCO = "contato.db"
        private val VERSAO_ATUAL = 1

    }

    val TABLE_NAME = "contato"
    val COLUMNS_ID = "id"
    val COLUMNS_NOME = "nome"
    val COLUMNS_TELEFONE = "telefone"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"  // Comando SQL
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COLUMNS_ID INTEGER NOT NULL," +  // Comando SQL
            " $COLUMNS_NOME TEXT NOT NULL, $COLUMNS_TELEFONE TEXT NOT NULL," +
            "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT))"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL(DROP_TABLE)  //Recria a tabela
        }
        onCreate(db)
    }
    // Função para implementar busca com o banco de dados
    fun buscarContatos(busca: String, isBuscaPorID: Boolean = false) : List<ContatosVO> {
        val db = readableDatabase ?: return mutableListOf()  // Métodod de leitura
        var lista = mutableListOf<ContatosVO>()  // Monta a lista
        var where: String? = null
        var args: Array<String> = arrayOf()
        if (isBuscaPorID){
            where = "$COLUMNS_ID = ?"
            args = arrayOf("$busca")
        }else {
             where = "$COLUMNS_NOME LIKE ?"
            args = arrayOf("%$busca%")
        }
       var cursor =  db.query(TABLE_NAME,null, where,args,
           null, null, null)
       if (cursor == null){
           db.close()
           return mutableListOf()
       }
        while(cursor.moveToNext()) {  // Passar por todas as colunas e pegar seus valores
            var contato = ContatosVO(
                cursor.getInt(cursor.getColumnIndex(COLUMNS_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_NOME)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_TELEFONE)),
            )
            lista.add(contato)  // Adiciona os contatos retirados na verificação acima
        }
        db.close()
        return lista

    }

    fun salvarContato(contato: ContatosVO) {  // Insert
        val db = writableDatabase ?: return  // Metodo de escrita
        var content = ContentValues()  // Cria variavel que vai receber os conteudos
        content.put(COLUMNS_NOME, contato.nome)
        content.put(COLUMNS_TELEFONE, contato.telefone)
        db.insert(TABLE_NAME,null, content)  // Insere os conteudos da variavel
        db.close()

    }

    fun deletarContato(id: Int) {
        val db = writableDatabase ?: return
        val sql = "DELETE FROM $TABLE_NAME WHERE $COLUMNS_ID = ?"
        val arg = arrayOf("$id")
        db.execSQL(sql, arg)
        db.close()

    }

    fun updateContato(contato: ContatosVO) {
        val db = writableDatabase ?: return
        val sql = "UPDATE $TABLE_NAME SET $COLUMNS_NOME =?, $COLUMNS_TELEFONE = ? " +
                "WHERE $COLUMNS_ID = ?"
        val arg = arrayOf(contato.nome, contato.telefone, contato.id)
        db.execSQL(sql, arg)
        db.close()
    }

}