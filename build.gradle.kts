import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("plugin.jpa") version "1.5.30"
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

//group = "com.example"
//version = "0.0.1-SNAPSHOT"
//java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

//val jar: Jar by tasks
//val installDist: Sync by tasks

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-noarg")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    runtimeOnly("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
//
//node {
//    download = true
//}
//
//tasks.withType<Test> {
//    useJUnitPlatform()
//}
//
//tasks.withType<Jar> {
//    manifest {
//        attributes["Main-Class"] = "com.bunbeauty.food_delivery.FoodDeliveryApplicationKt"
//    }
//}
//
//jar.manifest { attributes["Main-Class"] = "com.bunbeauty.food_delivery.FoodDeliveryApplicationKt" }
//
//task("stage") {
////    doFirst {
////        val command = file("${installDist.destinationDir}/bin/${project.name}").relativeTo(rootDir)
////
////        file("$rootDir/Procfile").writeText("web: RESTEASY_PORT=\$PORT $command")
////    }
//    dependsOn(installDist)
//}
