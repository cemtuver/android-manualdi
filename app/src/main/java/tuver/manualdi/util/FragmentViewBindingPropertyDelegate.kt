package tuver.manualdi.util

import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingPropertyDelegate<T : ViewBinding>(
    private val viewBindingBindBlock: (View) -> T
) : ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver {

    private var binding: T? = null

    private var lifecycle: Lifecycle? = null

    private fun observeFragmentLifecycleOwner(fragment: Fragment) {
        fragment.viewLifecycleOwnerLiveData.observe(fragment) { newLifecycleOwner ->
            lifecycle?.removeObserver(this)
            newLifecycleOwner.lifecycle.addObserver(this)

            lifecycle = newLifecycleOwner.lifecycle
        }
    }

    private fun bindViewBinding(fragment: Fragment): T {
        observeFragmentLifecycleOwner(fragment)

        return viewBindingBindBlock(fragment.requireView()).also {
            binding = it
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        binding = null
    }

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return binding ?: bindViewBinding(thisRef)
    }

}