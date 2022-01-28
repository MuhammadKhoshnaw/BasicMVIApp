
# Motivation

When starting a new project it is always difficult to build the setup environment. Building the application architecture and choosing the desired architecture pattern (MVI, MVVM or MVP) can be challenging. I always Liked to have a template that I can use whenever I need it. In addition, when using this template in a large application you discover the pros and cons of your template structure. And you can always come back to the template and improve it for the next project.
This Repository Will be my first android application template. In this template clean architecture and MVI architecture pattern is my weapon of choice.

# Application

For this template we don't need to go crazy with features. We just need enough to understand the architecture and have some basic configurations that we can reuse In future. The application is a basic movie app. That uses [TMDB API](https://www.themoviedb.org/documentation/api) to cash a list of popular movies. And then show it to the user. With the ability to refresh the cache when the user needed it.

# Architecture

## Introduction

Starting the development of software without a clear architecture will cause a disaster. The same way that starting construction of a building without a clear architecture will cause a disaster. It is true that without an architecture you can go really fast for the first few features in the app but does that really matter!
If you are not able to do any major changes in the software after a year. Logging with google took one week to implement but after one year of development logging in with Facebook took a month or two and even then it was really buggy. If you are too scared to do anything in the software after a few years. Does building the first few features fast really matter?

> “The only way to go fast, is to go well.” 
> ― Robert C. Martin, Clean Architecture

## Clean Architecture

There are multiple common architectures that you can use for your software. But I think clean architecture is the most commonly used architecture in the android development community. So I choose to use clean architecture for this template.
While studying Clean architecture I read multiple articles about implementing clean architecture in android. I also checked a few GitHub repositories but most of them didn’t have what I wanted. I believe most of them are the wrong implementation of clean architecture and the implementation violated the architecture principles. So for this template, I will depend on this article by [Robert C. Martin](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

![Architecture](.github/res/Architecture.svg)

As shown in the above diagram the template consists of 4 architecture layers. Be careful that those layers are architecture layers AND YOU DON’T HAVE TO CREATE A MODULE FOR EACH LAYER. Software components (modules) are different from architecture layers. You can have as many software components as you need in each architecture layer. In android, we create software components by modules. So for example we can separate our entities into two different modules or even more. The same thing applies to use cases and other layers.

![ComponentDiagram](.github/res/ComponentDiagram.svg)

For this template, nine different software components have been used as shown in the diagram.

1. In the innermost layer, we have an entity which is a java module.
2. Then In the second layer, we have useCase another java module.
3. For the third layer, we have three modules: controller and gateway are java modules. But ViewModel is an android module with a minimum dependency on the android platform as possible.
4. And in the outermost layer, We have 4 heavily dependent on the android framework modules. The application is our actual application module. UI, Remote and DB which are also android modules.

Of Course, you can have more layers but I don’t think having fewer layers will be a good idea. For this template, we are trying to have the most basic implementation possible so we go with 4 layers.


## Entity

In our entity, we have our [Movie](entity/src/main/java/com/khoshnaw/entity/Movie.kt) Class which have some movie properties.

```
data class Movie(  
	val id: String,
	val posterPath: String,
	val title: String,
	val voteAverage: Double,  
)
```

## TestFixtures

In this module, we also have some test fixtures. [MovieDummies](entity/src/testFixtures/java/com/khoshnaw/entity/MovieDummies.kt) have some dummy movie objects that we will need in our tests.

```
@Suppress("unused", "MemberVisibilityCanBePrivate")
object MovieDummies {

    val dummyMovie = Movie(
        id = "0",
        posterPath = "/b6qUu00iIIkXX13szFy7d0CyNcg.jpg",
        title = "Eternals",
        voteAverage = 7.3
    )

    val dummyMovie1 = Movie(
        id = "1",
        posterPath = "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
        title = "Sing 2",
        voteAverage = 8.3
    )

    val dummyMovie2 = Movie(
        id = "2",
        posterPath = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
        title = "Spider-Man: No Way Home",
        voteAverage = 8.4
    )

    val dummyMovie3 = Movie(
        id = "3",
        posterPath = "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
        title = "Ghostbusters: Afterlife",
        voteAverage = 7.6
    )

    val dummyMovie4 = Movie(
        id = "4",
        posterPath = "/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
        title = "Encanto",
        voteAverage = 7.8
    )

    val dummyMovie5 = Movie(
        id = "5",
        posterPath = "/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg",
        title = "Resident Evil: Welcome to Raccoon City",
        voteAverage = 6.1
    )

    val dummyMovieList = listOf(
        dummyMovie,
        dummyMovie1,
        dummyMovie2,
        dummyMovie3,
        dummyMovie4,
        dummyMovie5,
    )
}
```
