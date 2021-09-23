package com.bunbeauty.food_delivery.model.local

import com.bunbeauty.food_delivery.model.local.order.UserOrder
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


/**
 * Company information
 */
@Entity
data class Cafe(
    @Id
    var uuid: String,

    val fromTime: String,

    val toTime: String,

    val phone: String,

    val latitude: Double,

    val longitude: Double,

    val visible: Boolean,

    @ManyToOne
    @JoinColumn(name="city_uuid")
    var city: City,

    /**
     * don't give to client
     * resole on backend
     */
    @OneToMany(mappedBy = "cafe", cascade = [CascadeType.ALL])
    @JsonIgnore
    val streets: List<Street>,

    @OneToMany(mappedBy = "cafe", cascade = [CascadeType.ALL])
    @JsonIgnore
    val userOrderList : List<UserOrder>,

    val address: String,
)