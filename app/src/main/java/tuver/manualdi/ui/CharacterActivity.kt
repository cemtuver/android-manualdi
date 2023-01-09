package tuver.manualdi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.R
import tuver.manualdi.ui.di.CharacterModule
import tuver.manualdi.ui.di.impl.CharacterModuleImpl

class CharacterActivity : AppCompatActivity(R.layout.activity_character) {

    val module: CharacterModule = CharacterModuleImpl(appModule)

    private val navHostFragment: NavHostFragment
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

    private val navController: NavController by lazy {
        navHostFragment.findNavController()
    }

    private val characterTacker: CharacterTacker by lazy {
        module.characterTacker
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

    override fun onStop() {
        characterTacker.saveSession()
        super.onStop()
    }

}