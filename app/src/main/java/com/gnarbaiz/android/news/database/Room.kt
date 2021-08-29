package com.gnarbaiz.android.news.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NewsDao {
    @Query("SELECT * FROM databasearticle ORDER BY publishedAt DESC")
    fun getArticles(): LiveData<List<DatabaseArticle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos: DatabaseArticle)
}

@Database(entities = [DatabaseArticle::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao: NewsDao
}

private lateinit var INSTANCE: NewsDatabase

fun getDatabase(context: Context): NewsDatabase {
    synchronized(NewsDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "articles"
            ).build()
        }
    }
    return INSTANCE
}
