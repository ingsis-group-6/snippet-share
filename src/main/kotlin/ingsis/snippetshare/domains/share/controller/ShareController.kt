package ingsis.snippetshare.domains.share.controller

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.service.ShareService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class ShareController {

    @Autowired
    private var shareService: ShareService

    @Autowired
    constructor(shareService: ShareService) {
        this.shareService = shareService
    }

    @PostMapping("/share")
    @ResponseBody
    fun share(@RequestHeader("Authorization") token: String, @RequestBody shareDto: ShareDTO): Share {
        val userId = token.split(" ")[1]
        return shareService.share(shareDto, userId)
    }

    @GetMapping("/share")
    fun getSharedWithMePosts(@RequestHeader("Authorization") token: String): List<Share> {
        val userId = token.split(" ")[1]
        return shareService.getSharedPosts(userId)
    }

    @GetMapping("/share/shared_with_me")
    fun getSharedWithMe(@RequestHeader("Authorization") token: String): List<Share> {
        val userId = token.split(" ")[1]
        return shareService.getSharedWithMePosts(userId)
    }

    @GetMapping("/share/shared_with_me/id")
    fun getSharedWithMeIds(@RequestHeader("Authorization") token: String): List<UUID> {
        val userId = token.split(" ")[1]
        return shareService.getSharedWithMePosts(userId).map { share -> UUID.fromString(share.snippetId)}
    }

    @DeleteMapping("/share/{id}")
    fun deleteShare(@RequestHeader("Authorization") token: String, @PathVariable(value = "id") id: UUID) {
        shareService.deleteShare(id)
    }

    @DeleteMapping("/share/by_snippet/{id}")
    fun deleteShareBySnippet(@RequestHeader("Authorization") token: String, @PathVariable(value = "id") id: String) {
        val userId = token.split(" ")[1]
        shareService.deleteShareBySnippet(id, userId)
    }

    @GetMapping("/public")
    fun publicEndpoint(): String{
        return "hello"
    }

    @GetMapping("/private")
    fun privateEndpoint(): String{
        return "private"
    }

    @GetMapping("/permission")
    fun permEndpoint(): String{
        return "permission"
    }


}