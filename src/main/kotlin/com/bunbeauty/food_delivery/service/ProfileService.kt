package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.ProfileClient
import com.bunbeauty.food_delivery.model.mapper.ProfileMapper
import com.bunbeauty.food_delivery.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfileService {
    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Autowired
    lateinit var profileMapper: ProfileMapper

    fun insert(profile: ProfileClient): ProfileClient {
        if (profile.uuid.isEmpty())
            profile.uuid = UUID.randomUUID().toString()

        profileRepository.save(profileMapper.toEntityModel(profile))

        return profile
    }

    fun update(profile: ProfileClient): ProfileClient {
        if (profile.uuid.isEmpty())
            throw Exception("Uuid was empty")

        if (profileRepository.getByUuid(profile.uuid) == null)
            throw Exception("No profile with this uuid")

        profileRepository.save(profileMapper.toEntityModel(profile))

        return profile
    }

    fun getProfileByUuid(uuid: String): ProfileClient {
        return profileMapper.toClientModel(
            profileRepository.getByUuid(uuid) ?: throw Exception("No profile with this uuid")
        )
    }
}