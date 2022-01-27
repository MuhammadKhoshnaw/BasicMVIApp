package com.khoshnaw.entity

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
