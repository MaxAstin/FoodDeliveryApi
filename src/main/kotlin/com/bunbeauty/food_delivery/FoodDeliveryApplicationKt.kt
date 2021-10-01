package com.bunbeauty.food_delivery


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodDeliveryApplicationKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<FoodDeliveryApplicationKt>(*args)

//            val client = HttpClient(Apache) {
//                install(WebSockets)
//            }
//            runBlocking {
//                client.webSocket(method = io.ktor.http.HttpMethod.Get, host = "127.0.0.1", port = 8080, path = "/topic/orders") {
//                    while(true) {
//                        val othersMessage = incoming.receive() as? Frame.Text
//                        println(othersMessage?.readText())
//                        val myMessage = Scanner(System.`in`).next()
//                        if(myMessage != null) {
//                            send(myMessage)
//                        }
//                    }
//                }
//            }
//            client.close()
        }
    }
}