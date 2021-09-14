package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.Address
import com.bunbeauty.food_delivery.model.Cafe
import org.springframework.data.repository.CrudRepository
import java.util.*

interface AddressRepository : CrudRepository<Address, String> {
    fun save(address: Address)
    fun getByUuid(uuid: String): Address?
}