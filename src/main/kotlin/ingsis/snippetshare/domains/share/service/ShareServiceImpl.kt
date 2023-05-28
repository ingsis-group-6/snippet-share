package ingsis.snippetshare.domains.share.service

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import ingsis.snippetshare.domains.share.repository.ShareRepository

class ShareServiceImpl: ShareService {

    private val shareRepository: ShareRepository
    constructor(shareRepository: ShareRepository) {
        this.shareRepository = shareRepository
    }
    override fun share(shareDto: ShareDTO, userId: String): Share {
        return this.shareRepository.create(shareDto, userId)
    }

    override fun getSharedPosts(userId: String): List<Share> {
        return this.shareRepository.findShared(userId)
    }

    override fun getSharedWithMePosts(userId: String): List<Share> {
        return this.shareRepository.findSharedWith(userId)
    }

    override fun deleteShare(id: String) {
        this.shareRepository.delete(id)
    }
}