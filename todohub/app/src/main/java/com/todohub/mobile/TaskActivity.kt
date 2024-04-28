package com.todohub.mobile

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TaskActivity : AppCompatActivity() {

    private var isRadioChecked = false
    private lateinit var radioCheck: RadioButton
    private lateinit var titleTask: TextView
    private lateinit var btnChat: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        radioCheck = findViewById(R.id.radioCheck)
        titleTask = findViewById(R.id.titleTask)
        btnChat = findViewById(R.id.btnChat)

        radioCheck.setOnClickListener {
            isRadioChecked = !isRadioChecked
            updateTitle("Title Task")
        }

        btnChat.setOnClickListener {
            val intent = Intent(this, ChatTaskActivity::class.java)
            startActivity(intent)
        }

        updateTitle("Title Task")
    }

    private fun updateTitle(title: String) {
        val isCheckedTask = if (isRadioChecked) title else title
        titleTask.text = isCheckedTask

        if (isRadioChecked) {
            titleTask.paintFlags = titleTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            titleTask.paintFlags = titleTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
