package `in`.dazzlingapps.mvpandroiddemo.login

import android.content.Context
import android.os.Handler

class LoginModel(context: Context) : LoginCallbacks.Model {

    // todo create Retrofit's object here
    // todo create Repository's object here

    override fun logIn(
        username: String,
        password: String,
        onFinishedListener: LoginCallbacks.Model.OnFinishedListener
    ) {
        // todo Network call here

        // Simulating dummy network call
        Handler().postDelayed(object : Runnable {
            override fun run() {
                // todo Save logged in user details in local database

                // Return result to Presenter
                onFinishedListener.loginSuccess("Success..")
            }
        }, 1000)
    }
}