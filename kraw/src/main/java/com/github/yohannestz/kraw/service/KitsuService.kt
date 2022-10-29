package com.github.yohannestz.kraw.service

import androidx.annotation.NonNull
import com.github.yohannestz.kraw.models.Resource
import com.github.yohannestz.kraw.models.Collection
import com.github.yohannestz.kraw.models.PostCollection
import com.github.yohannestz.kraw.utils.Endpoints
import org.jetbrains.annotations.NotNull
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface KitsuService {

    @GET(Endpoints.ANIME_URL)
    suspend fun getAnimeList(
        @Query("filter[season]") season: String? = null,
        @Query("filter[seasonYear]") seasonYear: String? = null,
        @Query("filter[streamers]") streamers: String? = null,
        @Query("filter[ageRating]") ageRating: String? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.ANIME_URL + "/{id}")
    suspend fun getAnime(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.EPISODE_URL)
    suspend fun getEpisodeList(
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.EPISODE_URL + "/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.TRENDING_ANIME_URL)
    suspend fun getTrendingAnimeList(
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.MANGA_URL)
    suspend fun getMangaList(
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.MANGA_URL + "/{id}")
    suspend fun getManga(
        @Path("id") id: Int, @Query("page[limit]") pageLimit: Int = 15
    ): Response<Resource>

    @GET(Endpoints.CHAPTERS_URL)
    suspend fun getChapterList(
        @Query("filter[mangaId]") mangaId: Int? = null,
        @Query("filter[number]") number: Int? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.CHAPTERS_URL + "/{id}")
    suspend fun getChapter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.TRENDING_MANGA_URL)
    suspend fun getTrendingMangaList(
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.CATEGORIES_URL)
    suspend fun getCategoriesList(
        @Query("filter[parentId]") parentId: Int? = null,
        @Query("filter[slug]") slug: String? = null,
        @Query("filter[nsfw]") nsfw: Boolean? = null,
        
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") pageLimit: Int = 15
    ): Response<Collection>

    @GET(Endpoints.CATEGORIES_URL + "/{id}")
    suspend fun getCategory(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.CATEGORIES_FAVORITES_URL)
    suspend fun getCategoryFavoriteList(
        @Query("filter[userId]") userId: Int? = null,
        @Query("filter[categoryId]") categoryId: Int? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.CATEGORIES_FAVORITES_URL + "/{id}")
    suspend fun getCategoryFavorite(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.MEDIA_RELATIONSHIPS_URL)
    suspend fun getMediaRelationshipList(
        @Query("filter[role]") role: String? = null,
        @Query("filter[sourceType") sourceType: String? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

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
    suspend fun getStreamerList(
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.STREAMERS_URL + "/{id}")
    suspend fun getStreamer(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.USERS_URL)
    suspend fun getUserList(
        @Query("filter[slug]") slug: String? = null,
        @Query("filter[name]") name: String? = null,
        @Query("filter[self]") self: Boolean? = null,
        @Query("filter[query]") query: String? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.USERS_URL + "/{id}")
    suspend fun getUser(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.LIBRARY_ENTRIES_URL)
    suspend fun getLibraryEntryList(
        @Query("filter[dramaId]") dramaId: Int? = null,
        @Query("filter[following]") following: Boolean? = null,
        @Query("filter[animeId]") animeId: Int? = null,
        @Query("filter[mangaId]") mangaId: Int? = null,
        @Query("filter[kind]") kind: String? = null,
        @Query("filter[since]") since: String? = null,
        @Query("filter[status]") status: String? = null,
        @Query("filter[title]") title: String? = null,
        @Query("filter[userId]") userId: Int? = null,
        
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") pageLimit: Int = 15
    ): Response<Collection>

    @GET(Endpoints.LIBRARY_ENTRIES_URL + "/{id}")
    suspend fun getLibraryEntry(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.LIBRARY_ENTRIES_LOGS_URL)
    suspend fun getLibraryEntryLogList(
        @Query("filter[linkedAccountId]") linkedAccountId: Int? = null,
        @Query("filter[syncStatus]") syncStatus: String? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.LIBRARY_ENTRIES_LOGS_URL + "/{id}")
    suspend fun getLibraryEntryLog(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.LIBRARY_EVENTS_URL)
    suspend fun getLibraryEventList(
        @Query("filter[userId]") userId: Int? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.LIBRARY_EVENTS_URL + "/{id}")
    suspend fun getLibraryEvent(@Path("id") id: Int): Response<Resource>

    @Deprecated("Use 'media-reactions' instead")
    @GET(Endpoints.REVIEWS_URL)
    suspend fun getReviewList(): Response<Collection>

    @Deprecated("User 'media-reactions' instead")
    @GET(Endpoints.REVIEWS_URL + "/{id}")
    suspend fun getReview(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.POSTS_URL)
    suspend fun getPostList(
        @Query("page[limit]") pageLimit: Int = 15,
        @Query("page[offset]") offset: Int,
        @Query("include") include: String,
    ): Response<PostCollection>

    @GET(Endpoints.POSTS_URL + "/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.COMMENTS_URL)
    suspend fun getCommentList(
        @Query("filter[postId]") postId: Int? = null,
        @Query("filter[parentId]") parentId: Int? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.COMMENTS_URL + "/{id}")
    suspend fun getComment(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.ANIME_CHARACTERS_URL)
    suspend fun getAnimeCharacterList(
        @Query("filter[animeId]") animeId: Int? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.ANIME_CHARACTERS_URL + "/{id}")
    suspend fun getAnimeCharacter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.MANGA_CHARACTERS_URL)
    suspend fun getMangaCharacterList(
        @Query("filter[mangaId]") mangaId: Int? = null,
        @Query("page[limit]") pageLimit: Int = 15,
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.MANGA_CHARACTERS_URL + "/{id}")
    suspend fun getMangaCharacter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.CHARACTERS_URL)
    suspend fun getCharacterList(): Response<Collection>

    @GET(Endpoints.CHARACTERS_URL + "/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Resource>

    @GET(Endpoints.SITE_ANNOUNCEMENTS_URL)
    suspend fun getSiteAnnouncementList(
        @Query("page[limit]") pageLimit: Int = 15,
        
        @Query("page[offset]") offset: Int
    ): Response<Collection>

    @GET(Endpoints.SITE_ANNOUNCEMENTS_URL + "/{id}")
    suspend fun getSiteAnnouncement(@Path("id") id: Int): Response<Resource>


}