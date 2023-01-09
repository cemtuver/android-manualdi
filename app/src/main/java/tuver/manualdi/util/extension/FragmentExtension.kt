package tuver.manualdi.util.extension

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import tuver.manualdi.util.FragmentViewBindingPropertyDelegate

inline fun <reified T : ViewBinding> Fragment.viewBindings(): FragmentViewBindingPropertyDelegate<T> {
    val viewBindingClass = T::class.java
    val viewBindingBindMethod = viewBindingClass.getMethod("bind", View::class.java)

    return FragmentViewBindingPropertyDelegate { viewBindingBindMethod.invoke(null, it) as T }
}

inline fun <reified VM : ViewModel> Fragment.viewModelsFactory(crossinline viewModelProvider: () -> VM) : Lazy<VM> {
    val factory = object : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModelProvider() as T
        }

    }

    return viewModels { factory }
}