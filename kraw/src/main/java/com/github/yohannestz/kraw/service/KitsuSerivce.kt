package com.github.yohannestz.kraw.service

import com.github.yohannestz.kraw.models.Resource
import com.github.yohannestz.kraw.models.Collection
import com.github.yohannestz.kraw.utils.Endpoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface KitsuSerivce {

    @GET(Endpoints.ANIME_URL)
    suspend fun getAnimeList(): Response<Collection>

    @GET(Endpoints.ANIME_URL +  "/{id}")
    suspend fun getAnime(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.EPISODE_URL)
    suspend fun getEpisodeList(): Response<Collection>

    @GET(Endpoints.EPISODE_URL + "/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.TRENDING_ANIME_URL)
    suspend fun getTrendingAnimeList(): Response<Collection>

    @GET(Endpoints.MANGA_URL)
    suspend fun getMangaList(): Response<Collection>

    @GET(Endpoints.MANGA_URL + "/{id}")
    suspend fun getManga(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.CHAPTERS_URL)
    suspend fun getChapterList(): Response<Collection>

    @GET(Endpoints.CHAPTERS_URL + "/{id}")
    suspend fun getChapter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.TRENDING_MANGA_URL)
    suspend fun getTrendingMangaList(): Response<Collection>

    @GET(Endpoints.CATEGORIES_URL)
    suspend fun getCategoriesList(): Response<Collection>

    @GET(Endpoints.CATEGORIES_URL + "/{id}")
    suspend fun getCategory(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.CATEGORIES_FAVORITES_URL)
    suspend fun getCategoryFavoriteList(): Response<Collection>

    @GET(Endpoints.CATEGORIES_FAVORITES_URL + "/{id}")
    suspend fun getCategoryFavorite(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.MEDIA_RELATIONSHIPS_URL)
    suspend fun getMediaRelationshipList(): Response<Collection>

    @GET(Endpoints.MEDIA_RELATIONSHIPS_URL + "/{id}")
    suspend fun getMediaRelationship(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.MAPPINGS_URL)
    suspend fun getMappingList(): Response<Collection>

    @GET(Endpoints.MAPPINGS_URL + "/{id}")
    suspend fun getMapping(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.FRANCHISES_URL)
    suspend fun getFranchiseList(): Response<Collection>

    @GET(Endpoints.FRANCHISES_URL + "/{id}")
    suspend fun getFranchise(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.STREAMERS_URL)
    suspend fun getStreamerList(): Response<Collection>

    @GET(Endpoints.STREAMERS_URL + "/{id}")
    suspend fun getStreamer(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.USERS_URL)
    suspend fun getUserList(): Response<Collection>

    @GET(Endpoints.USERS_URL + "/{id}")
    suspend fun getUser(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.LIBRARY_ENTRIES_URL)
    suspend fun getLibraryEntryList(): Response<Collection>

    @GET(Endpoints.LIBRARY_ENTRIES_URL + "/{id}")
    suspend fun getLibraryEntry(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.LIBRARY_ENTRIES_LOGS_URL)
    suspend fun getLibraryEntryLogList(): Response<Collection>

    @GET(Endpoints.LIBRARY_ENTRIES_LOGS_URL + "/{id}")
    suspend fun getLibraryEntryLog(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.LIBRARY_EVENTS_URL)
    suspend fun getLibraryEventList(): Response<Collection>

    @GET(Endpoints.LIBRARY_EVENTS_URL + "/{id}")
    suspend fun getLibraryEvent(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.REVIEWS_URL)
    suspend fun getReviewList(): Response<Collection>

    @GET(Endpoints.REVIEWS_URL + "/{id}")
    suspend fun getReview(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.POSTS_URL)
    suspend fun getPostList(): Response<Collection>

    @GET(Endpoints.POSTS_URL + "/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.COMMENTS_URL)
    suspend fun getCommentList(): Response<Collection>

    @GET(Endpoints.COMMENTS_URL + "/{id}")
    suspend fun getComment(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.ANIME_CHARACTERS_URL)
    suspend fun getAnimeCharacterList(): Response<Collection>

    @GET(Endpoints.ANIME_CHARACTERS_URL + "/{id}")
    suspend fun getAnimeCharacter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.MANGA_CHARACTERS_URL)
    suspend fun getMangaCharacterList(): Response<Collection>

    @GET(Endpoints.MANGA_CHARACTERS_URL + "/{id}")
    suspend fun getMangaCharacter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.CHARACTERS_URL)
    suspend fun getCharacterList(): Response<Collection>

    @GET(Endpoints.CHARACTERS_URL + "/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.SITE_ANNOUNCEMENTS_URL)
    suspend fun getSiteAnnouncementList(): Response<Collection>

    @GET(Endpoints.SITE_ANNOUNCEMENTS_URL + "/{id}")
    suspend fun getSiteAnnouncement(@Path("id") id: Int): Response<Resource>
}