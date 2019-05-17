package com.sovize.labo7_00120717.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sovize.labo7_00120717.database.daos.GithubRepoDao
import com.sovize.labo7_00120717.database.entities.GithubRepo

@Database(entities = [GithubRepo::class],version = 1,exportSchema = false)
public abstract class RoomDB:RoomDatabase(){
    abstract fun repoDAO():GithubRepoDao

    //creacion DB y vinculacion Entity
    companion object {
        @Volatile
        private var INSTANCE:RoomDB?=null

        fun getInstance(
            context:Context
        ):RoomDB{
            val tempInstnace = INSTANCE
            if (tempInstnace!=null){
                return tempInstnace
            }
            synchronized(this){
                val instance = Room
                    .databaseBuilder(context,RoomDB::class.java,"Repo_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}