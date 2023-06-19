package ingsis.snippetshare.domains.share.controller

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.service.ShareService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun share(principal: Principal,@RequestBody shareDto: ShareDTO): ResponseEntity<Share> {
        val userId = principal.name
        return ResponseEntity(shareService.share(shareDto, userId), HttpStatus.CREATED)
    }

    @GetMapping("/share")
    fun getSharedWithMePosts(principal: Principal): ResponseEntity<List<Share>> {
        val userId = principal.name
        return ResponseEntity(shareService.getSharedPosts(userId), HttpStatus.OK)
    }

    @GetMapping("/share/shared_with_me")
    fun getSharedWithMe(principal: Principal): ResponseEntity<List<Share>> {
        val userId = principal.name
        return ResponseEntity(shareService.getSharedWithMePosts(userId), HttpStatus.OK)
    }

    @GetMapping("/share/shared_with_me/id")
    fun getSharedWithMeIds(principal: Principal): ResponseEntity<List<UUID>> {
        val userId = principal.name
        return ResponseEntity(shareService.getSharedWithMePosts(userId).map { share -> UUID.fromString(share.snippetId)}, HttpStatus.OK)
    }

    @DeleteMapping("/share/{id}")
    fun deleteShare(principal: Principal, @PathVariable(value = "id") id: UUID) : ResponseEntity<Unit>{
        shareService.deleteShare(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }


}