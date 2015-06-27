package com.ig.service

class Author {

    String name
    String address
    Integer age

    static hasMany = [books: Book]

    static constraints = {
        books(nullable: true, blank: true)
    }
}
