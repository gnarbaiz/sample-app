package com.gnarbaiz.android.news.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.gnarbaiz.android.news.repository.ArticlesRepository
import com.gnarbaiz.android.news.database.getDatabase
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters):
        CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    /**
     * A coroutine-friendly method to do your work.
     */
    override suspend fun doWork(): Result {
        val database = getDatabase(applicationContext)
        val repository =
            ArticlesRepository(database)
        return try {
            repository.refreshArticles()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}
