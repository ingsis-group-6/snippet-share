package ingsis.snippetshare.domains.mock.repository

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.repository.ShareRepository
import java.util.*

class ShareRepositoryMock: ShareRepository {
    val shares: MutableList<Share> = mutableListOf()
    override fun create(shareDto: ShareDTO, userId: String): Share {
        val share = Share(shares.size.toString(),shareDto.snippetId!!, shareDto.sharedId!!, userId, Date(),null)
        shares.add(share)
        return share
    }

    override fun findShared(userId: String): List<Share> {
        return shares.filter { it.sharerId == userId }
    }

    override fun findSharedWith(userId: String): List<Share> {
        return shares.filter { it.sharedId == userId }
    }

    override fun delete(id: String) {
        shares.removeIf { it.id == id }
    }
}