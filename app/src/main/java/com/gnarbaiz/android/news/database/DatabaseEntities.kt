package com.gnarbaiz.android.news.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gnarbaiz.android.news.domain.Article
import com.gnarbaiz.android.news.domain.Source

@Entity
class DatabaseArticle(
    @PrimaryKey
    val url: String,
    @Embedded
    val source: DatabaseSource,
    val author: String?,
    val title: String,
    val description: String?,
    val imageUrl: String?,
    val publishedAt: Long,
    val content: String?
)

class DatabaseSource(
    val id: String?,
    val name: String
)

fun List<DatabaseArticle>.asDomainModel(): List<Article> {
    return map {
        Article(
            url = it.url,
            source = Source(
                id = it.source.id,
                name = it.source.name
            ),
            author = it.author,
            title = it.title,
            description = it.description,
            imageUrl = it.imageUrl,
            publishedAt = it.publishedAt,
            content = it.content
        )
    }
}