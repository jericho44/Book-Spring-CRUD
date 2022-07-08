package com.rico.demospringrico.controller

import com.rico.demospringrico.entity.Book
import com.rico.demospringrico.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(value = ["/books"], produces = [MediaType.APPLICATION_JSON_VALUE])
class BookController @Autowired constructor(
    private val bookService: BookService
){
    @GetMapping
    fun getAllBooks(): ResponseEntity<List<Book>> {
        return ResponseEntity(bookService.getBooks(), HttpStatus.OK)
    }

    @PostMapping
    fun addNewBook(
        @RequestBody book: Book
    ): ResponseEntity<Book>{
        return ResponseEntity(bookService.addNewBook(book), HttpStatus.OK)
    }

    @PutMapping("{id}")
    fun updateBook(
        @PathVariable("id") id: Int,
        @RequestBody book: Book
    ): ResponseEntity<Book> {
        return ResponseEntity(bookService.updateBook(id,book), HttpStatus.OK)
    }

    @DeleteMapping("{id}")
    fun deleteBook(
        @PathVariable("id") id: Int
    ): ResponseEntity<Int> {
        return ResponseEntity(bookService.deleteBook(id), HttpStatus.OK)
    }

}