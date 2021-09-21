package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.Profile
import org.springframework.data.repository.CrudRepository

interface ProfileRepository : CrudRepository<Profile, String> {
    fun getByUuid(uuid: String): Profile?
    fun getBy(): List<Profile>
}