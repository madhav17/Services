package com.ig.service

import java.sql.SQLException


class AuthorService {

    def bookService
    static transactional = true

    Author createAuthor() {
        new Author(name: "New Author Via Service", age: 77, address: "Manak Vihar").save()
    }

    void nonRuntimeException() {
        new Author(name: "Author x", age: 67, address: "Anand Vihar").save()
        new Author(name: "Author x", age: 67, address: "Anand Vihar").save()
        throw new SQLException("SQL Exception")
        new Author(name: "Author x", age: 67, address: "Anand Vihar").save()
    }

    void runtimeException() {
        new Author(name: "Author x", age: 67, address: "Anand Vihar").save()
        new Author(name: "Author x", age: 67, address: "Anand Vihar").save()
//        throw new RuntimeException("Runtime Exception")
//        10/0
        new Author(name: "Author x", age: 67, address: "Anand Vihar").save()
    }

}
