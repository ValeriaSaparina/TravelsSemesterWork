package com.example.travels.ui.createRoute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travels.R
import com.example.travels.databinding.FragmentCreateRouteBinding
import com.example.travels.ui.MainActivity
import com.example.travels.ui.base.BaseFragment
import com.example.travels.ui.places.model.PlaceUiModel
import com.example.travels.ui.routes.RoutesFragment
import com.example.travels.utils.validate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateRouteFragment : BaseFragment() {

    private var viewBinding: FragmentCreateRouteBinding? = null
    private val viewModel: CreateRouteViewModel by viewModels()
    private val placesAdapter = RoutePlacesAdapter(::onIcClicked, ::onItemClicked)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCreateRouteBinding.inflate(inflater)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initRv()
        initObservers()
        initData()
    }

    private fun initData() {
        viewBinding?.toolbar?.toolbar?.title = getString(R.string.create_route)
    }

    private fun initObservers() {
        with(viewModel) {
            error.observe {
                showInputError(it)
            }
            success.observe {
                if (it == true) {
//                    router.backTo(Screens.Routes())
                    with(requireActivity() as MainActivity) {
                        setItemSelected(1, true)
                        select(RoutesFragment.TAG)
                    }
                }
            }
            favPlaces.observe {
                if (it != null) {
                    placesAdapter.submitList(it)
                }
            }
        }
    }

    private fun initRv() {
        viewBinding?.placesRv?.run {
            adapter = placesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun initListeners() {
        viewBinding?.run {
            createBtn.setOnClickListener {
                viewModel.createRoute(
                    nameEt.text.toString(),
                    descEt.text.toString(),
                )
            }
            toolbar.toolbar.setNavigationOnClickListener {
//                router.backTo(Screens.Routes())
                with(requireActivity() as MainActivity) {
                    setItemSelected(1, true)
                    select(RoutesFragment.TAG)
                }
            }

            nameEt.validate(getString(R.string.fill_text)) { text -> text.isNotEmpty() }
            descEt.validate(getString(R.string.fill_text)) { text -> text.isNotEmpty() }
        }
        this.id
    }

    private fun onIcClicked(item: PlaceUiModel) {
        viewModel.deleteFromList(item)
    }

    private fun onItemClicked(item: PlaceUiModel) {
        viewModel.onPlaceCliced(item)
    }

    companion object {
        const val TAG: String = "CREATE ROUTE FRAGMENT"
    }

}