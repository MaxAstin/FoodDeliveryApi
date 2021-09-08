package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.Profile
import com.bunbeauty.food_delivery.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/profile")
class ProfileController {

    @Autowired
    lateinit var profileService: ProfileService

    @PostMapping
    fun postProfile(@RequestBody profile: Profile): Profile {
        return profileService.insert(profile)
    }

    @GetMapping
    fun getProfileByUuid(@RequestParam uuid: String): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(profileService.getProfileByUuid(uuid))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error: $ex")
        }
    }
}