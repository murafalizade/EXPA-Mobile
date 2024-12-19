package org.aiesec.login

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.core.net.toUri
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
        private const val THIRD_FRAGMENT_NAV_DEEPLINK = "app://org.aiesec/home"

    }

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById<Button>(R.id.continue_button).setOnClickListener{
            findNavController().navigate(
                NavDeepLinkRequest.Builder
                    .fromUri(THIRD_FRAGMENT_NAV_DEEPLINK.toUri())
                    .build()
            )

        }
    }
}