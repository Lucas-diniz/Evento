package com.lucas.diniz.events.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucas.diniz.databinding.EventDetailsFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsDetailsFragment : Fragment() {

    private lateinit var mContext: Context
    private lateinit var _binding: EventDetailsFragmentBinding
    private val binding get() = _binding

    private val viewModel: EventsDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mContext = container!!.context;
        _binding = EventDetailsFragmentBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = view.context
    }
}