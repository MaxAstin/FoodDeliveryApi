package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.profile.PatchProfileClient
import com.bunbeauty.food_delivery.model.client.profile.PostProfileClient
import com.bunbeauty.food_delivery.model.client.profile.ProfileClient
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
    fun postProfile(@RequestBody profile: PostProfileClient): ResponseEntity<Any>  {
        return try {
            ResponseEntity.ok(profileService.insert(profile))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }

    @PatchMapping
    fun patchProfile(
        @RequestParam uuid: String,
        @RequestBody patchProfileClient: PatchProfileClient
    ): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(profileService.update(uuid, patchProfileClient))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
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