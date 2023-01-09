package tuver.manualdi.di

interface AppModule : ProviderModule,
    ApiMapperModule,
    ApiModule,
    RepositoryModule,
    DomainModule