package org.softeer_2nd.caArt.views.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.FragmentHomeBinding

class HomeFragment() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.dynamicOptionFloatingButton.setOption(DummyItemFactory.createAdditionalSingleOptionItem()[0])
//        binding.dynamicOptionFloatingButton.setOnMoreIconClickListener{
//            OptionDetailDialog.Builder()
//                .setOptionList(DummyItemFactory.createAdditionalOptionGrouopItem())
//                .build()
//                .show(requireActivity().supportFragmentManager,"")
//        }

        binding.videoHomeBackground.apply {
            setVideoURI(Uri.parse("android.resource://${context.packageName}/${R.raw.home_video}"))
            setOnPreparedListener { mediaPlayer ->
                mediaPlayer.isLooping = true
                start()
            }
        }

        binding.btnMakeMySelf.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCarTrimChoiceFragment())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}