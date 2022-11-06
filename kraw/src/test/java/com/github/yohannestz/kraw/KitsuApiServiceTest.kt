package com.github.yohannestz.kraw

import com.github.yohannestz.kraw.service.KitsuService
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class KitsuApiServiceTest {
    private val kitsuClient = KitsuRetrofitClient.getInstance()
    private val apiService = kitsuClient.create(KitsuService::class.java)
    @Test
    fun getAnimeList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getAnimeList(offset = 0)
                    assert(response.isSuccessful)
                    val animeCollection = response.body()!!.data
                    print("animeSize: " + animeCollection.size.toString())
                    assert(animeCollection.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getAnime() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getAnime(1)
                    assert(response.isSuccessful)
                    val anime = response.body()!!.data
                    print("animeById: $anime")
                    assertNotNull(anime)
                    assert(anime.type.equals("anime"))
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getEpisodeList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getEpisodeList(offset = 0)
                    assert(response.isSuccessful)
                    val episode = response.body()!!.data
                    print("episodeSize: ${episode.size}")
                    assertNotNull(episode)
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getEpisode() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getEpisode(28)
                    assert(response.isSuccessful)
                    val episode = response.body()!!.data
                    assertNotNull(episode)
                    print(episode.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getTrendingAnimeList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getTrendingAnimeList(offset = 0)
                    assert(response.isSuccessful)
                    val trendingAnimeList = response.body()!!.data
                    assert(trendingAnimeList.isNotEmpty())
                    print(trendingAnimeList.size.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getMangaList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getMangaList(offset = 0)
                    assert(response.isSuccessful)
                    val mangaList = response.body()!!.data
                    assert(mangaList.isNotEmpty())
                    print(mangaList.size.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getManga() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getManga(1)
                    assert(response.isSuccessful)
                    val manga = response.body()!!.data
                    print(manga.toString())
                    assertNotNull(manga)
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getChapterList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getChapterList(offset = 0)
                    assert(response.isSuccessful)
                    val chapterList = response.body()!!.data
                    assert(chapterList.isNotEmpty())
                    print(chapterList.size.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getChapter() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getChapter(403830)
                    assert(response.isSuccessful)
                    val chapter = response.body()!!.data
                    assertNotNull(chapter)
                    print(chapter.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getTrendingMangaList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getTrendingMangaList(offset = 0)
                    assert(response.isSuccessful)
                    val mangaList = response.body()!!.data
                    assert(mangaList.isNotEmpty())
                    print(mangaList.size.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getCategoriesList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getCategoriesList(offset = 0)
                    assert(response.isSuccessful)
                    val categoryList = response.body()!!.data
                    print(categoryList.size.toString())
                    assert(categoryList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getCategory() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getCategory(1)
                    assert(response.isSuccessful)
                    val category = response.body()!!.data
                    assertNotNull(category)
                    print(category.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getCategoryFavoriteList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getCategoryFavoriteList(offset = 0)
                    assert(response.isSuccessful)
                    val categoryFavList = response.body()!!.data
                    assert(categoryFavList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getCategoryFavorite() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getCategoryFavorite(10)
                    assert(response.isSuccessful)
                    val categoryFav = response.body()!!.data
                    assertNotNull(categoryFav)
                    print(categoryFav.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getMediaRelationShipList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getMediaRelationshipList(offset = 0)
                    assert(response.isSuccessful)
                    val mediaRelationshipList = response.body()!!.data
                    assert(mediaRelationshipList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getMediaRelationship() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getMediaRelationship(1)
                    assert(response.isSuccessful)
                    val mediaRelationship = response.body()!!.data
                    assertNotNull(mediaRelationship)
                    print(mediaRelationship.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getMappingList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getMappingList()
                    assert(response.isSuccessful)
                    val mappingList = response.body()!!.data
                    assert(mappingList.isNotEmpty())
                    print(mappingList.size.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getMapping() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getMapping(1)
                    assert(response.isSuccessful)
                    val mapping = response.body()!!.data
                    assertNotNull(mapping)
                    print(mapping.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getFranchiseList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getFranchiseList()
                    assert(response.isSuccessful)
                    val franchiseList = response.body()!!.data
                    assert(franchiseList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getFranchise() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getFranchise(1)
                    assert(response.isSuccessful)
                    val franchise = response.body()!!.data
                    assertNotNull(franchise)
                    print(franchise.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getStreamerList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getStreamerList(offset = 0)
                    assert(response.isSuccessful)
                    val streamersList = response.body()!!.data
                    assert(streamersList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getStreamer() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getStreamer(1)
                    assert(response.isSuccessful)
                    val streamer = response.body()!!.data
                    assertNotNull(streamer)
                    print(streamer.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getUserList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getUserList(offset = 0)
                    assert(response.isSuccessful)
                    val userList = response.body()!!.data
                    assert(userList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getUser() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getUser(1)
                    assert(response.isSuccessful)
                    val user = response.body()!!.data
                    assertNotNull(user)
                    print(user.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    /*@Test
    fun getLibraryEntryList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getLibraryEntryList(offset = 0)
                    assert(response.isSuccessful)
                    val libList = response.body()!!.data
                    assert(libList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    } */

    @Test
    fun getLibraryEntry() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getLibraryEntry(1644)
                    assert(response.isSuccessful)
                    val libEntry = response.body()!!.data
                    assertNotNull(libEntry)
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getLibraryEntryLogList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getLibraryEntryLogList(offset = 0)
                    assert(response.isSuccessful)
                    val libEntryLogList = response.body()!!.data
                    assert(libEntryLogList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getLibraryEntryLog() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getLibraryEntryLog(22127907)
                    assert(response.isSuccessful)
                    val libraryEntryLog = response.body()!!.data
                    assertNotNull(libraryEntryLog)
                    print(libraryEntryLog.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getLibraryEventList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getLibraryEventList(offset = 0)
                    assert(response.isSuccessful)
                    val libEventList = response.body()!!.data
                    assert(libEventList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getLibraryEvent() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getLibraryEvent(5)
                    assert(response.isSuccessful)
                    val libEvent = response.body()!!.data
                    assertNotNull(libEvent)
                    print(libEvent.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getReviewList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getReviewList()
                    assert(response.isSuccessful)
                    val reviewList = response.body()!!.data
                    assert(reviewList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getReview() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getReview(4)
                    assert(response.isSuccessful)
                    val review = response.body()!!.data
                    assertNotNull(review)
                    print(review.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getPostList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getPostList(offset = 0, include = "user")
                    assert(response.isSuccessful)
                    val postList = response.body()!!.data
                    assert(postList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getPost() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getPost(167585)
                    assert(response.isSuccessful)
                    val post = response.body()!!.data
                    assertNotNull(post)
                    print(post.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getCommentList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getCommentList(offset = 0)
                    assert(response.isSuccessful)
                    val commentList = response.body()!!.data
                    assert(commentList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getComment() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getComment(7760392)
                    assert(response.isSuccessful)
                    val comment = response.body()!!.data
                    assertNotNull(comment)
                    print(comment.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getAnimeCharacterList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getAnimeCharacterList(offset = 0)
                    assert(response.isSuccessful)
                    val animeCharacterList = response.body()!!.data
                    assert(animeCharacterList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getAnimeCharacter() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getAnimeCharacter(1)
                    assert(response.isSuccessful)

                    val animeCharacter = response.body()!!.data
                    assertNotNull(animeCharacter)
                    print(animeCharacter.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getMangaCharacterList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getMangaCharacterList(offset = 0)
                    assert(response.isSuccessful)

                    val mangaCharacterList = response.body()!!.data
                    assert(mangaCharacterList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getMangaCharacter() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getMangaCharacter(1)
                    assert(response.isSuccessful)

                    val mangaCharacter = response.body()!!.data
                    assertNotNull(mangaCharacter)
                    print(mangaCharacter.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getCharacterList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getCharacterList()
                    assert(response.isSuccessful)

                    val characterList = response.body()!!.data
                    assert(characterList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getCharacter() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getCharacter(1)
                    assert(response.isSuccessful)

                    val character = response.body()!!.data
                    assertNotNull(character)
                    print(character.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getSiteAnnouncementList() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getSiteAnnouncementList(offset = 0)
                    assert(response.isSuccessful)

                    val siteAnnouncementList = response.body()!!.data
                    assert(siteAnnouncementList.isNotEmpty())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }

    @Test
    fun getSiteAnnouncement() {
        runBlocking {
            launch {
                try {
                    val response = apiService.getSiteAnnouncement(15)
                    assert(response.isSuccessful)
                    val siteAnnouncement = response.body()!!.data
                    assertNotNull(siteAnnouncement)
                    print(siteAnnouncement.toString())
                } catch (ex: Exception) {
                    print("TestError: " + ex.message.toString())
                }
            }
        }
    }
}