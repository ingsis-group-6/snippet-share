package ingsis.snippetshare.domains.share.dto

class ShareDTO {

    var snippetId: String? = null
    var sharedId: String? = null

    constructor(snippetId: String?, sharedId: String?) {
        this.snippetId = snippetId
        this.sharedId = sharedId
    }
}