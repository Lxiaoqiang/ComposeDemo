package com.example.demo.ext

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.webp.decoder.WebpDrawable
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.demo.R
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * 加载图片
 */
fun ImageView.load(view: View, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(view.context)) {
        return
    }
    Glide.with(view)
        .load(res)
        .placeholder(placeHolder)
        .transform(CenterCrop())
        .into(this)
}

/**
 * 加载图片
 */
fun ImageView.load(fragment: Fragment, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .transform(CenterCrop())
        .into(this)
}

/**
 * 加载图片
 */
fun ImageView.load(act: FragmentActivity, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(act)) {
        return
    }
    Glide.with(act)
        .load(res)
        .placeholder(placeHolder)
        .transform(CenterCrop())
        .into(this)
}

/**
 * 加载图片
 */
fun ImageView.load(act: Activity, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(act)) {
        return
    }
    Glide.with(act)
        .load(res)
        .placeholder(placeHolder)
        .transform(CenterCrop())
        .into(this)
}

/**
 * ImageView圆形
 */
fun ImageView.circle(view: View, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(view.context)) {
        return
    }
    Glide.with(view)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}


/**
 * ImageView圆形
 */
fun ImageView.circle(view: View, placeHolder: Drawable, res: Any?) {
    if (!isInLifecycle(view.context)) {
        return
    }
    Glide.with(view)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}


/**
 * ImageView圆形
 */
fun ImageView.circle(fragment: Fragment, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}

/**
 * ImageView圆形
 */
fun ImageView.circle(fragment: Fragment, placeHolder: Drawable, res: Any?) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}

/**
 * ImageView圆形
 */
fun ImageView.circle(activity: Activity, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(activity)) {
        return
    }
    Glide.with(activity)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}

/**
 * ImageView圆形
 */
fun ImageView.circle(activity: Activity, placeHolder: Drawable, res: Any?) {
    if (!isInLifecycle(activity)) {
        return
    }
    Glide.with(activity)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}

/**
 * ImageView圆形
 */
fun ImageView.circle(context: Context, @IdRes @DrawableRes placeHolder: Int, res: Any?) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}

/**
 * ImageView圆形
 */
fun ImageView.circle(context: Context, placeHolder: Drawable, res: Any?) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}


/**
 * ImageView圆形
 */
fun ImageView.circle(
    fragmentActivity: FragmentActivity,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
) {
    if (!isInLifecycle(fragmentActivity)) {
        return
    }
    Glide.with(fragmentActivity)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}

/**
 * ImageView圆形
 */
fun ImageView.circle(fragmentActivity: FragmentActivity, placeHolder: Drawable, res: Any?) {
    if (!isInLifecycle(fragmentActivity)) {
        return
    }
    Glide.with(fragmentActivity)
        .load(res)
        .placeholder(placeHolder)
        .transform(MultiTransformation(CenterCrop(), CircleCrop()))
        .into(this)
}


/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(
    fragment: Fragment,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(fragment: Fragment, placeHolder: Drawable, res: Any?, radius: Int) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(
    activity: Activity,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
) {
    if (!isInLifecycle(activity)) {
        return
    }
    Glide.with(activity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(activity: Activity, placeHolder: Drawable, res: Any?, radius: Int) {
    if (!isInLifecycle(activity)) {
        return
    }
    Glide.with(activity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(view: View, @IdRes @DrawableRes placeHolder: Int, res: Any?, radius: Int) {
    if (!isInLifecycle(view.context)) {
        return
    }
    Glide.with(view)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(view: View, placeHolder: Drawable, res: Any?, radius: Int) {
    if (!isInLifecycle(view.context)) {
        return
    }
    Glide.with(view)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(
    context: Context,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(context: Context, placeHolder: Drawable, res: Any?, radius: Int) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(
    fragmentActivity: FragmentActivity,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
) {
    if (!isInLifecycle(fragmentActivity)) {
        return
    }
    Glide.with(fragmentActivity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}

/**
 * ImageView圆角
 * @param radius 圆角角度，单位dp
 */
fun ImageView.corner(
    fragmentActivity: FragmentActivity,
    placeHolder: Drawable,
    res: Any?,
    radius: Int,
) {
    if (!isInLifecycle(fragmentActivity)) {
        return
    }
    Glide.with(fragmentActivity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    radius.toFloat().dp.toInt(),
                    0
                )
            )
        )
        .into(this)
}


/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    view: View,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(view.context)) {
        return
    }
    Glide.with(view)
        .load(res)
        .placeholder(placeHolder)
        .apply(
            RequestOptions.bitmapTransform(BlurTransformation(radius.toFloat().dp.toInt(), simpling)))
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(view: View, placeHolder: Drawable, res: Any?, radius: Int, simpling: Int) {
    if (!isInLifecycle(view.context)) {
        return
    }
    Glide.with(view)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    fragment: Fragment,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    fragment: Fragment,
    placeHolder: Drawable,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(fragment: Fragment, res: Any?, radius: Int, simpling: Int) {
    if (!isInLifecycle(fragment.context)) {
        return
    }
    Glide.with(fragment)
        .load(res)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(),
                    simpling)
            )
        )
        .into(this)
}


/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(context: Context, res: Any?, radius: Int, simpling: Int) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    activity: Activity,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(activity)) {
        return
    }
    Glide.with(activity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    activity: Activity,
    placeHolder: Drawable,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(activity)) {
        return
    }
    Glide.with(activity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 * @param colorFilter 顔色濾鏡
 */
fun ImageView.blur(
    context: Context,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
    colorFilter: Int,
) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling),
                ColorFilterTransformation(colorFilter)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 * @param colorFilter 顔色濾鏡
 */
fun ImageView.familyBlur(
    context: Context,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
    colorFilter: Int,
) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .error(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling),
                ColorFilterTransformation(colorFilter)
            )
        )
        .into(this)
}


/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 * @param colorFilter 顔色濾鏡
 */
fun ImageView.screenBlur(
    context: Context,
    res: Any?,
    radius: Int,
    simpling: Int,
    colorFilter: Int,
) {

    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(R.color.color_screen_bg)
        .error(R.color.color_screen_bg)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling),
                ColorFilterTransformation(colorFilter)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    context: Context,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView虚化
 * @param radius 圆角角度，单位dp
 */
fun ImageView.falsification(
    context: Context,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .apply(
            RequestOptions.bitmapTransform(BlurTransformation(radius, simpling))
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(context: Context, placeHolder: Drawable, res: Any?, radius: Int, simpling: Int) {
    if (!isInLifecycle(context)) {
        return
    }
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    fragmentActivity: FragmentActivity,
    @IdRes @DrawableRes placeHolder: Int,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(fragmentActivity)) {
        return
    }
    Glide.with(fragmentActivity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView毛玻璃
 * @param radius 圆角角度，单位dp
 */
fun ImageView.blur(
    fragmentActivity: FragmentActivity,
    placeHolder: Drawable,
    res: Any?,
    radius: Int,
    simpling: Int,
) {
    if (!isInLifecycle(fragmentActivity)) {
        return
    }
    Glide.with(fragmentActivity)
        .load(res)
        .placeholder(placeHolder)
        .transform(
            MultiTransformation(
                CenterCrop(),
                BlurTransformation(radius.toFloat().dp.toInt(), simpling)
            )
        )
        .into(this)
}

/**
 * ImageView zgl
 */
fun ImageView.load(res: Any?, width: Int?, height: Int?) {
    if (!isInLifecycle(this.context)) {
        return
    }
    Glide.with(this)
        .load(res)
        .override(width ?: com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, height ?: com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
        .into(this)
}

/**
 * ImageView zgl
 */
fun ImageView.load(res: Any?, placeHolder: Int = -1) {
    if (!isInLifecycle(this.context)) {
        return
    }
    Glide.with(this)
        .load(res)
        .placeholder(placeHolder)
        .into(this)
}

/**
 * ImageView zgl
 */
fun ImageView.loadGray(res: Any?, placeHolder: Int = -1) {
    if (!isInLifecycle(this.context)) {
        return
    }
    Glide.with(this)
        .load(res)
        .placeholder(placeHolder)
        .transform(GrayscaleTransformation())
        .into(this)
}

/**
 * desc:加载webp
 * date:2022/1/21 15:48
 * author:zhang.gl
 */
fun ImageView.webp(context: Context, res: Any?, placeHolder: Drawable? = null) {
    if (!isInLifecycle(this.context)) {
        return
    }
    val circleCrop: Transformation<Bitmap> = CircleCrop()
    Glide.with(context)
        .load(res)
        .placeholder(placeHolder)
        .optionalTransform(circleCrop)
        .optionalTransform(WebpDrawable::class.java, WebpDrawableTransformation(circleCrop))
        .into(this)
}

/**
 * desc:加载webp
 * date:2022/1/21 15:48
 * author:zhang.gl
 */
fun ImageView.webp(fragmentActivity: FragmentActivity, res: Any?, placeHolder: Drawable? = null) {
    if (!isInLifecycle(this.context)) {
        return
    }
    val circleCrop: Transformation<Bitmap> = CircleCrop()
    Glide.with(fragmentActivity)
        .load(res)
        .placeholder(placeHolder)
        .optionalTransform(circleCrop)
        .optionalTransform(WebpDrawable::class.java, WebpDrawableTransformation(circleCrop))
        .into(this)
}

/**
 * desc:加载webp
 * date:2022/1/21 15:48
 * author:zhang.gl
 */
fun ImageView.webp(fragment: Fragment, res: Any?, placeHolder: Drawable? = null) {
    if (!isInLifecycle(this.context)) {
        return
    }
    val circleCrop: Transformation<Bitmap> = CircleCrop()
    Glide.with(fragment)
        .load(res)
        .placeholder(placeHolder)
        .optionalTransform(circleCrop)
        .optionalTransform(WebpDrawable::class.java, WebpDrawableTransformation(circleCrop))
        .into(this)
}

/**
 * desc:加载webp
 * date:2022/1/21 15:48
 * author:zhang.gl
 */
fun ImageView.webp(activity: Activity, res: Any?, placeHolder: Drawable? = null) {
    if (!isInLifecycle(this.context)) {
        return
    }
    val circleCrop: Transformation<Bitmap> = CircleCrop()
    Glide.with(activity)
        .load(res)
        .placeholder(placeHolder)
        .optionalTransform(circleCrop)
        .optionalTransform(WebpDrawable::class.java, WebpDrawableTransformation(circleCrop))
        .into(this)
}

fun isInLifecycle(context: Context?) = when(context) {
    is Activity -> {
        !(context.isDestroyed || context.isFinishing)
    }
    else -> {
        true
    }
}