package com.todohub.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.todohub.mobile.databinding.ActivityChatTaskBinding

class ChatTaskActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityChatTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatTaskBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_chat_task)

    }
}