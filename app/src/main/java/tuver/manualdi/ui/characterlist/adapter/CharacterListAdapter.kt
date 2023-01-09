package tuver.manualdi.ui.characterlist.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import tuver.manualdi.model.Character
import tuver.manualdi.provider.WebImageProvider
import tuver.manualdi.util.extension.defaultDiffCallback

class CharacterListAdapter(
    private val webImageProvider: WebImageProvider,
    private val itemClickListener: (Character) -> Unit
) : PagingDataAdapter<Character, CharacterViewHolder>(defaultDiffCallback { it.id }) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, itemClickListener) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.newInstance(parent, webImageProvider)
    }

}