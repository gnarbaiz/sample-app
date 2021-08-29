package com.gnarbaiz.android.news.network

import com.gnarbaiz.android.news.database.DatabaseArticle
import com.gnarbaiz.android.news.database.DatabaseSource
import com.gnarbaiz.android.news.util.DateTimeParser
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NetworkArticleContainer(
    val articles: List<NetworkArticle>
)

@JsonClass(generateAdapter = true)
class NetworkArticle(
    val source: NetworkSource,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    @Json(name = "urlToImage")
    val imageUrl: String?,
    val publishedAt: String,
    val content: String?
)

@JsonClass(generateAdapter = true)
class NetworkSource(
    val id: String?,
    val name: String
)

private val dateTimeParser = DateTimeParser

fun NetworkArticleContainer.asDatabaseModel(): Array<DatabaseArticle> {
    return articles.map {
        DatabaseArticle(
            url = it.url,
            source = DatabaseSource(
                id = it.source.id,
                name = it.source.name
            ),
            author = it.author,
            title = it.title,
            description = it.description,
            imageUrl = it.imageUrl,
            publishedAt = dateTimeParser.toMillis(it.publishedAt),
            content = it.content
        )
    }.toTypedArray()
}