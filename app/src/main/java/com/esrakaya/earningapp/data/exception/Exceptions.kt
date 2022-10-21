package com.esrakaya.earningapp.data.exception

sealed class Exceptions : Exception() {

    object CommonException : Exceptions()

    data class HttpException(
        val errorMessage: String
    ) : Exceptions()
}