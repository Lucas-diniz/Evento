package com.lucas.diniz.events

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucas.diniz.databinding.EventFragmentBinding
import com.lucas.diniz.events.adapter.EventAdapter
import com.lucas.diniz.events.dto.Events
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsFragment : Fragment() {

    companion object {
        fun newInstance() = EventsFragment()
    }

    private lateinit var mContext: Context
    private lateinit var _binding: EventFragmentBinding
    private val binding get() = _binding
    private val viewModel: EventsViewModel by viewModel()
    private val eventAdapter: EventAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mContext = container!!.context;
        _binding = EventFragmentBinding.inflate(inflater, container, false)

        initListEvents()
        initRecycleView()
        initObservables()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = view.context
    }

    private fun initListEvents() {
        viewModel.listEvents()
    }

    private fun initRecycleView() {
        _binding.eventRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }

    private fun initObservables() {
        viewModel.listEvents.observe(this, {
            if (it != null) {
                buildListListEvents(it)
                _binding.progressBar.visibility = GONE
            } else {
                _binding.progressBar.visibility = GONE
                _binding.eventRecyclerView.visibility = GONE
                _binding.errorMessage.visibility = VISIBLE
            }
        })
    }

    private fun buildListListEvents(listEvents: List<Events>) {
        eventAdapter.listEvent = listEvents
        eventAdapter.mContext = mContext
        _binding.eventRecyclerView.layoutManager = LinearLayoutManager(mContext)
        _binding.eventRecyclerView.adapter = eventAdapter
    }
}