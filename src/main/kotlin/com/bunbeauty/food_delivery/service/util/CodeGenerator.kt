package com.bunbeauty.food_delivery.service.util

import com.bunbeauty.food_delivery.service.Constants.CODE_DIVIDER
import com.bunbeauty.food_delivery.service.Constants.CODE_NUMBER_COUNT
import org.springframework.stereotype.Service


@Service
class CodeGenerator{

    fun generateCode(currentMillis: Long, letters: String): String {
        val currentSeconds = currentMillis / 1000

        val number = (currentSeconds % (letters.length * CODE_NUMBER_COUNT)).toInt()
        val codeLetter = letters[number % letters.length].toString()
        val codeNumber = (number / letters.length)
        val codeNumberString = if (codeNumber < 10) {
            "0$codeNumber"
        } else {
            codeNumber.toString()
        }

        return codeLetter + CODE_DIVIDER + codeNumberString
    }
}