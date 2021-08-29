# News-Cache
A sample to showcase Kotlin, MVVM, Navigation, Coroutines, Room, WorkManager, Retrofit and DataBinding.

## Features
* MVVM Architecture + Repository design Pattern.
* Jetpack Libraries and Architecture Components.

## Prerequisites

Add your [News](https://newsapi.org/) api key in the `local.properties` file:
```
news_api_key=YOUR_NEWS_API_KEY
```

## Libraries
* [Android Jetpack](https://developer.android.com/jetpack)
   * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) ViewModel is designed to store and manage UI-related data in a lifecycle conscious way. This allows data to survive configuration changes such as screen rotations.
   * [DataBinding](https://developer.android.com/topic/libraries/data-binding/) is a Library in the support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
   * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) is lifecycle-aware, meaning it respects the lifecycle of other app components updating app component observers that are in an active lifecycle state.
   * [Navigation](https://developer.android.com/guide/navigation/) Android Jetpack's Navigation component helps you implement effective navigation.
   * [Room](https://developer.android.com/topic/libraries/architecture/room) is a library for data storage persistence which provides an abstraction layer over SQLite.
   * [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager/basics) allows you to schedule work to run one-time or repeatedly.
* [Picasso](https://github.com/square/picasso) is a powerful image downloading and caching library for Android.
* [Kotlin coroutines](https://developer.android.com/kotlin/coroutines) Executing code asynchronously.
* [Retrofit](https://square.github.io/retrofit/) is a Type-safe HTTP client for Android, Java and Kotlin by Square.
* [Moshi](https://github.com/square/moshi) is a modern JSON library for Android and Java. It makes it easy to parse JSON format data.
* [OkHttp interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) Logs HTTP requests and responses.
* [Material Design](https://material.io/develop/android/) Build beautiful, usable products using Material Components for Android.

