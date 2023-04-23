package com.example.booknet.ui.flow.home.router

interface HomeRouterListener {
    fun navigate(action: HomeRouterAction)
}

object HomeRouter {
    var listener: HomeRouterListener? = null

    fun navigate(action: HomeRouterAction) {
        listener?.navigate(action)
    }
}