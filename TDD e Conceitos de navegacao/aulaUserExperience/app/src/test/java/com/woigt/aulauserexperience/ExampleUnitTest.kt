package com.woigt.tdd

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.woigt.aulauserexperience.Contact
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)  // Criando classe para fazer simulações do test
class ContactHelperTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharedPreferences =
        context.getSharedPreferences("arquivo", Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharedPreferences)



    @Test
    fun `Quando chamar o metodo getListContacts() com 2 contatos, deve retornar uma lista de 2 contatos`() {
        // Preparação
        mockListaDoisContatos() // seta os valores para o teste

        // Validação
        val list = contactHelper.getListContacts()  // Teste os dados se seguem as especificações
        assertEquals(2,list.size)
    }

    @Test
    fun `Quando chamar o metodo getListContacts() sem contatos, deve retornar uma lista vazia`(){
        // Prepara
        mockListaContatosVazia()
        // Valida
        val list =contactHelper.getListContacts()
        assertEquals(0, list.size)
    }

    private fun mockListaDoisContatos() {  // Mock (Dados falsos para realizar o teste)
        contactHelper.setListContacts(
            arrayListOf(
                Contact(
                    "Igor Ferrari",
                    "(00)0000-0000",
                    "img.jpg"
                ),
                Contact(
                    "João Woigt",
                    "(99)9999-9999",
                    "img2.jpg"
                ),
            )
        )

    }
    private fun mockListaContatosVazia() {
        contactHelper.setListContacts(arrayListOf())
    }
}

