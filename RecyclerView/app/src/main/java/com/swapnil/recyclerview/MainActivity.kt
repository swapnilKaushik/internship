package com.swapnil.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var itemRecyclerAdapter: ItemRecyclerAdaptor
    lateinit var layoutManager: LinearLayoutManager

    val itemList: List<String> = listOf<String>("Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8", "Item9", "Item10", "Item11")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)

        itemRecyclerAdapter = ItemRecyclerAdaptor(this, itemList)
        recyclerView.adapter = itemRecyclerAdapter
        recyclerView.layoutManager = layoutManager

    }
}