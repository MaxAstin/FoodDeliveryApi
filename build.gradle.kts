import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
    kotlin("plugin.jpa") version "1.5.30"
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

application {
    mainClass.set("com.bunbeauty.food_delivery.FoodDeliveryApplicationKt")
}

//val mainClassName = "FoodDeliveryApplicationKt"

//group = "com.example"
//version = "0.0.1-SNAPSHOT"
//java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
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
    //implementation("gradle.plugin.com.github.jengelman.gradle.plugins:shadow:7.0.0")

    runtimeOnly("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

//apply(plugin = "com.github.johnrengelman.shadow")

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

//tasks.withType<Jar> {
//    from(sourceSets.main.get().output)
//    dependsOn(configurations.runtimeClasspath)
//    manifest {
//        attributes["Main-Class"] = "com.bunbeauty.food_delivery.FoodDeliveryApplicationKt"
//    }
//    destinationDirectory.set(File(buildDir.path + "/libs"))
//}

//tasks.withType<Jar> {
//    manifest {
//        attributes["Main-Class"] = "com.bunbeauty.food_delivery.FoodDeliveryApplicationKt"
//    }
//}
//
//tasks.withType<ShadowJar> {
//    manifest {
//        attributes["Main-Class"] = "com.bunbeauty.food_delivery.FoodDeliveryApplicationKt"
//    }
//}

tasks {
    shadowJar {
        manifest {
            attributes["Main-Class"] = application.mainClass
        //"com.bunbeauty.food_delivery.FoodDeliveryApplicationKt"
        }
        //destinationDirectory.set(File(buildDir.path + "/libs"))
    }
//    jar {
//        manifest {
//            attributes["Main-Class"] = application.mainClass
//                //"com.bunbeauty.food_delivery.FoodDeliveryApplicationKt"
//        }
//    }
}
