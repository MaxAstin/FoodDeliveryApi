package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.ProfileClient
import com.bunbeauty.food_delivery.model.local.Profile
import com.bunbeauty.food_delivery.model.local.Street
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

    fun update(profileUuid: String, email: String): ProfileClient {
        if (profileUuid.isEmpty())
            throw Exception("Uuid was empty")

        val profile = profileRepository.getByUuid(profileUuid) ?: throw NotFoundWithUuid(Profile::class.simpleName!!)
        profile.email = email

        profileRepository.save(profile)

        return profileMapper.toClientModel(profile)
    }

    fun getProfileByUuid(uuid: String): ProfileClient {
        return profileMapper.toClientModel(
            profileRepository.getByUuid(uuid) ?: throw NotFoundWithUuid(Profile::class.simpleName!!)
        )
    }

    fun getAllProfiles(): List<ProfileClient> {
        return profileRepository.getBy().map { profileMapper.toClientModel(it) }
    }
}