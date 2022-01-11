package com.lucas.diniz.events.features.checkIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lucas.diniz.R
import com.lucas.diniz.databinding.EventCheckInBottomsheetBinding
import com.lucas.diniz.events.features.checkIn.data.EventCheckInRequest
import com.lucas.diniz.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel


class EventCheckInFragment : BottomSheetDialogFragment() {

    private lateinit var _binding: EventCheckInBottomsheetBinding
    private val binding get() = _binding
    private val viewModel: EventCheckInViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EventCheckInBottomsheetBinding.inflate(inflater, container, false)

        arguments?.getInt("id")?.let {
            initListeners(it)

        }
        initObservers()

        return binding.root
    }

    private fun initObservers(){
        viewModel.checkIn.observe(this, {
            if(it != null){
                showToast(context!!,getString(R.string.checkin_response_success))
            }else{
                showToast(context!!,getString(R.string.checkin_response_error))
            }
            dismiss()
        })
    }

    private fun initListeners(id: Int) {
        _binding.checkIn.setOnClickListener {
            if (verifyNome() && verifyEmail()) {
                setLoadOn()
                viewModel.registerCheckIn(
                    EventCheckInRequest(
                        eventId = id,
                        name = _binding.name.text.toString(),
                        email = _binding.email.text.toString()
                    )
                )
            } else {
               showToast(context!!, getString(R.string.checkin_empty))
            }
        }
    }

    private fun setLoadOn(){
        _binding.form.visibility = GONE
        _binding.progressBar.visibility = VISIBLE
    }

    private fun verifyNome(): Boolean {
        return _binding.name.text.toString().isNotEmpty()
    }

    private fun verifyEmail(): Boolean {
        return _binding.email.text.toString().isNotEmpty()
    }

}