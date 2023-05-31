package ingsis.snippetshare.domains.share.service

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.repository.ShareRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShareServiceImpl: ShareService {

    @Autowired
    private var shareRepository: ShareRepository

    constructor(shareRepository: ShareRepository) {
        this.shareRepository = shareRepository
    }
    override fun share(shareDto: ShareDTO, userId: String): Share {
        val share = Share(
            shareDto.snippetId,
            shareDto.sharedId,
            userId
        )
        println(share)
        return this.shareRepository.save(share)
    }

    override fun getSharedPosts(userId: String): List<Share> {
        return this.shareRepository.findShared(userId)
    }

    override fun getSharedWithMePosts(userId: String): List<Share> {
        return this.shareRepository.findSharedWith(userId)
    }

    override fun deleteShare(id: UUID) {
        this.shareRepository.deleteById(id)
    }
}