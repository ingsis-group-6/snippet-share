package ingsis.snippetshare

import ingsis.snippetshare.domains.mock.repository.ShareRepositoryMock
import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.service.ShareService
import ingsis.snippetshare.domains.share.service.ShareServiceImpl
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ShareServiceTest {

    val shareService: ShareService = ShareServiceImpl(ShareRepositoryMock())

    @Test
    fun share() {

        val dto = ShareDTO("snippet1","user2")
        val share = shareService.share(dto, "user1")

        assert(share.snippetId == dto.snippetId)
        assert(share.sharerId == "user1")
        assert(share.sharedId == dto.sharedId)
        assert(shareService.getSharedPosts("user1").size == 1)
    }

    @Test
    fun getSharedPosts() {
        val dto = ShareDTO("snippet1","user2")
        val share = shareService.share(dto, "user1")
        assert(shareService.getSharedPosts("user1").size == 1)
    }

    @Test
    fun getSharedWithMePosts() {
        val dto = ShareDTO("snippet1","user2")
        val share = shareService.share(dto, "user1")
        assert(shareService.getSharedWithMePosts("user2").size == 1)
    }

    @Test
    fun deleteShare() {
        val dto = ShareDTO("snippet1","user2")
        val share = shareService.share(dto, "user1")
        shareService.deleteShare(share.id!!)
        assert(shareService.getSharedPosts("user1").size == 0)
    }
}