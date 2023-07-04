package com.example.evcilhayvanapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import android.widget.SearchView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evcilhayvanapp.*
import java.util.*
import kotlin.collections.ArrayList

class animalsdetails : AppCompatActivity() {
    private lateinit var recycleRView : RecyclerView
    private var mlist = ArrayList<animalsdata>()
    private lateinit var adapter :AnimalsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animalsdetails)
        recycleRView = findViewById(R.id.recyclerViewdetail)
        val searchView = findViewById<SearchView>(R.id.searchView)
        recycleRView.setHasFixedSize(true)
        recycleRView.layoutManager = LinearLayoutManager(this@animalsdetails)
        adapter = AnimalsAdapter(mlist)
        recycleRView.adapter = adapter
        addDataToList()

        adapter.onItemClick = {
            val intent = Intent(this,DetailedActivity::class.java)
            intent.putExtra("animals",it)
            startActivity(intent)
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }
        private fun filterList(query :String?){
            if(query != null){
                val filteredList = ArrayList<animalsdata>()
                for(i in mlist){
                    if(i.title?.lowercase(Locale.ROOT)!!.contains(query)){
                        filteredList.add(i)
                    }
                }
               if(filteredList.isEmpty()){
                   Toast.makeText(this,"no data found",Toast.LENGTH_SHORT).show()
               }else{
                   adapter.setFilteredList(filteredList)
               }
            }
        }
    private fun addDataToList(){

        val animalList = AnimalDataGenerator.generateData()
        mlist.addAll(animalList)
    }

}
