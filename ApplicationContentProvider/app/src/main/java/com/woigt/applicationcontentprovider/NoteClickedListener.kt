package com.woigt.applicationcontentprovider

import android.database.Cursor

// Interface para abrigar os métodos de click do adapter
interface NoteClickedListener {
    fun noteClickedItem(cursor: Cursor)
    fun noteRemoveItem(cursor: Cursor?)
}