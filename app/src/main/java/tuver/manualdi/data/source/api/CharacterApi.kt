package tuver.manualdi.data.source.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import tuver.manualdi.data.source.api.dto.CharacterDto
import tuver.manualdi.data.source.api.dto.PagedResultDto

interface CharacterApi {

    @GET("character")
    suspend fun getCharacterList(): PagedResultDto<CharacterDto>

    @GET
    suspend fun getCharacterList(@Url page: String): PagedResultDto<CharacterDto>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDto

}