package com.ig.service

class UserController {

    def userService

    def index() {
        render userService.createUsers()
    }

    def notTran(){
        render userService.createUserWithNotTran()
    }

    def readOnly(){
        render "Read Only"
        userService.readyOnly()
    }

    def withTran(){
        render userService.withTran()
    }

    def notTranFromTran(){
        render userService.notTranFromTran()
    }

    def tranFromNotTran(){
        render userService.tranFromNotTran()
    }

}
