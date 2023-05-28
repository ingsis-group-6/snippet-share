package ingsis.snippetshare.domains.share.controller

import ingsis.snippetshare.domains.mock.repository.ShareRepositoryMock
import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.repository.ShareRepository
import ingsis.snippetshare.domains.share.repository.ShareRepositoryImpl
import ingsis.snippetshare.domains.share.service.ShareService
import ingsis.snippetshare.domains.share.service.ShareServiceImpl
import org.springframework.web.bind.annotation.*
import java.util.Date

@RestController
@CrossOrigin("*")
class ShareController {

    val shareService: ShareService = ShareServiceImpl(ShareRepositoryMock())
    @PostMapping("/share")
    @ResponseBody
    fun share(@RequestHeader("Authorization") token: String, @RequestBody shareDto: ShareDTO): Share {
        return shareService.share(shareDto, token)
    }

    @GetMapping("/share")
    fun getSharedWithMePosts(@RequestHeader("Authorization") token: String): List<Share> {
        return shareService.getSharedPosts(token)
    }

    @GetMapping("/share/shared_with_me")
    fun getSharedWithMe(@RequestHeader("Authorization") token: String): List<Share> {
        return shareService.getSharedWithMePosts(token)
    }

    @DeleteMapping("/share/{id}")
    fun deleteShare(@RequestHeader("Authorization") token: String, @PathVariable(value = "id") id: String) {
        shareService.deleteShare(id)
    }


}