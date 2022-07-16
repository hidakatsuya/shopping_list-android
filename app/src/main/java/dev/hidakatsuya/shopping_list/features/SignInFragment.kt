package dev.hidakatsuya.shopping_list.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.tasks.Task
import dev.hidakatsuya.shopping_list.BuildConfig
import dev.hidakatsuya.shopping_list.R
import dev.hidakatsuya.shopping_list.util.GoogleSignInActivityResultContract
import dev.hidakatsuya.shopping_list.util.MOBILE_SIGN_IN_URL
import dev.hotwire.turbo.fragments.TurboFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination
import dev.hotwire.turbo.visit.TurboVisitAction
import dev.hotwire.turbo.visit.TurboVisitOptions

@TurboNavGraphDestination("turbo://fragment/sign_in")
class SignInFragment : TurboFragment() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private val signInLauncher = registerForActivityResult(
        GoogleSignInActivityResultContract()
    ) { res ->
        this.handleSignInResult(res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
            .requestEmail()
            .requestProfile()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        view.findViewById<SignInButton>(R.id.sign_in_button).setOnClickListener { handleSignInButtonClick() }
        return view
    }

    private fun handleSignInButtonClick() {
        val intent = googleSignInClient.signInIntent
        signInLauncher.launch(intent)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        val account = completedTask.result
        navigate(
            "$MOBILE_SIGN_IN_URL?id_token=${account.idToken}",
            TurboVisitOptions(action = TurboVisitAction.REPLACE)
        )
    }
}