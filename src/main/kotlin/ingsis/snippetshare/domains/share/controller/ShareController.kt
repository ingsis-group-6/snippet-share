package ingsis.snippetshare.domains.share.controller

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.service.ShareService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.security.Principal
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
    fun share(principal: Principal, @RequestBody shareDto: ShareDTO): Share {
        val userId = principal.name
        return shareService.share(shareDto, userId)
    }

    @GetMapping("/share")
    fun getSharedWithMePosts(principal: Principal): List<Share> {
        val userId = principal.name
        return shareService.getSharedPosts(userId)
    }

    @GetMapping("/share/shared_with_me")
    fun getSharedWithMe(principal: Principal): List<Share> {
        val userId = principal.name
        return shareService.getSharedWithMePosts(userId)
    }

    @DeleteMapping("/share/{id}")
    fun deleteShare(principal: Principal, @PathVariable(value = "id") id: UUID) {
        shareService.deleteShare(id)
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