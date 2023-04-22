package com.example.booknet.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Added to MutableLiveData ability for passing any count of data any time.
 * MutableLiveData docs - "If you called this method (postValue) multiple times before a main thread executed a posted task, only the last value would be dispatched."
 */
open class SingleLifeEvent<T> : MutableLiveData<T>() {

    private val isPending = AtomicBoolean(false)
    private val values: Queue<T> = LinkedList()

    override fun observe(owner: LifecycleOwner, observer: androidx.lifecycle.Observer<in T>) {
//        if (hasActiveObservers()) {
//            throw IllegalAccessException("Multiple observers registered, but we can use only one.")
//        }
        super.observe(owner) { t: T ->
            if (isPending.compareAndSet(true, false)) {
                observer.onChanged(t)
                if (values.isNotEmpty()) {
                    pollValue()
                }
            }
        }
    }

    override fun postValue(value: T) {
        values.add(value)
        pollValue()
    }

    @MainThread
    override fun setValue(t: T?) {
        isPending.set(true)
        super.setValue(t)
    }

    private fun pollValue() {
        CoroutineScope(Dispatchers.Main).launch { value = values.poll() }
    }
}