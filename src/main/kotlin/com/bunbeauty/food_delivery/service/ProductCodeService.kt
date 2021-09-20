package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.ProductCodeClient
import com.bunbeauty.food_delivery.model.local.ProductCode
import com.bunbeauty.food_delivery.model.mapper.ProductCodeMapper
import com.bunbeauty.food_delivery.repository.ProductCodeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductCodeService {

    @Autowired
    lateinit var productCodeRepository: ProductCodeRepository

    @Autowired
    lateinit var productCodeMapper: ProductCodeMapper

    fun insert(productCode: ProductCodeClient): ProductCodeClient {
        if (productCode.uuid.isEmpty())
            productCode.uuid = UUID.randomUUID().toString()

        productCodeRepository.save(productCodeMapper.toEntityModel(productCode))
        return productCode
    }

    fun getAll(): List<ProductCodeClient> {
        return productCodeRepository.getAllBy().map { productCodeMapper.toClientModel(it) }
    }

    fun getByUuid(uuid: String): ProductCodeClient? {
        return productCodeMapper.toClientModel(
            productCodeRepository.getByUuid(uuid) ?: throw NotFoundWithUuid(
                ProductCode::class.simpleName!!
            )
        )
    }

}