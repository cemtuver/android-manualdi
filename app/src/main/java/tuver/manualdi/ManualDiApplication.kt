package tuver.manualdi

import android.app.Application
import tuver.manualdi.di.AppModule
import tuver.manualdi.di.impl.*

class ManualDiApplication : Application() {

    private fun initializeAppModule() {
        val providerModule = ProviderModuleImpl()
        val apiMapperModule = ApiMapperModuleImpl()
        val apiModule = ApiModuleImpl(providerModule)
        val repositoryModule = RepositoryModuleImpl()
        val domainModule = DomainModuleImpl()

        appModule = AppModuleImpl(
            providerModule,
            apiMapperModule,
            apiModule,
            repositoryModule,
            domainModule
        )
    }

    override fun onCreate() {
        super.onCreate()
        initializeAppModule()
    }

    companion object {

        lateinit var appModule: AppModule

    }

}