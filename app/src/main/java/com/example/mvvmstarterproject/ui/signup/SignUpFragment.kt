package com.example.mvvmstarterproject.ui.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mvvmstarterproject.R
import com.example.mvvmstarterproject.base.BaseFragment
import com.opensooq.supernova.gligar.GligarPicker
import kotlinx.android.synthetic.main.sign_up_fragment.*

class SignUpFragment : BaseFragment<SignUpViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handleImageSelection()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            SELECT_IMAGE_REQUEST_CODE -> {
                val selectedImagePath = data?.extras?.getStringArray(GligarPicker.IMAGES_RESULT)?.get(0)
                if (selectedImagePath?.isNotEmpty() == true){
                    viewModel.selectedImagePath = selectedImagePath
                    setUserImage(selectedImagePath)
                }
            }
        }
    }

    private fun setUserImage(imagePath:String){
        Glide.with(this).load(imagePath).into(profile_image)
    }

    private fun handleImageSelection() {
        selectImage.setOnClickListener {
            GligarPicker()
                .requestCode(SELECT_IMAGE_REQUEST_CODE)
                .withFragment(this)
                .limit(1)
                .disableCamera(false)
                .cameraDirect(false)
                .show()
        }
    }
}

const val SELECT_IMAGE_REQUEST_CODE = 123