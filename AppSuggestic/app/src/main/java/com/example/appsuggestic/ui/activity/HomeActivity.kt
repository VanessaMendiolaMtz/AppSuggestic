package com.example.appsuggestic.ui.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsuggestic.R
import com.example.appsuggestic.databinding.ActivityMainBinding
import com.example.appsuggestic.di.AndroidSuggesticsApplication
import com.example.appsuggestic.domain.Calendar
import com.example.appsuggestic.ui.viewModel.HomeViewModel
import com.example.appsuggestic.ui.adapter.CalendarAdapter
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), CalendarAdapter.OnActionsListener {

    private lateinit var binding : ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    lateinit var progresDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as AndroidSuggesticsApplication).getComponent().inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progresDialog = ProgressDialog(this)
        progresDialog.setCancelable(false)
        progresDialog.setTitle(getString(R.string.txt_title_progress_dialog))
        progresDialog.setMessage(getString(R.string.txt_subtitle_progress_dialog))

        setUpObservables()
    }
    private fun setUpObservables(){
        viewModel.getDaysCalendar()
        viewModel.alert.observe(this) { calendar->
            binding.rvCalendar.layoutManager =
                LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
            binding.rvCalendar.adapter = CalendarAdapter(calendar,this)
        }

        viewModel.showError.observe(this) {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }

        viewModel.showProgressDialog.observe(this) { showDialog ->
            if (showDialog) {
                progresDialog.show()
            } else {
                progresDialog.dismiss()
            }
        }
    }

    override fun onOrderSelected(calendar: Calendar?) {
        AlertDialog.Builder(this)
            .setTitle(calendar?.title)
            .setMessage(calendar?.subtitle)
            .setPositiveButton(getString(R.string.txt_alert_dialog))
            { dialog, which ->
                dialog.dismiss()
            }.show()
    }
}