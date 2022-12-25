package `in`.dazzlingapps.mvpandroiddemo.login

interface LoginCallbacks {

    interface View {
        fun showLoginSuccess()
        fun showLoginFailed()
        fun showProgress()
    }

    interface Presenter {
        fun loginButtonClicked(userName: String, password: String)
    }

    interface Model {
        interface OnFinishedListener {
            fun loginSuccess(string: String)
            fun loginFailed(string: String)
        }

        fun logIn(username: String, password: String, onFinishedListener: OnFinishedListener)
    }
}