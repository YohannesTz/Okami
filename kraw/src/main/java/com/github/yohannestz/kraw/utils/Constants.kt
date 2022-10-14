package com.github.yohannestz.kraw.utils

object Constants {
    //urls
    const val KITSU_BASE_URL = "https://kitsu.io/"
    const val KITSU_API_URL = "$KITSU_BASE_URL/api"
    const val BASE_URL_EDGE = "$KITSU_API_URL/edge"

    //auth
    const val AUTH_URL = "$BASE_URL_EDGE/oauth"
    const val AUTH_URL_TOKEN = "$BASE_URL_EDGE/token"

    //resource
    const val ANIME_URL = "$BASE_URL_EDGE/anime"
    const val EPISODE_URL = "$BASE_URL_EDGE/episodes"
    const val TRENDING_ANIME_URL = "$BASE_URL_EDGE/trending/anime"
    const val MANGA_URL = "$BASE_URL_EDGE/manga"
    const val CHAPTERS_URL = "$BASE_URL_EDGE/chapters"
    const val TRENDING_MANGA_URL = "$BASE_URL_EDGE/manga"
    const val CATEGORIES_URL = "$BASE_URL_EDGE/categories"
    const val CATEGORIES_FAVORITES_URL = "$BASE_URL_EDGE/categories-favorites"
    const val MEDIA_RELATIONSHIPS_URL = "$BASE_URL_EDGE/media-relationships"
    const val MAPPINGS_URL = "$BASE_URL_EDGE/mappings"
    const val FRANCHISES_URL = "$BASE_URL_EDGE/franchises"
    const val STREAMERS_URL = "$BASE_URL_EDGE/streamers"
    const val STREAMERS_LINKS_URL = "$BASE_URL_EDGE/streaming-links"

    const val BLOCKS_URL = "$BASE_URL_EDGE/blocks"
    const val FAVORITES_URL = "$BASE_URL_EDGE/favorites"
    const val FOLLOWS_URL = "$BASE_URL_EDGE/follows"
    const val LINKED_ACCOUNTS_URL = "$BASE_URL_EDGE/linked-accounts"
    const val PROFILE_LINK_SITES_URL = "$BASE_URL_EDGE/profile-link-sites"
    const val PROFILE_LINK_URL = "$BASE_URL_EDGE/profile-links"
    const val ROLES_URL = "$BASE_URL_EDGE/roles"
    const val STATS_URL = "$BASE_URL_EDGE/stats"
    const val USER_ROLES_URL = "$BASE_URL_EDGE/user-roles"
    const val USERS_URL = "$BASE_URL_EDGE/users"

    const val LIBRARY_ENTRIES_URL = "$BASE_URL_EDGE/library-entries"
    const val LIBRARY_ENTRIES_LOGS_URL = "$BASE_URL_EDGE/library-entries-logs"
    const val LIBRARY_EVENTS_URL = "$BASE_URL_EDGE/library-events"
    const val LIST_IMPORTS_URL = "$BASE_URL_EDGE/list-imports"
    const val MEDIA_REACTION_URL = "$BASE_URL_EDGE/media-reactions"
    const val MEDIA_REACTION_VOTES_URL = "$BASE_URL_EDGE/media-reaction-votes"

    const val REVIEW_LIKES_URL = "$BASE_URL_EDGE/review-likes"
    const val REVIEWS_URL = "$BASE_URL_EDGE/reviews"

    const val POSTS_URL = "$BASE_URL_EDGE/posts"
    const val POSTS_LIKES_URL = "$BASE_URL_EDGE/posts-likes"
    const val POSTS_FOLLOWS_URL = "$BASE_URL_EDGE/post-follows"
    const val COMMENTS_URL = "$BASE_URL_EDGE/comments"
    const val COMMENTS_LIKES_URL = "$BASE_URL_EDGE/comments-likes"

    const val ANIME_CHARACTERS_URL = "$BASE_URL_EDGE/anime-characters"
    const val MANGA_CHARACTERS_URL = "$BASE_URL_EDGE/manga-characters"
    const val CHARACTERS_URL = "$BASE_URL_EDGE/characters"

    const val ANIME_PRODUCTIONS_URL = "$BASE_URL_EDGE/anime-productions"
    const val ANIME_STAFF_URL = "$BASE_URL_EDGE/anime-staff"
    const val MANGA_STAFF_URL = "$BASE_URL_EDGE/manga-staff"
    const val PRODUCERS_URL = "$BASE_URL_EDGE/producers"
    const val CASTINGS_URL = "$BASE_URL_EDGE/castings"
    const val PEOPLE_URL = "$BASE_URL_EDGE/people"

    const val GROUPS_URL = "$BASE_URL_EDGE/groups"
    const val GROUP_ACTION_LOGS_URL = "$BASE_URL_EDGE/group-action-logs"
    const val GROUP_BANS_URL = "$BASE_URL_EDGE/group-bans"
    const val GROUP_CATEGORIES_URL = "$BASE_URL_EDGE/group-categories"
    const val GROUP_INVITES_URL = "$BASE_URL_EDGE/group-invites"
    const val GROUP_MEMBER_NOTES_URL = "$BASE_URL_EDGE/group-member-notes"
    const val GROUP_MEMBERS_URL = "$BASE_URL_EDGE/group-members"
    const val GROUP_NEIGHBORS_URL = "$BASE_URL_EDGE/group-neighbors"
    const val GROUP_PERMISSIONS_URL = "$BASE_URL_EDGE/group-permissions"
    const val GROUP_REPORTS_URL = "$BASE_URL_EDGE/group-reports"
    const val GROUP_TICKET_MESSAGES_URL = "$BASE_URL_EDGE/group-ticket-messages"
    const val GROUP_TICKETS_URL = "$BASE_URL_EDGE/group-tickets"

    const val LEADER_CHAT_MESSAGES_URL = "$BASE_URL_EDGE/leader-chat-messages"
    const val REPORTS_URL = "$BASE_URL_EDGE/reports"
    const val SITE_ANNOUNCEMENTS_URL = "$BASE_URL_EDGE/site-announcements"
}