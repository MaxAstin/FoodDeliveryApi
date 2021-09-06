package com.bunbeauty.food_delivery.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class DatabaseConfig {

    @Value("\${spring.datasource.url}")
    private lateinit var datasourceUrl: String

    @Value("\${spring.datasource.driver-class-name}")
    private lateinit var dbDriverClassName: String

    @Value("\${spring.datasource.username}")
    private lateinit var dbUsername: String

    @Value("\${spring.datasource.password}")
    private lateinit var dbPassword: String


    @Bean
    fun dataSource(): DataSource {
        println(
            "datasourceUrl $datasourceUrl\n" +
                    "dbDriverClassName $dbDriverClassName\n" +
                    "dbUsername $dbUsername\n" +
                    "dbPassword $dbPassword"
        )

        return DriverManagerDataSource().apply {
            setDriverClassName(dbDriverClassName)
            url = datasourceUrl
            username = dbUsername
            password = dbPassword
        }
    }
}
