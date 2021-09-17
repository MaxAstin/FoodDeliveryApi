package com.bunbeauty.food_delivery.error

class NotFoundWithUuid(private val classException: String) : Exception() {

    override val message: String
        get() = "Not found $classException with this UUID"
}