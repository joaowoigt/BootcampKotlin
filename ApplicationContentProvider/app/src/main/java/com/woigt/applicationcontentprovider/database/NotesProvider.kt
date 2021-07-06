package com.woigt.applicationcontentprovider.database

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.media.UnsupportedSchemeException
import android.net.Uri
import android.provider.BaseColumns._ID
import com.woigt.applicationcontentprovider.database.NotesDataBaseHelper.Companion.TABLE_NOTES

class NotesProvider : ContentProvider() {
    // Objeto responsavel por fazer a validação de URL do provider
    private lateinit var mUriMatcher: UriMatcher

    // Instanciando o Banco de dados
    private lateinit var dbHelper: NotesDataBaseHelper

    override fun onCreate(): Boolean {
        mUriMatcher = UriMatcher(UriMatcher.NO_MATCH)  // Instanciar vazio

        // Indentificando o contentProvider
        mUriMatcher.addURI(AUTHORITY, "notes", NOTES)
        mUriMatcher.addURI(AUTHORITY, "notes/#", NOTES_BY_ID)

        // Ativa a criação do banco de dados
        if(context != null) { dbHelper = NotesDataBaseHelper(context as Context)
        }
        return true
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        if (mUriMatcher.match(uri) == NOTES_BY_ID) {
            val db: SQLiteDatabase = dbHelper.writableDatabase  // Permite mexer com o banco de dados
            val linesAffect: Int = db.delete(TABLE_NOTES, "$_ID = ?",
                arrayOf(uri.lastPathSegment))
            db.close()
            context?.contentResolver?.notifyChange(uri, null)  // Manipulando o content provider
            return linesAffect
        }else {
            throw UnsupportedSchemeException("Uri Inválida para exclusão!")
        }
    }

    override fun getType(uri: Uri): String? = throw UnsupportedSchemeException("Uri não implementado")

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        if (mUriMatcher.match(uri) == NOTES){
            val db: SQLiteDatabase = dbHelper.writableDatabase
            val id = db.insert(TABLE_NOTES, null, values)  // Insere no banco de dados
            val insertUri = Uri.withAppendedPath(BASE_URI, id.toString())  // Declarando o endereço de content provider, foi inserido este valor
            db.close()
            context?.contentResolver?.notifyChange(uri, null)
            return insertUri
        } else {
            throw UnsupportedSchemeException("Uri Inválida para inserção!")
        }
    }


    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return when {
            mUriMatcher.match(uri) == NOTES -> {
                val db: SQLiteDatabase = dbHelper.writableDatabase
                val cursor = db.query(TABLE_NOTES, projection, selection, selectionArgs,
                    null, null, sortOrder)  // Retorno de dados
                cursor.setNotificationUri(context?.contentResolver, uri)
                return cursor
            }
            mUriMatcher.match(uri) == NOTES_BY_ID -> {
                val db: SQLiteDatabase = dbHelper.writableDatabase
                val cursor = db.query(TABLE_NOTES, projection, "$_ID = ?",
                    arrayOf(uri.lastPathSegment), null, null, sortOrder)
                cursor.setNotificationUri(context?.contentResolver, uri)
                return cursor
            }
            else -> {
                throw UnsupportedSchemeException("Uri não implementada!")
            }
        }
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        if (mUriMatcher.match(uri) == NOTES_BY_ID) {
            val db: SQLiteDatabase = dbHelper.writableDatabase
            val linesAffect = db.update(TABLE_NOTES, values, "$_ID = ?",
                arrayOf(uri.lastPathSegment))  // Operação no banco de dados
            db.close()
            context?.contentResolver?.notifyChange(uri, null)
            return linesAffect
        }else {
            throw UnsupportedSchemeException("Uri não implementada!")
        }
    }

    // Fazer a declaração destes objetos primeiro
    companion object {
        // Endereço para o tratamento do provider
        const val AUTHORITY = "com.woigt.applicationcontentprovider.provider"
        val BASE_URI = Uri.parse("content://$AUTHORITY")  // Requisita o contentProvider
        val URI_NOTES = Uri.withAppendedPath(BASE_URI, "notes") // Nomeia uma url notes

        const val NOTES = 1
        const val NOTES_BY_ID = 2
    }
}