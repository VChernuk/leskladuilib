package com.kophe.leskladuilib

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import com.kophe.leskladlib.repository.common.TaskStatus
import com.kophe.leskladlib.repository.common.TaskStatus.StatusInProgress
import com.kophe.leskladuilib.SpinnerExtensions.setSpinnerEntries
import com.kophe.leskladuilib.SpinnerExtensions.setSpinnerItemSelectedListener
import com.kophe.leskladuilib.SpinnerExtensions.setSpinnerValue

class CustomBindings {

    @BindingAdapter("loadingVisibility")
    fun View.setRequestStatus(requestStatus: TaskStatus?) {
        this.visibility = if (requestStatus is StatusInProgress) VISIBLE else GONE
    }

    @BindingAdapter("entries")
    fun Spinner.setEntries(entries: List<Any>?) {
        setSpinnerEntries(entries)
    }

    @BindingAdapter("onItemSelected")
    fun Spinner.setOnItemSelectedListener(itemSelectedListener: ItemSelectedListener?) {
        setSpinnerItemSelectedListener(itemSelectedListener)
    }

    @BindingAdapter("newValue")
    fun Spinner.setNewValue(newValue: Any?) {
        setSpinnerValue(newValue)
    }

}
