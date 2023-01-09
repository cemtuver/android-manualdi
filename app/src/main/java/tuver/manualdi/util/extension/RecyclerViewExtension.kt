package tuver.manualdi.util.extension

import androidx.recyclerview.widget.DiffUtil

inline fun <reified T: Any> defaultDiffCallback(crossinline idSelectBlock: (T) -> Any): DiffUtil.ItemCallback<T> {
    return object : DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return idSelectBlock(oldItem) == idSelectBlock(newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

    }
}