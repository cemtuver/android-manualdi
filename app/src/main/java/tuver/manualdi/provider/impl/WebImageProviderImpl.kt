package tuver.manualdi.provider.impl

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import tuver.manualdi.di.AppModule
import tuver.manualdi.provider.WebImageProvider

class WebImageProviderImpl(
    private val fragment: Fragment
) : WebImageProvider {

    private fun <TranscodeType> RequestBuilder<TranscodeType>.transform(
        imageCrop: WebImageProvider.ImageCrop?
    ): RequestBuilder<TranscodeType> {
        return when (imageCrop) {
            WebImageProvider.ImageCrop.CIRCLE -> transform(CircleCrop())
            else -> this
        }
    }

    override fun load(imageView: ImageView, imageUrl: String, imageCrop: WebImageProvider.ImageCrop?) {
        Glide.with(fragment)
            .load(imageUrl)
            .transform(imageCrop)
            .into(imageView)
    }

    companion object {

        context(AppModule)
        fun create(fragment: Fragment): WebImageProviderImpl {
            return WebImageProviderImpl(fragment)
        }

    }

}
