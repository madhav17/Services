package com.ig.service

import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class BookService {


    def grailsApplication

    void createBook(Author author) {
        Book book = new Book(name: "New Book Via Service")
        author.addToBooks(book)
        author.save()
    }
}
