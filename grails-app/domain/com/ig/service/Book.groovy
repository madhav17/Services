package com.ig.service

class Book {

    String name

    static belongsTo = [author: Author]

    static constraints = {
    }
}
