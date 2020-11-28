package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput = findViewById<EditText>(R.id.text_input)

        val textChangingBtn = findViewById<Button>(R.id.text_changing_btn)
        textChangingBtn.setOnClickListener {
            textChangingBtn.text = textInput.text
        }
    }
}