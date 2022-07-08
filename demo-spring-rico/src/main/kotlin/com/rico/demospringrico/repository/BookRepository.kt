package com.rico.demospringrico.repository

import com.rico.demospringrico.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Int> {
}