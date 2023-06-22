package ingsis.snippetshare.domains.share.model

import java.util.Date
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "share")
class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID? = null

    @Column(name = "snippetId", nullable = false)
    var snippetId: String? = null

    @Column(name = "sharedId", nullable = false)
    var sharedId: String? = null

    @Column(name = "sharerId", nullable = false)
    var sharerId: String? = null

    @Column(name = "createdAt", nullable = false)
    var createdAt: Date? = null

    @Column(name = "updatedAt", nullable = true)
    var updatedAt: Date? = null

    constructor(id: UUID?, snippetId: String?, sharedId: String?, sharerId: String?,createdAt: Date?, updatedAt: Date?) {
        this.id = id
        this.snippetId = snippetId
        this.sharedId = sharedId
        this.sharerId = sharerId
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    constructor(snippetId: String?, sharedId: String?, sharerId: String?) {
        this.snippetId = snippetId
        this.sharedId = sharedId
        this.sharerId = sharerId
        this.createdAt = Date()
    }

}