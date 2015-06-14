package com.ig.service

import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class UserService {

    static transactional = false //It has no importance if we have used @Transactional annotation at class level

    List<User> createUsers() {
        List<User> userList = []

        (1..2).each {
            userList.add(new User(name: "Alok ${it}").save())
        }
        throw new RuntimeException("Runtime Exception")
        userList.add(new User(name:"Aman").save())
        return userList
    }


    @NotTransactional
    List<User> createUserWithNotTran() {
        List<User> userList = []

        (1..2).each {
            userList.add(new User(name: "Alok ${it}").save())
        }
        throw new RuntimeException("Runtime Exception")
        userList.add(new User(name:"Aman").save())
        return userList
    }

    @Transactional(readOnly = true)
    void readyOnly() {
        User user = new User(name:"Amit").save()
    }

}
