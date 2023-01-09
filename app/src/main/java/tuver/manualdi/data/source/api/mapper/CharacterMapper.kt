package tuver.manualdi.data.source.api.mapper

import tuver.manualdi.data.source.api.dto.CharacterDto
import tuver.manualdi.model.Character

class CharacterMapper : DtoMapper<CharacterDto, Character> {

    override fun map(source: CharacterDto): Character {
        return source.run {
            Character(
                id,
                name,
                image
            )
        }
    }

}