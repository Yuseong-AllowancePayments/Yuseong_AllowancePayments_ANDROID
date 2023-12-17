package com.example.yuseongallowancepaymentsandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.yuseongallowancepaymentsandroid.database.ApplicationDatabase
import com.example.yuseongallowancepaymentsandroid.entity.HonorApplication
import com.example.yuseongallowancepaymentsandroid.repository.ExcelRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExcelViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllHonorData: LiveData<List<HonorApplication>>
    private val repository: ExcelRepository

    init {
        val dao = ApplicationDatabase.getInstance(application).applicationDao()
        repository = ExcelRepository(dao)
        readAllHonorData = repository.readHonorData
    }

    fun insertHonor() {
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {

            }
        }
    }
}