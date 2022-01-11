package com.lucas.diniz.events.features.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucas.diniz.databinding.EventListFragmentBinding
import com.lucas.diniz.events.EventViewModel
import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.events.features.list.adapter.EventListAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class EventsListFragment : Fragment() {

    private lateinit var mContext: Context
    private lateinit var _binding: EventListFragmentBinding
    private val binding get() = _binding
    private lateinit var eventViewModel: EventViewModel
    private val listViewModel: EventsListViewModel by viewModel()
    private val eventListAdapter: EventListAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mContext = container!!.context;
        _binding = EventListFragmentBinding.inflate(inflater, container, false)

        initListEvents()
        initRecycleView()
        initObservables()
        initViewModel()
        initListeners()

        return binding.root
    }

    private fun initListeners() {
        eventListAdapter.setOnItemClickListener(object : EventListAdapter.OnItemClickListener {
            override fun onItemClickCheckIn(id: Int) {
                eventViewModel.setUpCheckIn(id)
            }

            override fun onItemClickInfo(id: Int) {
                eventViewModel.setUpDetail(id)
            }
        })

        _binding.swipeRefresh.setOnRefreshListener {
            initListEvents()
        }
    }

    private fun initViewModel() {
        eventViewModel = ViewModelProviders.of(requireActivity()).get(EventViewModel::class.java)
    }

    private fun initListEvents() {
        listViewModel.listEvents()
    }

    private fun initRecycleView() {
        _binding.eventRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }

    private fun initObservables() {
        listViewModel.listEvents.observe(this, {
            if (it != null) {
                buildListListEvents(it)
                _binding.progressBar.visibility = GONE
                _binding.swipeRefresh.isRefreshing = false
            } else {
                _binding.progressBar.visibility = GONE
                _binding.eventRecyclerView.visibility = GONE
                _binding.errorMessage.visibility = VISIBLE
            }
        })
    }

    private fun buildListListEvents(listEvents: List<Events>) {
        eventListAdapter.listEvent = listEvents
        _binding.eventRecyclerView.layoutManager = LinearLayoutManager(mContext)
        _binding.eventRecyclerView.adapter = eventListAdapter
    }
}