package com.example.dagger2withmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger2withmvvm.util.Constants.TAG
import javax.inject.Inject

class MainViewModel2 @Inject constructor(random: Randomize) : ViewModel() {
    init {
        random.doAction()
    }
}

class Randomize @Inject constructor() {
    fun doAction() {
        Log.d(TAG, "doAction: call ")
    }
}
