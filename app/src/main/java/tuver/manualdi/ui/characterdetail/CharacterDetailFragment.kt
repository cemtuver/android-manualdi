package tuver.manualdi.ui.characterdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import tuver.manualdi.R
import tuver.manualdi.databinding.FragmentCharacterDetailBinding
import tuver.manualdi.provider.WebImageProvider
import tuver.manualdi.ui.CharacterActivity
import tuver.manualdi.ui.CharacterTacker
import tuver.manualdi.ui.di.CharacterDetailModule
import tuver.manualdi.ui.di.impl.CharacterDetailModuleImpl
import tuver.manualdi.util.extension.viewBindings
import tuver.manualdi.util.extension.viewModelsFactory

class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val args: CharacterDetailFragmentArgs by navArgs()

    private val binding: FragmentCharacterDetailBinding by viewBindings()

    private val module: CharacterDetailModule by lazy {
        CharacterDetailModuleImpl((activity as CharacterActivity).module, this)
    }

    private val viewModel: CharacterDetailViewModel by viewModelsFactory {
        with(module) { CharacterDetailViewModel.create(args.characterId) }
    }

    private val characterTacker: CharacterTacker by lazy {
        module.characterTacker
    }

    private fun observeViewModel() {
        viewModel.viewState().observe(viewLifecycleOwner, this::onViewStateChanged)
    }

    private fun onViewStateChanged(viewState: CharacterDetailViewState) {
        when (viewState) {
            is CharacterDetailViewState.Loading -> onLoadingViewState()
            is CharacterDetailViewState.Error -> onErrorViewState(viewState)
            is CharacterDetailViewState.Success -> onSuccessViewState(viewState)
        }
    }

    private fun onLoadingViewState() {
        // TODO("Not yet implemented")
    }

    private fun onErrorViewState(viewState: CharacterDetailViewState.Error) {
        // TODO("Not yet implemented")
    }

    private fun onSuccessViewState(viewState: CharacterDetailViewState.Success) {
        val character = viewState.character

        binding.apply {
            module.webImageProvider.load(characterImage, character.image, WebImageProvider.ImageCrop.CIRCLE)
            characterNameText.text = character.name
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        characterTacker.trackCharacterView(args.characterName)
    }

}