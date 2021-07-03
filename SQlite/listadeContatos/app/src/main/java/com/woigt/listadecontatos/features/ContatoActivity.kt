package com.woigt.listadecontatos.features

import android.os.Bundle
import android.view.View
import com.woigt.listadecontatos.ContatosVO
import com.woigt.listadecontatos.R
import com.woigt.listadecontatos.application.ContatoApplication
import com.woigt.listadecontatos.bases.BaseActivity
import kotlinx.android.synthetic.main.activity_contato.*
import kotlinx.android.synthetic.main.activity_contato.toolBar

class ContatoActivity : BaseActivity() {

    private var idContato: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
        setupToolBar(toolBar, "Contato",true)
        setupContato()
        btnSalvarConato.setOnClickListener { onClickSalvarContato() }
    }

    private fun setupContato(){
        // Aplicando Threads e tela de loading
        idContato = intent.getIntExtra("index",-1)
        if (idContato == -1){
            btnExcluirContato.visibility = View.GONE
            return
        }
        progress.visibility = View.VISIBLE
        Thread(Runnable {
            Thread.sleep(1500)  // Somente para perceber o loading
            var lista = ContatoApplication.instance.helperDB?.buscarContatos(
                "$idContato", true) ?: return@Runnable
            var contato = lista.getOrNull(0) ?: return@Runnable
            runOnUiThread{
                etNome.setText(contato.nome)
                etTelefone.setText(contato.telefone)
                progress.visibility = View.GONE
            }
        }).start()

    }

    private fun onClickSalvarContato(){
        val nome = etNome.text.toString()
        val telefone = etTelefone.text.toString()
        val contato = ContatosVO(
            idContato,
            nome,
            telefone
        )
        progress.visibility = View.VISIBLE
        Thread(Runnable {
            Thread.sleep(1500)
            if(idContato == -1) {
                ContatoApplication.instance.helperDB?.salvarContato(contato)  // Cria contato
            }else{
                ContatoApplication.instance.helperDB?.updateContato(contato)  // Alterar
            }
            runOnUiThread{
                progress.visibility = View.GONE
                finish()
            }
        }).start()

    }

    fun onClickExcluirContato(view: View) {
        if(idContato > -1){
            progress.visibility = View.VISIBLE
            Thread(Runnable {
                Thread.sleep(1500)
                ContatoApplication.instance.helperDB?.deletarContato(idContato)
                progress.visibility = View.GONE
                finish()
            }).start()
        }
    }
}