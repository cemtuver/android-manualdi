package tuver.manualdi.ui.characterlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tuver.manualdi.databinding.ItemCharacterBinding
import tuver.manualdi.model.Character
import tuver.manualdi.provider.WebImageProvider

class CharacterViewHolder private constructor(
    private val binding: ItemCharacterBinding,
    private val webImageProvider: WebImageProvider,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character, itemClickListener: (Character) -> Unit) {
        binding.apply {
            root.setOnClickListener { itemClickListener(character) }
            webImageProvider.load(characterImage, character.image, WebImageProvider.ImageCrop.CIRCLE)
            characterNameText.text = character.name
        }
    }

    companion object {

        fun newInstance(parent: ViewGroup, webImageProvider: WebImageProvider): CharacterViewHolder {
            val binding = ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return CharacterViewHolder(binding, webImageProvider)
        }

    }

}