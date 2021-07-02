package com.woigt.listadecontatos.singleton

import com.woigt.listadecontatos.ContatosVO

// import contatos vo
object ContatoSingleton {
    var lista: MutableList<ContatosVO> = mutableListOf()
}