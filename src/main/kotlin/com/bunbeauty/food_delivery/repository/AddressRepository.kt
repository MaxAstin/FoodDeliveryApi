package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, String> {
    fun getByUuid(uuid: String): Address?
    fun getAllBy(): List<Address>
}