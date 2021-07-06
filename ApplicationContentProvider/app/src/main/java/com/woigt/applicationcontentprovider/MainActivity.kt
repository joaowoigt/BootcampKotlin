package com.woigt.applicationcontentprovider

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns._ID
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.woigt.applicationcontentprovider.database.NotesDataBaseHelper.Companion.TITLE_NOTES
import com.woigt.applicationcontentprovider.database.NotesProvider.Companion.URI_NOTES

// Necessario chamar o LoaderManeger
class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {
    // Instanciar o layout
    lateinit var noteRecycleView: RecyclerView
    lateinit var noteAdd: FloatingActionButton

    // Criar o adapter na activity
    lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdd = findViewById(R.id.note_add)
        noteAdd.setOnClickListener {
            NotesDetailFragment().show(supportFragmentManager, "dialog")
        }


        adapter = NotesAdapter(object : NoteClickedListener {
            override fun noteClickedItem(cursor: Cursor) {
                val id = cursor.getLong(cursor.getColumnIndex(_ID))
                val fragment = NotesDetailFragment.newInstance(id)
                fragment.show(supportFragmentManager, "dialog")

            }

            override fun noteRemoveItem(cursor: Cursor?) {
               val id = cursor?.getLong(cursor.getColumnIndex(_ID))
                contentResolver.delete(Uri.withAppendedPath(URI_NOTES, id.toString()),
                    null, null)  // Interage com o contentProvider
            }

        })
        adapter.setHasStableIds(true)  // não permite id repetido no adapter

        noteRecycleView = findViewById(R.id.notes_recycle)
        noteRecycleView.layoutManager = LinearLayoutManager(this)  // Manager do recycleview
        noteRecycleView.adapter = adapter   // Passar o adapter para o recycleview

        // Pulo do gato do LoaderManager
        LoaderManager.getInstance(this).initLoader(0, null, this)
    }

    // Instancia a pesquisa do contentProvider
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> =
        CursorLoader(this, URI_NOTES, null, null,
            null, TITLE_NOTES)



    // Manipula os dados recebidos
    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        if (data != null) { adapter.setCursor(data) }
    }


    // Acabar com a pesquisa em segundo plano do LoadManager
    override fun onLoaderReset(loader: Loader<Cursor>) {
        adapter.setCursor(null)
    }
}