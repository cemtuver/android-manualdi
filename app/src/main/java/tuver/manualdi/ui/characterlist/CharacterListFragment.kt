package tuver.manualdi.ui.characterlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import tuver.manualdi.R
import tuver.manualdi.databinding.FragmentCharacterListBinding
import tuver.manualdi.ui.CharacterActivity
import tuver.manualdi.ui.CharacterTacker
import tuver.manualdi.ui.characterlist.adapter.CharacterListAdapter
import tuver.manualdi.ui.di.CharacterListModule
import tuver.manualdi.ui.di.impl.CharacterListModuleImpl
import tuver.manualdi.util.extension.viewBindings
import tuver.manualdi.util.extension.viewModelsFactory

class CharacterListFragment : Fragment(R.layout.fragment_character_list) {

    private val binding: FragmentCharacterListBinding by viewBindings()

    private val module: CharacterListModule by lazy {
        CharacterListModuleImpl((activity as CharacterActivity).module, this)
    }

    private val viewModel: CharacterListViewModel by viewModelsFactory {
        with(module) { CharacterListViewModel.create() }
    }

    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter(module.webImageProvider) {
            viewModel.onUserEventCharacterClicked(it)
        }
    }

    private val characterTacker: CharacterTacker by lazy {
        module.characterTacker
    }

    private fun setupView() {
        binding.characterRecyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.apply {
            viewState().observe(viewLifecycleOwner) { onViewStateChanged(it) }
            viewAction().observe(viewLifecycleOwner) { onViewActionChanged(it) }
        }
    }

    private fun onViewStateChanged(viewState: CharacterListViewState) {
        when (viewState) {
            is CharacterListViewState.Loading -> onLoadingViewState()
            is CharacterListViewState.Error -> onErrorViewState(viewState)
            is CharacterListViewState.Success -> onSuccessViewState(viewState)
        }
    }

    private fun onLoadingViewState() {
        // TODO("Not yet implemented")
    }

    private fun onErrorViewState(viewState: CharacterListViewState.Error) {
        // TODO("Not yet implemented")
    }

    private fun onSuccessViewState(viewState: CharacterListViewState.Success) {
        lifecycleScope.launch {
            viewState.characterListPagingData.observe(viewLifecycleOwner) { adapter.submitData(lifecycle, it) }
        }
    }

    private fun onViewActionChanged(viewAction: CharacterListViewAction) {
        when (viewAction) {
            is CharacterListViewAction.NavigateToCharacterDetail -> onNavigateToCharacterDetailViewAction(viewAction)
        }
    }

    private fun onNavigateToCharacterDetailViewAction(viewAction: CharacterListViewAction.NavigateToCharacterDetail) {
        val action = CharacterListFragmentDirections.toCharacterDetail(
            viewAction.characterId,
            viewAction.characterName
        )

        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        characterTacker.trackCharacterListView()
    }

}
