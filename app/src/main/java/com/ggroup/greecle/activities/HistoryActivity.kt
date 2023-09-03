package com.ggroup.greecle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.ggroup.greecle.R

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val items = listOf("Today","Last week","Last Month")

        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this, R.layout.list_history_item,items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this,"$itemSelected",Toast.LENGTH_SHORT).show()
        }
    }
}