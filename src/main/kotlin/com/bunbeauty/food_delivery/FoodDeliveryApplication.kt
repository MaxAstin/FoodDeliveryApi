package com.bunbeauty.food_delivery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodDeliveryApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<FoodDeliveryApplication>(*args)
        }
    }
}

/*
fun main(args: Array<String>) {
    runApplication<FoodDeliveryApplication>(*args)
}*/
