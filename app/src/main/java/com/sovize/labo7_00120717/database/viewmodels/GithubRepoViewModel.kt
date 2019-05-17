package com.sovize.labo7_00120717.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sovize.labo7_00120717.database.RoomDB
import com.sovize.labo7_00120717.database.entities.GithubRepo
import com.sovize.labo7_00120717.database.repositories.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app){
    //Comunicar a la capa de repository
    private val repository:GithubRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDAO()
        repository= GithubRepository(repoDao)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }
}