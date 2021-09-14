package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.Cafe
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface CafeRepository : CrudRepository<Cafe, String> {
    fun getAllBy(): List<Cafe>

    fun getAllByCity(city: String): List<Cafe>

    fun getByUuid(uuid: String): Cafe?

    @org.springframework.data.jpa.repository.Query(value = "SELECT *\n" +
            "FROM cafe\n" +
            "WHERE cafe.uuid = (SELECT street.cafe_uuid FROM street WHERE street.uuid =\n" +
            "(SELECT street_uuid FROM address where address.uuid = :addressUuid))", nativeQuery = true)
    fun findByAddressUuid(@Param("addressUuid") uuid: String): Cafe?
}