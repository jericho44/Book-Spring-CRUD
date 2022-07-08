package com.rico.demospringrico.service

import com.rico.demospringrico.entity.Book
import com.rico.demospringrico.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService @Autowired constructor(
    private val bookRepository: BookRepository
){
    fun getBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun addNewBook(book: Book): Book {
        return bookRepository.save(book)
    }

    fun updateBook(id: Int, book: Book): Book {
        val updatedBook = bookRepository.findById(id).get()
        updatedBook.title = book.title
        updatedBook.author = book.author
        updatedBook.isbn = book.isbn
        updatedBook.year = book.year

        return bookRepository.save(updatedBook)
    }

    fun deleteBook(id: Int): Int {
        val book = bookRepository.findById(id).orElse(null) ?: return id

        bookRepository.deleteById(id)
        return id
    }
}