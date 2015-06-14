package com.ig.service

import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class BookService {

    //def authorService // It will result is circular dependency so therefore we need to inject in dynamically.

    def grailsApplication

    def getAuthorService(){
        grailsApplication.mainContext.getBean("authorService")
    }
    void createBook(Author author) {
        Book book = new Book(name: "New Book Via Service")
        author.addToBooks(book)
        author.save()
    }
}
