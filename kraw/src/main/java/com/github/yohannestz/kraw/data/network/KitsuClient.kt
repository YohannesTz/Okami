package com.github.yohannestz.kraw.data.network

import com.github.yohannestz.kraw.KitsuRetrofitClient
import com.github.yohannestz.kraw.models.Data
import com.github.yohannestz.kraw.service.KitsuService

open class KitsuClient {

    private val kitsuClient = KitsuRetrofitClient.getInstance()
    private val animeApiService = kitsuClient.create(KitsuService::class.java)

    open suspend fun getAnime(offset: Int): List<Data>? {
        val response = animeApiService.getAnimeList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getAnimeBySeason(offset: Int, season: String): List<Data>? {
        val response = animeApiService.getAnimeList(offset = offset, season = season)
        return response.body()?.data
    }

    open suspend fun getAnimeBySeasonYear(offset: Int, seasonYear: String): List<Data>? {
        val response = animeApiService.getAnimeList(offset = offset, seasonYear = seasonYear)
        return response.body()?.data
    }

    open suspend fun getAnimeByStreamer(offset: Int, streamer: String): List<Data>? {
        val response = animeApiService.getAnimeList(offset = offset, streamers = streamer)
        return response.body()?.data
    }

    open suspend fun getAnimeByAgeRating(offset: Int, ageRating: String): List<Data>? {
        val response = animeApiService.getAnimeList(offset = offset, ageRating = ageRating)
        return response.body()?.data
    }

    open suspend fun getAnime(
        offset: Int,
        season: String,
        streamer: String,
        seasonYear: String,
        ageRating: String
    ): List<Data>? {
        val response = animeApiService.getAnimeList(
            season,
            seasonYear,
            streamers = streamer,
            ageRating,
            offset = offset
        )
        return response.body()?.data
    }

    open suspend fun getAnimeById(id: Int): Data? {
        val response = animeApiService.getAnime(id)
        return response.body()?.data
    }

    open suspend fun getEpisodes(offset: Int): List<Data>? {
        val response = animeApiService.getEpisodeList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getEpisodeList(offset: Int): List<Data>? {
        val response = animeApiService.getEpisodeList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getEpisodeById(id: Int): Data? {
        val response = animeApiService.getEpisode(id)
        return response.body()?.data
    }

    open suspend fun getTrendingAnimes(offset: Int): List<Data>? {
        val response = animeApiService.getTrendingAnimeList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getMangas(offset: Int): List<Data>? {
        val response = animeApiService.getMangaList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getMangaById(id: Int): Data? {
        val response = animeApiService.getManga(id)
        return response.body()?.data
    }

    open suspend fun getChaptersByMangaId(mangaId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getChapterList(mangaId = mangaId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getChaptersByNumber(number: Int, offset: Int): List<Data>? {
        val response = animeApiService.getChapterList(number = number, offset = offset)
        return response.body()?.data
    }

    open suspend fun getChapters(mangaId: Int, number: Int, offset: Int): List<Data>? {
        val response =
            animeApiService.getChapterList(mangaId = mangaId, number = number, offset = offset)
        return response.body()?.data
    }

    open suspend fun getChapters(offset: Int): List<Data>? {
        val response = animeApiService.getChapterList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getTrendingMangas(offset: Int): List<Data>? {
        val response = animeApiService.getTrendingMangaList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getCategoriesByParent(parentId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getCategoriesList(parentId = parentId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getCategoriesBySlug(slug: String, offset: Int): List<Data>? {
        val response = animeApiService.getCategoriesList(slug = slug, offset = offset)
        return response.body()?.data
    }

    open suspend fun getCategoriesByNsfw(nsfw: Boolean, offset: Int): List<Data>? {
        val response = animeApiService.getCategoriesList(nsfw = nsfw, offset = offset)
        return response.body()?.data
    }

    open suspend fun getCategories(
        parentId: Int,
        slug: String,
        nsfw: Boolean,
        offset: Int
    ): List<Data>? {
        val response = animeApiService.getCategoriesList(parentId, slug, nsfw, offset)
        return response.body()?.data
    }

    open suspend fun getCategoryById(id: Int): Data? {
        val response = animeApiService.getCategory(id)
        return response.body()?.data
    }

    open suspend fun getCategoryFavoritesByUserId(userId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getCategoryFavoriteList(userId = userId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getCategoryFavoritesByCategoryId(categoryId: Int, offset: Int): List<Data>? {
        val response =
            animeApiService.getCategoryFavoriteList(categoryId = categoryId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getCategoryFavorites(userId: Int, categoryId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getCategoryFavoriteList(
            userId = userId,
            categoryId = categoryId,
            offset = offset
        )
        return response.body()?.data
    }

    open suspend fun getMediaRelationshipsByRole(role: String, offset: Int): List<Data>? {
        val response = animeApiService.getMediaRelationshipList(role = role, offset = offset)
        return response.body()?.data
    }

    open suspend fun getMediaRelationshipsBySourceType(
        sourceType: String,
        offset: Int
    ): List<Data>? {
        val response =
            animeApiService.getMediaRelationshipList(sourceType = sourceType, offset = offset)
        return response.body()?.data
    }

    open suspend fun getMediaRelationships(
        role: String,
        sourceType: String,
        offset: Int
    ): List<Data>? {
        val response = animeApiService.getMediaRelationshipList(
            role = role,
            sourceType = sourceType,
            offset = offset
        )
        return response.body()?.data
    }

    open suspend fun getMediaRelationshipById(id: Int): Data? {
        val response = animeApiService.getMediaRelationship(id)
        return response.body()?.data
    }

    open suspend fun getMappings(): List<Data>? {
        val response = animeApiService.getMappingList()
        return response.body()?.data
    }

    open suspend fun getFranchises(): List<Data>? {
        val response = animeApiService.getFranchiseList()
        return response.body()?.data
    }

    open suspend fun getStreamers(offset: Int): List<Data>? {
        val response = animeApiService.getStreamerList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getStreamerById(id: Int): Data? {
        val response = animeApiService.getStreamer(id)
        return response.body()?.data
    }

    open suspend fun getUsersBySlug(slug: String, offset: Int): List<Data>? {
        val response = animeApiService.getUserList(slug = slug, offset = offset)
        return response.body()?.data
    }

    open suspend fun getUsersByName(name: String, offset: Int): List<Data>? {
        val response = animeApiService.getUserList(name = name, offset = offset)
        return response.body()?.data
    }

    open suspend fun getUsersBySelf(self: Boolean, offset: Int): List<Data>? {
        val response = animeApiService.getUserList(self = self, offset = offset)
        return response.body()?.data
    }

    open suspend fun getUsersByQuery(query: String, offset: Int): List<Data>? {
        val response = animeApiService.getUserList(query = query, offset = offset)
        return response.body()?.data
    }

    open suspend fun getUsers(
        slug: String,
        name: String,
        self: Boolean,
        query: String,
        offset: Int
    ): List<Data>? {
        val response = animeApiService.getUserList(
            slug = slug,
            name = name,
            self = self,
            query = query,
            offset = offset
        )
        return response.body()?.data
    }

    open suspend fun getUserById(id: Int): Data? {
        val response = animeApiService.getUser(id)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByDramaId(dramaId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(dramaId = dramaId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByFollowing(following: Boolean, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(following = following, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByAnimeId(animeId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(animeId = animeId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByMangaId(mangaId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(mangaId = mangaId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByKind(kind: String, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(kind = kind, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesBySince(since: String, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(since = since, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByStatus(status: String, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(status = status, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByTitle(title: String, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(title = title, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntriesByUserId(userId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEntryList(userId = userId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntries(
        dramaId: Int,
        following: Boolean,
        animeId: Int,
        mangaId: Int,
        kind: String,
        since: String,
        status: String,
        title: String,
        userId: Int,
        offset: Int
    ): List<Data>? {
        val response = animeApiService.getLibraryEntryList(
            dramaId,
            following,
            animeId,
            mangaId,
            kind,
            since,
            status,
            title,
            userId,
            offset
        )
        return response.body()?.data
    }

    open suspend fun getLibraryEntryById(id: Int, offset: Int): Data? {
        val response = animeApiService.getLibraryEntry(id)
        return response.body()?.data
    }

    open suspend fun getLibraryEntryLogsByLinkedAccount(
        linkedAccountId: Int,
        offset: Int
    ): List<Data>? {
        val response = animeApiService.getLibraryEntryLogList(
            linkedAccountId = linkedAccountId,
            offset = offset
        )
        return response.body()?.data
    }

    open suspend fun getLibraryEntryLogsBySyncStatus(syncStatus: String, offset: Int): List<Data>? {
        val response =
            animeApiService.getLibraryEntryLogList(syncStatus = syncStatus, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEntryLogs(
        linkedAccountId: Int,
        syncStatus: String,
        offset: Int
    ): List<Data>? {
        val response = animeApiService.getLibraryEntryLogList(
            linkedAccountId = linkedAccountId,
            syncStatus = syncStatus,
            offset = offset
        )
        return response.body()?.data
    }

    open suspend fun getLibraryEntryLogsById(id: Int): Data? {
        val response = animeApiService.getLibraryEntryLog(id)
        return response.body()?.data
    }

    open suspend fun getLibraryEventsByUserId(userId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getLibraryEventList(userId = userId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEvents(
        userId: Int,
        offset: Int
    ): List<Data>? {
        val response = animeApiService.getLibraryEventList(userId = userId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getLibraryEventById(id: Int): Data? {
        val response = animeApiService.getLibraryEvent(id)
        return response.body()?.data
    }

    open suspend fun getReviews(): List<Data>? {
        val response = animeApiService.getReviewList()
        return response.body()?.data
    }

    open suspend fun getReviewById(id: Int): Data? {
        val response = animeApiService.getReview(id)
        return response.body()?.data
    }

    open suspend fun getPosts(offset: Int): List<Data>? {
        val response = animeApiService.getPostList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getPostById(id: Int): Data? {
        val response = animeApiService.getPost(id)
        return response.body()?.data
    }

    open suspend fun getCommentsByPostId(postId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getCommentList(postId = postId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getCommentsByParentId(parentId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getCommentList(parentId = parentId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getComments(postId: Int, parentId: Int, offset: Int): List<Data>? {
        val response =
            animeApiService.getCommentList(postId = postId, parentId = parentId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getCommentById(id: Int): Data? {
        val response = animeApiService.getComment(id = id)
        return response.body()?.data
    }

    open suspend fun getAnimeCharactersByAnimeId(animeId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getAnimeCharacterList(animeId = animeId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getAnimeCharacters(offset: Int): List<Data>? {
        val response = animeApiService.getAnimeCharacterList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getAnimeCharacterById(id: Int): Data? {
        val response = animeApiService.getAnime(id)
        return response.body()?.data
    }

    open suspend fun getMangaCharactersByMangaId(mangaId: Int, offset: Int): List<Data>? {
        val response = animeApiService.getMangaCharacterList(mangaId = mangaId, offset = offset)
        return response.body()?.data
    }

    open suspend fun getMangaCharacters(offset: Int): List<Data>? {
        val response = animeApiService.getMangaCharacterList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getCharacters(offset: Int): List<Data>? {
        val response = animeApiService.getChapterList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getCharacterById(id: Int): Data? {
        val response = animeApiService.getCharacter(id = id)
        return response.body()?.data
    }

    open suspend fun getSiteAnnouncements(offset: Int): List<Data>? {
        val response = animeApiService.getSiteAnnouncementList(offset = offset)
        return response.body()?.data
    }

    open suspend fun getSiteAnnouncementById(id: Int): Data? {
        val response = animeApiService.getSiteAnnouncement(id)
        return response.body()?.data
    }
}