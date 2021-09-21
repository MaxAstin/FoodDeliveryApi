package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.profile.ProfileClient
import com.bunbeauty.food_delivery.model.local.Profile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileMapper {

    @Autowired
    lateinit var addressMapper: AddressMapper

    @Autowired
    lateinit var userOrderMapper: UserOrderMapper

    fun toEntityModel(profile: ProfileClient): Profile {
        return Profile(
            uuid = profile.uuid,
            phone = profile.phone,
            email = profile.email,
            addressList = profile.addressList?.map { addressMapper.toEntityModel(it) } ?: emptyList(),
            userOrderList = profile.userOrderList?.map { userOrderMapper.toEntityModel(it) } ?: emptyList(),
        )
    }

    fun toClientModel(profile: Profile): ProfileClient {
        return ProfileClient(
            uuid = profile.uuid,
            phone = profile.phone,
            email = profile.email,
            addressList = profile.addressList.map { addressMapper.toClientModel(it) },
            userOrderList = profile.userOrderList.map { userOrderMapper.toClientModel(it) },
        )
    }

}