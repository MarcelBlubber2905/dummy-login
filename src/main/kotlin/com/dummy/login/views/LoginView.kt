package com.dummy.login.views;

import com.dummy.login.security.SecurityUtils
import com.vaadin.flow.component.ComponentEventListener
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent
import com.vaadin.flow.component.login.LoginForm
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.BeforeEnterEvent
import com.vaadin.flow.router.BeforeEnterObserver
import com.vaadin.flow.router.Route


@Route(value = "/login")
class LoginView(
    private val securityUtils: SecurityUtils
) : VerticalLayout(), BeforeEnterObserver, ComponentEventListener<LoginEvent?> {
    private val login = LoginForm()

    init {
        addClassName("login-view")
        setSizeFull()
        justifyContentMode = JustifyContentMode.CENTER
        alignItems = Alignment.CENTER
        login.addLoginListener(this)
        add(H1("Test Application"), login)
    }

    override fun beforeEnter(beforeEnterEvent: BeforeEnterEvent) {
        if (beforeEnterEvent.location
                .queryParameters
                .parameters
                .containsKey("error")
        ) {
            login.isError = true
        }
    }

    override fun onComponentEvent(loginEvent: LoginEvent?) {
        val authenticated: Boolean = securityUtils.authenticate(loginEvent?.username, loginEvent?.password)
        if (authenticated) {
            UI.getCurrent().page.setLocation("/")
        } else {
            login.isError = true
        }
    }
}
