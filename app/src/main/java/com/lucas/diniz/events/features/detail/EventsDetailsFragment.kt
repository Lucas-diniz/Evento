package com.lucas.diniz.events.features.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.lucas.diniz.databinding.EventDetailsFragmentBinding
import com.lucas.diniz.events.EventViewModel
import com.lucas.diniz.events.features.list.adapter.EventListAdapter
import com.lucas.diniz.extension.function.toDataFormatted
import com.lucas.diniz.extension.function.toPrice
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsDetailsFragment : Fragment() {

    private lateinit var mContext: Context
    private lateinit var _binding: EventDetailsFragmentBinding
    private val binding get() = _binding
    private lateinit var eventViewModel: EventViewModel
    private val viewModel: EventsDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mContext = container!!.context;
        _binding = EventDetailsFragmentBinding.inflate(inflater, container, false)


        arguments?.getInt("id")?.let {
            initData(it)
            initListeners(it)
        }
        initViewModel()
        initObservers()

        return binding.root
    }

    private fun initListeners(id: Int){
        _binding.backButtonToolbar.setOnClickListener {
            eventViewModel.setUpList()
        }

        _binding.checkIn.setOnClickListener{
            eventViewModel.setUpCheckIn(id)
        }
    }

    private fun initViewModel() {
        eventViewModel = ViewModelProviders.of(requireActivity()).get(EventViewModel::class.java)
    }

    private fun initData(id: Int){
        viewModel.getEventDetail(id)
    }

    private fun initObservers(){
        viewModel.events.observe(this, {
            if(it != null){

                _binding.containerData.visibility = VISIBLE
                _binding.progressBar.visibility = GONE

                Picasso.with(mContext).load(it.image).into(_binding.image)
                _binding.data.text = it.date.toDataFormatted(EventListAdapter.DATA_FORMAT)
                _binding.price.text = it.price.toPrice()
                _binding.tile.text = it.title
                _binding.description.text = it.description
            }else{
                _binding.progressBar.visibility = GONE
                _binding.containerData.visibility = GONE
                _binding.errorMessage.visibility = VISIBLE
            }
        })
    }

}