package com.example.mvvmstarterproject.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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
        handleSignUPButton()
        handleBackButton()
        addFormValidation()
    }

    private fun addFormValidation() {
        nameField.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                validateName()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        emailField.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                validateEmail()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        passwordField.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                validatePassword()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun handleBackButton() {
        ic_back_button.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun handleSignUPButton() {
        signUpBtn.setOnClickListener {
            if (validateName() && validateEmail() && validatePassword() && validateImageSelection()){
                findNavController().navigate(R.id.action_signUpFragment_to_sendMessageFragment)
            }
        }
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

    private fun validateEmail(): Boolean {
        if (emailField.text.toString().trim().isEmpty()) {
            email_ET.error = getString(R.string.empty_email_validation)
            requestFocus(emailField)
            return false
        } else {
            val emailValue: String = emailField.text.toString()
            val isValid =
                Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()
            if (!isValid) {
                email_ET.error = getString(R.string.not_valid_email_msg)
                requestFocus(emailField)
                return false
            } else {
                email_ET.isErrorEnabled = false
            }
        }
        return true
    }

    private fun validatePassword(): Boolean {
        when {
            passwordField.text.toString().trim().isEmpty() -> {
                password_ET.error = getString(R.string.empty_password_validation)
                requestFocus(passwordField)
                return false
            }
            passwordField.text.toString().length < 6 -> {
                password_ET.error = getString(R.string.password_validation)
                requestFocus(passwordField)
                return false
            }
            else -> {
                password_ET.isErrorEnabled = false
            }
        }
        return true
    }

    private fun validateName(): Boolean {
        if (nameField.text.toString().trim().isEmpty()) {
            full_name_ET.error = getString(R.string.empty_name_validation)
            requestFocus(nameField)
            return false
        } else{
            full_name_ET.isErrorEnabled = false
        }
        return true
    }

    private fun requestFocus(view: View) {
        if (view.requestFocus()) {
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    private fun validateImageSelection(): Boolean{
        if (viewModel.selectedImagePath.isBlank()){
            Toast.makeText(requireContext(), getString(R.string.select_image_validation), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}

const val SELECT_IMAGE_REQUEST_CODE = 123