package com.example.appsuggestic.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appsuggestic.data.repository.CalendarRepository
import com.example.appsuggestic.domain.Calendar
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private var getCalendarRepository: CalendarRepository) : ViewModel(){

    var disposable = CompositeDisposable()

    private val _alert = MutableLiveData<ArrayList<Calendar>>()
    val alert : LiveData<ArrayList<Calendar>> get() = _alert

    private val _showError = MutableLiveData<String>()
    val showError : LiveData<String> get() = _showError

    private val _showProgressDialog = MutableLiveData<Boolean>()
    val showProgressDialog : LiveData<Boolean> get() = _showProgressDialog

    fun getDaysCalendar(){
        _showProgressDialog.postValue(true)
        disposable.add(getCalendarRepository.getCalendar()
            .subscribe({
                _showProgressDialog.postValue(false)
                _alert.postValue(it)
            },{
                _showProgressDialog.postValue(false)
                _showError.postValue("Error loading, try again")
            }))
    }
}