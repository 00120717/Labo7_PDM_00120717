package com.sovize.labo7_00120717

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sovize.labo7_00120717.adapters.ReposAdapter
import com.sovize.labo7_00120717.database.entities.GithubRepo
import com.sovize.labo7_00120717.database.viewmodels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ReposAdapter
    lateinit var viewModel: GithubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bind(){
        adapter= ReposAdapter(ArrayList())
        viewModel=ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        rv_repos.apply{
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
        btn_add.setOnClickListener {
            viewModel.insert(GithubRepo(et_repo_name.text.toString()))
        }
    }
}
