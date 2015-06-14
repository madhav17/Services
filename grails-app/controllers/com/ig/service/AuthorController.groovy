package com.ig.service

class AuthorController {

    def authorService
    BookService bookService

    def index() {

        render authorService.getClass()
        render "<br/>"
        render bookService.getClass()
        render "<br/>"
        Author author = authorService.createAuthor()
        render author
        render "<br/>"
        bookService.createBook(author)
        render author.books
        render "<br/>"

    }

    def nonRuntimeException(){
        authorService.nonRuntimeException()
    }

    def runtimeException(){
        authorService.runtimeException()
    }


    def notTran(){
        Author author = authorService.notTranEx()
        render author
    }
}
