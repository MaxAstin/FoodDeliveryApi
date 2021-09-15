package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.local.Profile
import com.bunbeauty.food_delivery.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfileService {
    @Autowired
    lateinit var profileRepository: ProfileRepository

    fun insert(profile: Profile): Profile {
        if (profile.uuid.isEmpty())
            profile.uuid = UUID.randomUUID().toString()
        profileRepository.save(profile)

        return profile
    }

    fun getProfileByUuid(uuid: String): Profile {
        return profileRepository.getByUuid(uuid) ?: throw Exception("No profile with this uuid")
    }
}