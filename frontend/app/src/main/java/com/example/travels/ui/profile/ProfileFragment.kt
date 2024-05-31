package com.example.travels.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travels.databinding.FragmentProfileBinding
import com.example.travels.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment(/*R.layout.fragment_profile*/) {

    private var viewBinding: FragmentProfileBinding? = null

    //    private val viewModel: ProfileViewModel by viewModels()
//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileBinding.inflate(inflater)
        return viewBinding?.root
    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        observe()
//        initListeners()
//        viewModel.loadCurrentUserProfile()
//    }
//
//    private fun observe() {
//        with(viewModel) {
//            user.observe {
//                if (it != null) {
//                    showData(it)
//                }
//            }
//            error.observe {
//                if (it != null) {
//                    showToast(it.name)
//                }
//            }
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun showData(user: UserModel) {
//        viewBinding?.run {
//            with(this) {
//                nameTv.text = "${user.firstname} ${user.lastname}"
//                linkTv.text = ""
//            }
//        }
//    }

    private fun initListeners() {
        viewBinding?.run {
            with(this) {
                favLl.setOnClickListener {
//                    router.navigateTo(Screens.Favorites())
                }
                editProfileLl.setOnClickListener {
//                    router.navigateTo(Screens.EditProfile())
                }
                routesLl.setOnClickListener {
//                    router.navigateTo(Screens.MyRoutes())
                }
                settingsLl.setOnClickListener {
//                    router.navigateTo(Screens.Settings())
                }
                exitLl.setOnClickListener {
                }
                profileLl.setOnClickListener {
                }
            }
        }
    }

    companion object {
        const val TAG = "PROFILE_FRAGMENT"
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }
}
