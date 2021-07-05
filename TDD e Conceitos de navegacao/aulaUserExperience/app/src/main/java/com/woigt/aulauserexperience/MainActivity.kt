package com.woigt.aulauserexperience

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.woigt.aulauserexperience.DetailActivity.Companion.EXTRA_CONTACT

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    // Componente do Recycler View
    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }
    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)


        initDrawer()
        fetchListContact()
        bindViews()


    }

    private fun fetchListContact() {
        val list =  arrayListOf(  // Mock para teste
            Contact(
                "João Woigt",
                "(00) 0000- 0000",
                "img.jpg"
            ),
            Contact(
                "João Woigt",
                "(99) 9999- 9999",
                "img.jpg"
            )
        )
        getInstanceSharedPreference().edit {
            val json = Gson().toJson(list)
            putString("contacts", json)
            commit()
        }


    }

    private fun getInstanceSharedPreference(): SharedPreferences {
        return getSharedPreferences("com.woigt.aulauserexperience.PREFERENCES", Context.MODE_PRIVATE)
    }
    // Inicialização do DrawerLayout
    private fun initDrawer() {
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Abrir e fechar o menu
        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.open_drawer, R.string.closer_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()


    }


    // Manipulação do RecyclerView
    private fun bindViews() {
        rvList.adapter = adapter  // Adapter do recycler view é o adapter criado
        rvList.layoutManager = LinearLayoutManager(this) // como ele vai se comportar e qual vai ser seu viewgroup
        updateList()

    }

    private fun getListContacts(): List<Contact> {
        val list = getInstanceSharedPreference().getString("contacts", "[]")
        val turnsType = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(list, turnsType)
    }

    // Faz a alteração da lista
    private fun updateList() {
        val list = getListContacts()
        adapter.updateList(list)

    }
    // Encapsular o Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Implementando metodos para criar o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {  // Identifica o id do menu tocado
            R.id.item_menu_1 -> {
                showToast("Exibindo item de menu 1")
                true
            }
            R.id.item_menu_2 -> {
                showToast("Exibindo item de menu 2")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}