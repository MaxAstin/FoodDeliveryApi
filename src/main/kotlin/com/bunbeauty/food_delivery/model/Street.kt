package com.bunbeauty.food_delivery.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Street(
    @Id
    val uuid: String,

    val name: String,

    @ManyToOne
    @JoinColumn(name="district_uuid")
    @JsonIgnore
    val district: District?,

    @OneToMany(mappedBy = "street")
    val addressList: List<Address>
)