package tuver.manualdi.di.impl

import tuver.manualdi.di.*

class AppModuleImpl(
    private val providerModule: ProviderModule,
    private val apiMapperModule: ApiMapperModule,
    private val apiModule: ApiModule,
    private val repositoryModule: RepositoryModule,
    private val domainModule: DomainModule,
) : AppModule,
    ProviderModule by providerModule,
    ApiMapperModule by apiMapperModule,
    ApiModule by apiModule,
    RepositoryModule by repositoryModule,
    DomainModule by domainModule