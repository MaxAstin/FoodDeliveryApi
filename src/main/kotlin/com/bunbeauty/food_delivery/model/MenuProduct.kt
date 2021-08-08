package com.bunbeauty.food_delivery.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MenuProduct(
        @Id
        val uuid: String,
        val name: String,
        val cost: Int,
        val discountCost: Int?,
        val weight: Int?,
        val description: String,
        val comboDescription: String?,
        val photoLink: String,
        val productCode: String,
        val barcode: Int?,
        val visible: Boolean
)