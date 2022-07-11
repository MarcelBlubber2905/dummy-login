package com.dummy.login.security

import com.vaadin.flow.component.UI
import com.vaadin.flow.server.VaadinServletRequest
import com.vaadin.flow.server.VaadinSession
import javax.inject.Singleton
import javax.servlet.ServletException

@Singleton
class SecurityUtils {

    private val LOGOUT_SUCCESS_URL = "/"

    fun isAuthenticated(): Boolean {
        val request: VaadinServletRequest = VaadinServletRequest.getCurrent()
        return request.userPrincipal != null
    }

    fun authenticate(username: String?, password: String?): Boolean {
        val request = VaadinServletRequest.getCurrent() ?: return false

        return try {
            request.login(username, password)
            true
        } catch (e: ServletException) {
            // login exception handle code omitted
            false
        }
    }

    fun logout() {
        VaadinSession.getCurrent().session.invalidate()
        UI.getCurrent().page.setLocation(LOGOUT_SUCCESS_URL)
    }
}
