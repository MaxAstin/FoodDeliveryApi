package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.Address
import com.bunbeauty.food_delivery.model.Cafe
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, String> {
    fun save(address: Address)
}