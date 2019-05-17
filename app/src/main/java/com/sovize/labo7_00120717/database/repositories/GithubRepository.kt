package com.sovize.labo7_00120717.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.sovize.labo7_00120717.database.daos.GithubRepoDao
import com.sovize.labo7_00120717.database.entities.GithubRepo

//Capa repositorio
class GithubRepository(private val repoDao: GithubRepoDao){

    //llamando al metodo getAll de repoDao que ya esta conectado a la DB
    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAll()

    fun delete() = repoDao.deleteTable()

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }
}