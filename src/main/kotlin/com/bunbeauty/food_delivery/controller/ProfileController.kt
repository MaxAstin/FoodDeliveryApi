package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.ProfileClient
import com.bunbeauty.food_delivery.model.local.Profile
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
    fun postProfile(@RequestBody profile: ProfileClient): ProfileClient {
        return profileService.insert(profile)
    }

    @PatchMapping
    fun patchProfile(@RequestBody profile: ProfileClient): ProfileClient {
        return profileService.update(profile)
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