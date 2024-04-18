package com.todohub.mobile

import android.graphics.Paint
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isRadioChecked = false
    private lateinit var radioCheck: RadioButton
    private lateinit var titleTask: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontre as visualizações pelo ID
        radioCheck = findViewById(R.id.radioCheck)
        titleTask = findViewById(R.id.titleTask)

        // Adicione um ouvinte de clique ao botão de rádio
        radioCheck.setOnClickListener {
            // Inverte o estado do isRadioChecked
            isRadioChecked = !isRadioChecked
            updateTitle("Title Task")
        }

        // Atualize o título inicialmente
        updateTitle("Title Task")
    }

    private fun updateTitle(title: String) {
        // Atualize o texto do título com base na variável isRadioChecked
        val isCheckedTask = if (isRadioChecked) title else title
        titleTask.text = isCheckedTask

        // Adicione uma linha atravessando o texto se o botão de rádio estiver selecionado
        if (isRadioChecked) {
            titleTask.paintFlags = titleTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            titleTask.paintFlags = titleTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
