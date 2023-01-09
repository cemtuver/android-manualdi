package tuver.manualdi.data.source.api.mapper

interface DtoMapper<TSource, TTarget> {

    fun map(source: TSource): TTarget

}