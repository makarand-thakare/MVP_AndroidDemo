package `in`.dazzlingapps.mvpandroiddemo.login

import `in`.dazzlingapps.mvpandroiddemo.home.HomeActivity
import `in`.dazzlingapps.mvpandroiddemo.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * NOTE: As this is demo project for MVP,
 * all the standard practices(eg. dependency injection, validations..)
 * are not implemented to emphasis on the implementation
 * */

class LoginActivity : AppCompatActivity(), LoginCallbacks.View {

    lateinit var presenter: LoginCallbacks.Presenter

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        progressBar = findViewById(R.id.progressBar)
        btnLogin = findViewById(R.id.btnLogin)

        presenter = LoginPresenter(this, this)

        btnLogin.setOnClickListener {
            // Send the request to Presenter
            presenter.loginButtonClicked(
                etUsername.text.toString(),
                etPassword.text.toString()
            )
        }
    }

    override fun showProgress() {
        btnLogin.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    // Receive the result
    override fun showLoginSuccess() {
        progressBar.visibility = View.GONE
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    // Receive the result
    override fun showLoginFailed() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
    }
}