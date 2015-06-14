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

    @NotTransactional
    List<User> withTran(){

        List<User> userList = []
        (1..2).each {
            userList.add(new User(name: "Aarav ${it}").save())
        }

        User.withTransaction {
            (3..6).each {
                userList.add(new User(name: "Aarav ${it}").save())
            }
//            throw new RuntimeException("Runtime Exception Inside With Transaction")
        }
//        throw new RuntimeException("Runtime Exception")
        return userList
    }



    List<User> notTranFromTran(){
        List<User> userList = []
        (1..2).each {
            userList.add(new User(name: "Imran ${it}").save())
        }
//        throw new RuntimeException("Runtime Exception From Transactional Before Method Calling")
        userList.add(intializeUsers())
//        throw new RuntimeException("Runtime Exception From Transactional Before Method After")
        return userList.flatten()
    }

    @NotTransactional
    List<User> intializeUsers(){
        List<User> userList = []
        (3..6).each {
            userList.add(new User(name: "Aarav ${it}").save())
        }
//        throw new RuntimeException("Runtime Exception From Non Transactional")
        return userList
    }

}
