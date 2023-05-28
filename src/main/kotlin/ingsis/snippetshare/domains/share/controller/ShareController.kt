package ingsis.snippetshare.domains.share.controller

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.repository.ShareRepository
import ingsis.snippetshare.domains.share.service.ShareService
import ingsis.snippetshare.domains.share.service.ShareServiceImpl
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

    @DeleteMapping("/share/{id}")
    fun deleteShare(@RequestHeader("Authorization") token: String, @PathVariable(value = "id") id: UUID) {
        shareService.deleteShare(id)
    }


}