package com.bunbeauty.food_delivery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodDeliveryApplicationKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<FoodDeliveryApplicationKt>(*args)
        }
    }
}