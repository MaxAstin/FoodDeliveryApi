package com.bunbeauty.food_delivery.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Street(
    @Id
    val uuid: String,

    val name: String,

    @ManyToOne
    @JoinColumn(name="cafe_uuid")
    @JsonIgnore
    val cafe: Cafe?,

    @OneToMany(mappedBy = "street", cascade = [CascadeType.ALL])
    val addressList: List<Address>
)