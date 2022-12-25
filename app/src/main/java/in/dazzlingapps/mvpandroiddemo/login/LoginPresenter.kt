package `in`.dazzlingapps.mvpandroiddemo.login

import android.content.Context

class LoginPresenter(context: Context, private val view: LoginCallbacks.View) :
    LoginCallbacks.Presenter, LoginCallbacks.Model.OnFinishedListener {

    private val model: LoginCallbacks.Model = LoginModel(context)

    override fun loginButtonClicked(userName: String, password: String) {
        // Send the request to Model
        model.logIn(userName, password, this)

        // Send the update back to View
        view.showProgress()
    }

    // Return result to View
    override fun loginSuccess(string: String) {
        view.showLoginSuccess()
    }

    // Return result to View
    override fun loginFailed(string: String) {
        view.showLoginFailed()
    }
}