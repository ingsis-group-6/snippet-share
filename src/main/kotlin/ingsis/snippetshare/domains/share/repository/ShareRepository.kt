package ingsis.snippetshare.domains.share.repository

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share

interface ShareRepository {

    fun create(shareDto: ShareDTO, userId: String): Share
    fun findShared(userId: String): List<Share>
    fun findSharedWith(userId: String): List<Share>
    fun delete(id: String)
}