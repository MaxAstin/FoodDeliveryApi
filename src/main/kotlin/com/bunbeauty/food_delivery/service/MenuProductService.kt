package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.MenuProductClient
import com.bunbeauty.food_delivery.model.local.MenuProduct
import com.bunbeauty.food_delivery.model.mapper.MenuProductMapper
import com.bunbeauty.food_delivery.repository.MenuProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MenuProductService {

    @Autowired
    lateinit var menuProductRepository: MenuProductRepository

    @Autowired
    lateinit var menuProductMapper: MenuProductMapper

    fun insert(menuProduct: MenuProductClient): MenuProductClient {

        if (menuProduct.uuid.isEmpty())
            menuProduct.uuid = UUID.randomUUID().toString()

        menuProductRepository.save(menuProductMapper.toEntityModel(menuProduct))
        return menuProduct
    }

    fun getMenuProducts(): List<MenuProduct> = menuProductRepository.getAllBy()

}