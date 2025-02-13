package com.kophe.leskladuilib

import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.Keep
import com.kophe.leskladlib.loggingTag

fun View.fadeIn(onFinish: () -> Unit) {
    fade(0.0f, 1.0f) {
        visibility = View.VISIBLE
        onFinish.invoke()
    }
}

fun View.fadeOut(onFinish: (() -> Unit)? = null) {
    fade(1.0f, 0.0f) {
        visibility = View.INVISIBLE
        onFinish?.invoke()
    }
}

fun View.fade(from: Float, to: Float, onFinish: () -> Unit) {
//    if (BuildConfig.FLAVOR == "fakeServer") {
//        onFinish.invoke()
//        return
//    }
    val alpha = AlphaAnimation(from, to)
    alpha.duration = 50
    alpha.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {
            Log.d(loggingTag(), "on animation repeat")
            //nothing to do here
        }

        override fun onAnimationEnd(animation: Animation?) {
            Log.d(loggingTag(), "on animation end")
            onFinish.invoke()
        }

        override fun onAnimationStart(animation: Animation?) {
            Log.d(loggingTag(), "on animation start")
            //nothing to do here
        }
    })
    startAnimation(alpha)
}

object SpinnerExtensions {

    fun Spinner.setSpinnerEntries(entries: List<Any>?) {
        if (entries == null) return
        val arrayAdapter = ArrayAdapter(
            context, R.layout.item_custom_spinner, entries
        )
        arrayAdapter.setDropDownViewResource(R.layout.item_custom_spinner)
        adapter = arrayAdapter
    }

    fun Spinner.setSpinnerItemSelectedListener(listener: ItemSelectedListener?) {
        onItemSelectedListener = if (listener == null) {
            null
        } else {
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>, view: View?, position: Int, id: Long
                ) {
                    if (view != null && tag != position) listener.onItemSelected(
                        parent.getItemAtPosition(
                            position
                        )
                    )
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
    }

    fun Spinner.setSpinnerValue(value: Any?) {
        if (adapter == null) return
        val position = (adapter as ArrayAdapter<Any?>).getPosition(value)
        setSelection(position, false)
        tag = position
    }

    fun Spinner.getSpinnerValue(): Any? = selectedItem


}

@Keep
interface ItemSelectedListener {
    fun onItemSelected(item: Any?)
}