package com.example.api_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_project.databinding.PostListItemBinding
import com.example.api_project.models.PostResponse


class PostsListAdapter(): RecyclerView.Adapter<PostsListAdapter.ViewHolder>() {

    private var posts: List<PostResponse> = mutableListOf()

    fun setPosts(list: List<PostResponse>?){
        if (list != null){
            posts = list
            notifyDataSetChanged()
        }
    }



    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = PostListItemBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.post = posts[position]
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}