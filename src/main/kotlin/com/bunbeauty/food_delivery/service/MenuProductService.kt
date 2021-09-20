package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.MenuProductClient
import com.bunbeauty.food_delivery.model.local.ProductCode
import com.bunbeauty.food_delivery.model.mapper.MenuProductMapper
import com.bunbeauty.food_delivery.model.mapper.ProductCodeMapper
import com.bunbeauty.food_delivery.repository.MenuProductRepository
import com.bunbeauty.food_delivery.repository.ProductCodeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MenuProductService {

    @Autowired
    lateinit var menuProductRepository: MenuProductRepository

    @Autowired
    lateinit var productCodeRepository: ProductCodeRepository

    @Autowired
    lateinit var productCodeMapper: ProductCodeMapper

    @Autowired
    lateinit var menuProductMapper: MenuProductMapper

    fun insert(menuProduct: MenuProductClient): MenuProductClient {

        if (menuProduct.uuid.isEmpty())
            menuProduct.uuid = UUID.randomUUID().toString()

        val productCodes = mutableListOf<ProductCode>()
        menuProduct.productCodeUuids?.forEach {
            productCodes.add(
                productCodeRepository.getByUuid(it) ?: throw NotFoundWithUuid(
                    ProductCode::class.simpleName!!
                )
            )
        }

        menuProduct.productCodes = productCodes.map(productCodeMapper::toClientModel).toSet()

        menuProductRepository.save(menuProductMapper.toEntityModel(menuProduct))
        return menuProduct
    }

    fun getMenuProducts(): List<MenuProductClient> =
        menuProductRepository.getAllBy().map(menuProductMapper::toClientModel)
}