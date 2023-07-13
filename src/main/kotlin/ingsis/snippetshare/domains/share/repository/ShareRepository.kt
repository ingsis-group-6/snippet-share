package ingsis.snippetshare.domains.share.repository

import ingsis.snippetshare.domains.share.dto.ShareDTO
import ingsis.snippetshare.domains.share.model.Share
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface ShareRepository: JpaRepository<Share, UUID>{

    @Query("SELECT s FROM Share s WHERE s.sharerId = :userId")
    fun findShared(userId: String): List<Share>
    @Query("SELECT s FROM Share s WHERE s.sharedId = :userId")
    fun findSharedWith(userId: String): List<Share>
    @Modifying
    @Transactional
    @Query("DELETE FROM Share s WHERE s.snippetId = :snippetId")
    fun deleteSharesBySnippetId(snippetId: String)

}