package com.project.listviewexamplewithviewbinding

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.listviewexamplewithviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : ListviewAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<Model>()
        var contact = Model("Add ","00000","https://picsum.photos/200")
        for(i: Int in 1..10)
            list.add(contact)
        adapter = ListviewAdapter(list)
        binding.listview.adapter = adapter
    }
}