package com.woigt.agendabootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.*  // Importando todos eventos
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetEvent = findViewById(R.id.set_event) as Button
        btnSetEvent.setOnClickListener {

            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CONTENT_URI)  // Content = Importar CalendarContact
                .putExtra(TITLE, "Bootcamp Santander")  // Colocar itens Extrar no content que criamos
                .putExtra(EVENT_LOCATION, "Online")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())  // Seta o horario de inicio para o momento que criar a o evento
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    System.currentTimeMillis() + (60*60*1000))  // Seta horario de termino para 1h depois

            startActivity(intent)

        }
    }
}