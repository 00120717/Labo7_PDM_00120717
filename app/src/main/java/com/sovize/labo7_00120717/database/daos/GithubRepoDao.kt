package com.sovize.labo7_00120717.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sovize.labo7_00120717.database.entities.GithubRepo

//operaciones a realizar con la entidad
@Dao
interface GithubRepoDao{

    @Query("SELECT * FROM repos")
    fun getAll():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)

    @Query("DELETE FROM repos")
    fun deleteTable()
}