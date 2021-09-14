package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.UserOrder
import org.springframework.data.repository.CrudRepository

interface UserOrderRepository : CrudRepository<UserOrder, String>