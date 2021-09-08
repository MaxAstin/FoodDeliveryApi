package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.Profile
import org.springframework.data.repository.CrudRepository

interface ProfileRepository : CrudRepository<Profile, String> {
    fun save(profile: Profile)

    fun getByUuid(uuid:String): Profile?
}