package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.PatchProfileClient
import com.bunbeauty.food_delivery.model.client.ProfileClient
import com.bunbeauty.food_delivery.model.local.Profile
import com.bunbeauty.food_delivery.model.toListWrapper
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

        /*return try {
            ResponseEntity.ok(profileService.update(patchProfileClient))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error $ex")
        }*/
    }

    @PatchMapping
    fun patchProfile(
        @RequestParam uuid: String,
        @RequestBody patchProfileClient: PatchProfileClient
    ): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(profileService.update(uuid, patchProfileClient))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error $ex")
        }
    }

    @GetMapping
    fun getProfileByUuid(@RequestParam(required = false) uuid: String?): ResponseEntity<Any> {
        return try {
            if (uuid.isNullOrEmpty())
                ResponseEntity.ok(profileService.getAllProfiles().toListWrapper())
            else
                ResponseEntity.ok(profileService.getProfileByUuid(uuid))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }
}