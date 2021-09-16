package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.AddressClient
import com.bunbeauty.food_delivery.model.local.Address
import com.bunbeauty.food_delivery.model.mapper.AddressMapper
import com.bunbeauty.food_delivery.repository.AddressRepository
import com.bunbeauty.food_delivery.repository.ProfileRepository
import com.bunbeauty.food_delivery.repository.StreetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressService {
    @Autowired
    lateinit var addressRepository: AddressRepository

    @Autowired
    lateinit var streetRepository: StreetRepository

    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Autowired
    lateinit var addressMapper: AddressMapper

    fun insert(address: AddressClient): AddressClient {
        if (address.uuid.isEmpty())
            address.uuid = UUID.randomUUID().toString()

        address.street = streetRepository.getByUuid(address.streetUuid)
            ?: throw Exception(getErrorMessage("street"))
        address.profile =
            profileRepository.getByUuid(address.profileUuid) ?: throw Exception(getErrorMessage("profile"))

        addressRepository.save(addressMapper.toEntityModel(address))

        return address
    }

    fun getErrorMessage(entity: String): String {
        return "Not found $entity with UUID"
    }
}