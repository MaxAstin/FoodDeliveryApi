package com.bunbeauty.food_delivery.model.local

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany


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

    val city: String,

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