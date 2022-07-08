package com.rico.demospringrico.entity

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "title")
    var title: String? = null,

    @Column(name = "isbn")
    var isbn: String? = null,

    @Column(name = "author")
    var author: String? = null,

    @Column(name = "published")
    var year: String? = null
)