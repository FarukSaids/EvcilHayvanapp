package com.example.evcilhayvanapp.view

import android.content.AbstractThreadedSyncAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evcilhayvanapp.R
import com.example.evcilhayvanapp.adapter.FeedRecyclerAdapter
import com.example.evcilhayvanapp.alarmActivity
import com.example.evcilhayvanapp.databinding.ActivityFeedBinding

import com.example.evcilhayvanapp.model.Post
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FeedActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFeedBinding
    private lateinit var auth :FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var postArraylist: ArrayList<Post>
    private lateinit var feedAdapter: FeedRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        auth =Firebase.auth
        db=Firebase.firestore
        postArraylist=ArrayList<Post>()
        getData()
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        feedAdapter= FeedRecyclerAdapter(postArraylist)
        binding.recyclerView.adapter=feedAdapter

    }
    private fun getData(){
        db.collection("Posts").orderBy("date",Query.Direction.DESCENDING).addSnapshotListener { value, error ->
            if(error != null){
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }else{
                if(value != null){
                    if(!value.isEmpty){
                        val documents = value.documents
                        postArraylist.clear()
                        for(document in documents){
                            val comment  =document.get("comment") as String

                            val userEmail  = document.get("userEmail") as String
                            val downloadUrl   = document.get("downloadUrl") as String
                             println(comment)
                            println(userEmail)

                           val post=Post(userEmail,comment,downloadUrl)
                            postArraylist.add(post)
                        }
                           feedAdapter.notifyDataSetChanged()
                    }

                }

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu1,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_post){
            val intent = Intent(this , UploadActivity::class.java)
            startActivity(intent)
        }
        if(item.itemId ==R.id.signout){
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        if(item.itemId==R.id.hayvanbilgileri){
            val intent = Intent(this,animalsdetails::class.java)
            startActivity(intent)

        }
        if(item.itemId==R.id.hatırlatıcı){
            val intent = Intent(this,alarmActivity::class.java)
            startActivity(intent)}


        return super.onOptionsItemSelected(item)
    }



}