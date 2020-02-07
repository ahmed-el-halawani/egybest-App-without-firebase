package com.example.howtospeedtherecyclerview.model

class Movie {
    var title: String? = null
    var desc: String? = null
    var image: Int? = null
    var poster: Int? = null
    var movieSection: String? = null

    constructor(title: String, image: Int, movieSection: String) {
        this.title = title
        this.image = image
        this.movieSection = movieSection
    }
}