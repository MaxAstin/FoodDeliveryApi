package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.address.AddressClient
import com.bunbeauty.food_delivery.model.client.address.PostAddressClient
import com.bunbeauty.food_delivery.model.mapper.AddressMapper
import com.bunbeauty.food_delivery.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressService {
    @Autowired
    lateinit var addressRepository: AddressRepository

    @Autowired
    lateinit var addressMapper: AddressMapper


    fun insert(address: PostAddressClient): AddressClient {
        if (address.uuid.isEmpty())
            address.uuid = UUID.randomUUID().toString()

        return addressMapper.toClientModel(
            addressRepository.save(
                addressMapper.toEntityModel(address)
            )
        )
    }


    fun getAll() :List<AddressClient>{
        return addressRepository.getAllBy().map(addressMapper::toClientModel)
    }
}