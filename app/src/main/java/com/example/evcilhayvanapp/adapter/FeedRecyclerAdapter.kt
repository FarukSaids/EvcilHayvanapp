package com.example.evcilhayvanapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evcilhayvanapp.databinding.RecyclerRowBinding
import com.example.evcilhayvanapp.model.Post
import com.squareup.picasso.Picasso

class FeedRecyclerAdapter(private val postList :ArrayList<Post>): RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder>(){
   inner class PostHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)
    }

    override fun getItemCount(): Int {
            return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
       holder.binding.recyclerEmailtext.text = postList.get(position).email
        holder.binding.recyclerCommentText.text = postList.get(position).comment
        Picasso.get().load(postList.get(position).downloadurl).into(holder.binding.recyclerImageView)

    }

}