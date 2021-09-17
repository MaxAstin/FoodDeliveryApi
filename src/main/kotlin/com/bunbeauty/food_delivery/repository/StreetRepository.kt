package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.Street
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface StreetRepository : CrudRepository<Street, String> {
    fun getByUuid(uuid: String): Street?

    fun getBy(): List<Street>

    @org.springframework.data.jpa.repository.Query(
        value = "SELECT * FROM street WHERE street.cafe_uuid IN (SELECT cafe.uuid FROM cafe WHERE cafe.city_uuid = :cityUuid)",
        nativeQuery = true
    )
    fun getByCityUuid(@Param("cityUuid") uuid: String): List<Street>

}