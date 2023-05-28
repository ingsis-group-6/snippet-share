package ingsis.snippetshare.domains.share.repository

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import java.util.*

class ShareRepositoryImpl: ShareRepository {

    override fun create(shareDto: ShareDTO, userId: String): Share {
        TODO()
    }

    override fun findShared(userId: String): List<Share> {
        TODO()
    }

    override fun findSharedWith(userId: String): List<Share> {
        TODO()
    }

    override fun delete(id: String) {
        TODO()
    }
}