package com.bunbeauty.food_delivery.model

data class ListWrapper<T : Any>(
    val count: Int,
    val results: List<T>
)

fun <T : Any> List<T>.toListWrapper(): ListWrapper<T> {
    return ListWrapper(this.size, this)
}