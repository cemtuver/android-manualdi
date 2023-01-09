package tuver.manualdi.provider

import android.widget.ImageView

interface WebImageProvider {

    enum class ImageCrop {
        CIRCLE
    }

    fun load(imageView: ImageView, imageUrl: String, imageCrop: ImageCrop? = null)

}