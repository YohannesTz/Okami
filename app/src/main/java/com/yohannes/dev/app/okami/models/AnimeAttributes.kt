package com.yohannes.dev.app.okami.models
data class Anime(
    val `data`: Data
)

data class Data(
    val attributes: Attributes,
    val id: String,
    val links: Links,
    val relationships: Relationships,
    val type: String
)

data class Attributes(
    val abbreviatedTitles: List<String>,
    val ageRating: String,
    val ageRatingGuide: String,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImage,
    val coverImageTopOffset: Int,
    val createdAt: String,
    val description: String,
    val endDate: String,
    val episodeCount: Int,
    val episodeLength: Int,
    val favoritesCount: Int,
    val nextRelease: Any,
    val nsfw: Boolean,
    val popularityRank: Int,
    val posterImage: PosterImage,
    val ratingFrequencies: RatingFrequencies,
    val ratingRank: Int,
    val showType: String,
    val slug: String,
    val startDate: String,
    val status: String,
    val subtype: String,
    val synopsis: String,
    val tba: Any,
    val titles: Titles,
    val totalLength: Int,
    val updatedAt: String,
    val userCount: Int,
    val youtubeVideoId: String
)

data class Links(
    val self: String
)

data class Relationships(
    val animeCharacters: AnimeCharacters,
    val animeProductions: AnimeProductions,
    val animeStaff: AnimeStaff,
    val castings: Castings,
    val categories: Categories,
    val characters: Characters,
    val episodes: Episodes,
    val genres: Genres,
    val installments: Installments,
    val mappings: Mappings,
    val mediaRelationships: MediaRelationships,
    val productions: Productions,
    val quotes: Quotes,
    val reviews: Reviews,
    val staff: Staff,
    val streamingLinks: StreamingLinks
)

data class CoverImage(
    val large: String,
    val meta: Meta,
    val original: String,
    val small: String,
    val tiny: String
)

data class PosterImage(
    val large: String,
    val medium: String,
    val meta: MetaX,
    val original: String,
    val small: String,
    val tiny: String
)

data class RatingFrequencies(
    val `10`: String,
    val `11`: String,
    val `12`: String,
    val `13`: String,
    val `14`: String,
    val `15`: String,
    val `16`: String,
    val `17`: String,
    val `18`: String,
    val `19`: String,
    val `2`: String,
    val `20`: String,
    val `3`: String,
    val `4`: String,
    val `5`: String,
    val `6`: String,
    val `7`: String,
    val `8`: String,
    val `9`: String
)

data class Titles(
    val en: String,
    val en_jp: String,
    val ja_jp: String
)

data class Meta(
    val dimensions: Dimensions
)

data class Dimensions(
    val large: Large,
    val small: Small,
    val tiny: Tiny
)

data class Large(
    val height: Int,
    val width: Int
)

data class Small(
    val height: Int,
    val width: Int
)

data class Tiny(
    val height: Int,
    val width: Int
)

data class MetaX(
    val dimensions: DimensionsX
)

data class DimensionsX(
    val large: LargeX,
    val medium: Medium,
    val small: SmallX,
    val tiny: TinyX
)

data class Medium(
    val height: Int,
    val width: Int
)

data class AnimeCharacters(
    val links: LinksX
)

data class AnimeProductions(
    val links: LinksX
)

data class AnimeStaff(
    val links: LinksX
)

data class Castings(
    val links: LinksX
)

data class Categories(
    val links: LinksX
)

data class Characters(
    val links: LinksX
)

data class Episodes(
    val links: LinksX
)

data class Genres(
    val links: LinksX
)

data class Installments(
    val links: LinksX
)

data class Mappings(
    val links: LinksX
)

data class MediaRelationships(
    val links: LinksX
)

data class Productions(
    val links: LinksX
)

data class Quotes(
    val links: LinksX
)

data class Reviews(
    val links: LinksX
)

data class Staff(
    val links: LinksX
)

data class StreamingLinks(
    val links: LinksX
)

data class LinksX(
    val related: String,
    val self: String
)
data class AnimeAttributes(
    val slug: String?,
    val discription: String?,
    val canonicalTitle: String?,
    val averageRating: String?,
    val startDate: String?,
    val endDate: String?,
    val ageRatingGuide: String?,
    val status: String?,
    val posterImage: PosterImage?,
    val coverImage: CoverImage?,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val totalLength: Int?,
    val youtubeVideoId: String?,
    val nsfw: Boolean
)
