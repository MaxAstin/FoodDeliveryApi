package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.address.AddressClient
import com.bunbeauty.food_delivery.model.client.address.PostAddressClient
import com.bunbeauty.food_delivery.model.local.Address
import com.bunbeauty.food_delivery.model.local.Profile
import com.bunbeauty.food_delivery.model.local.Street
import com.bunbeauty.food_delivery.repository.ProfileRepository
import com.bunbeauty.food_delivery.repository.StreetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressMapper {

    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Autowired
    lateinit var streetRepository: StreetRepository

    @Autowired
    lateinit var streetMapper: StreetMapper

    fun toEntityModel(address: PostAddressClient): Address {
        return Address(
            uuid = address.uuid,
            street = streetRepository.getByUuid(address.streetUuid)
                ?: throw NotFoundWithUuid(Street::class.simpleName!!),
            house = address.house,
            flat = address.flat,
            entrance = address.entrance,
            comment = address.comment,
            floor = address.floor,
            profile = profileRepository.getByUuid(address.profileUuid)
                ?: throw NotFoundWithUuid(Profile::class.simpleName!!),
        )
    }

    fun toClientModel(address: Address): AddressClient {
        return AddressClient(
            uuid = address.uuid,
            street = streetMapper.toClientModel(address.street),
            streetUuid = address.street.uuid,
            house = address.house,
            flat = address.flat,
            entrance = address.entrance,
            comment = address.comment,
            floor = address.floor,
            profileUuid = address.profile.uuid
        )
    }

}