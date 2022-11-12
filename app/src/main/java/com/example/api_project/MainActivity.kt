package com.example.api_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api_project.databinding.ActivityMainBinding
import com.example.api_project.models.PostRestApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postApi = retrofit.create(PostRestApi::class.java)

        val repository = PostsRepository(postApi)
        val adapter = PostsListAdapter()
        binding.postListRecyclerView.adapter = adapter


        repository.getAll(){
            adapter.setPosts(repository.posts)
        }

    }
}

