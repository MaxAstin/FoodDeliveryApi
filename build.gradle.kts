import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.jpa") version "1.5.30"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

application {
    mainClass.set("com.bunbeauty.food_delivery.FoodDeliveryApplicationKt")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.5.4")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-noarg")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.4")
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
    implementation("org.springframework:spring-websocket:5.3.10")
    implementation("org.springframework:spring-messaging:5.3.10")

    implementation("org.springframework.boot:spring-boot-starter-jdbc:2.5.4")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.4")
    runtimeOnly("org.postgresql:postgresql:42.2.23.jre7")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.jar {
    enabled = false
}