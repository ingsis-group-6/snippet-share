# snippet-share
Snippet Share Service for ingsis

This service is able to:

Share snippet
See snippets that people shared to me(userId)
See snippets I shared
Unshare a snippet

Endpoints:

POST - /api/snippet-share/ -> Share a snippet
GET - /api/snippet-share/shared/ -> get all the snippets I shared
GET - /api/snippet-share/shared_with_me/ -> get all the snippets that people shared me
DELETE - /api/snippet-share/:shareId -> delete a user's access to a snippet
