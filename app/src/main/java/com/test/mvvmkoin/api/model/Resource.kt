package com.test.mvvmkoin.api.model

data class Resource<out T, E>(var status: Status, val data: T?, val dataError: E?) {

    companion object {
        fun <T, E> success(dataError: E?, data: T?): Resource<T, E>? {
            return Resource(Status.SUCCESS, data, dataError)
        }

        fun <T, E> error(dataError: E?, data: T?): Resource<T, E>? {
            return Resource(Status.ERROR, data, dataError)
        }

        fun <T, E> loading(dataError: E?, data: T?): Resource<T, E>? {
            return Resource(Status.LOADING, data, dataError)
        }

        fun <T, E> network(dataError: E?, data: T?): Resource<T, E>? {
            return Resource(Status.NETWORK, data, dataError)
        }

        fun <T, E> unauthorized(dataError: E?, data: T?): Resource<T, E>? {
            return Resource(Status.UNAUTHORIZED, data, dataError)
        }
    }
}