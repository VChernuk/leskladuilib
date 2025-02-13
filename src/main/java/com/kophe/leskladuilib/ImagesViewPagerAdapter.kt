package com.kophe.leskladuilib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.kophe.leskladlib.repository.common.ItemImage


abstract class ImagesViewPagerAdapter(
    private val context: Context, private val images: Array<ItemImage>
) : PagerAdapter() {

    override fun destroyItem(container: ViewGroup, position: Int, o: Any) {
        container.removeView(o as? View)
    }

    override fun getCount() = images.size

    override fun isViewFromObject(view: View, o: Any) = view === o

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.image_viewpager_item, container, false) as ViewGroup
        val imageView = view.findViewById<ImageView>(R.id.itemImage)
//        val storageReference = Firebase.storage.getReferenceFromUrl(images[position].url)
//        Glide.with(imageView).load(storageReference).into(imageView)
        setImage(images[position].url, imageView)
        container.addView(view)
        return view
    }

    abstract fun setImage(url: String, imageView: ImageView)

}
