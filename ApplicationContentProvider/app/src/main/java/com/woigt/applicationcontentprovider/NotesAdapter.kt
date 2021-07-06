package com.woigt.applicationcontentprovider

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


import androidx.recyclerview.widget.RecyclerView
import com.woigt.applicationcontentprovider.database.NotesDataBaseHelper.Companion.DESCRIPTION_NOTES
import com.woigt.applicationcontentprovider.database.NotesDataBaseHelper.Companion.TITLE_NOTES

class NotesAdapter(private val listener: NoteClickedListener): RecyclerView.Adapter<NotesViewHolder>() {

    private var mCursor: Cursor? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder  =
        NotesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false))  // Inflando o layout

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        mCursor?.moveToPosition(position)  // Pega a posição pesquisada

        // Pega a string que o cursor estiver na posição (conteudo do TITLE_NOTES criado no contentProvider
        holder.noteTile.text = mCursor?.getString(mCursor?.getColumnIndex(TITLE_NOTES) as Int)
        holder.noteDescription.text = mCursor?.getString(mCursor?.getColumnIndex(DESCRIPTION_NOTES) as Int)
        holder.noteButtonRemove.setOnClickListener {
            mCursor?.moveToPosition(position)
            listener.noteRemoveItem(mCursor)
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener{ listener.noteClickedItem(mCursor as Cursor)}

    }

    override fun getItemCount(): Int = if (mCursor != null) mCursor?.count as Int else 0

    fun setCursor(newCursor: Cursor?) {
        mCursor = newCursor
        notifyDataSetChanged()  // Notifica que a variavel cursor agr tem um valor
    }
}

class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    // Instancaiar a variavel dos layouts
    val noteTile = itemView.findViewById(R.id.note_title) as TextView
    val noteDescription = itemView.findViewById(R.id.note_description) as TextView
    val noteButtonRemove = itemView.findViewById(R.id.note_button_remove) as Button
}