package ingsis.snippetshare.domains.share.service

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import java.util.*

interface ShareService {

    fun share(shareDto: ShareDTO, userId: String): Share
    fun getSharedPosts(userId: String): List<Share>
    fun getSharedWithMePosts(userId: String): List<Share>
    fun deleteShare(id: UUID)
    fun deleteShareBySnippet(id: String, userId: String)
}