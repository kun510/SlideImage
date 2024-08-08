package com.kun510.slide_image

import android.content.Context
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ImagePagerAdapter(
    val context: Context,
    val imageResourceList: List<Uri>
) : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any) = view == obj as ImageView

    override fun getCount(): Int = imageResourceList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any =
        ImageView(context).apply {
            setImageURI(imageResourceList[position])
            scaleType = ImageView.ScaleType.CENTER_CROP
        }.also {
            (container as VerticalViewPager).addView(it)
        }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) =
        (container as VerticalViewPager).removeView(obj as ImageView)
}