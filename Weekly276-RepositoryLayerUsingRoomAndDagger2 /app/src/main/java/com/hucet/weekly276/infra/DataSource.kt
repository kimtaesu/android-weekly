package com.hucet.weekly276.infra

/**
 * Created by tyler on 2017. 10. 1..
 */
interface DataSource<T> {
    fun addItem(item: T)
//    fun addItems(items: List<T>)
//    fun updateItem(item: T)
//    fun updateItems(items: List<T>)
    fun removeItem(item: T)
//    fun hasData(): Boolean
}