package com.dummy.login.security

import com.dummy.login.views.LoginView
import com.vaadin.flow.server.ServiceInitEvent
import com.vaadin.flow.server.UIInitEvent
import com.vaadin.flow.server.VaadinServiceInitListener
import com.vaadin.flow.server.auth.ViewAccessChecker


class ViewAccessCheckerInitializer : VaadinServiceInitListener {
    private val viewAccessChecker: ViewAccessChecker = ViewAccessChecker()

    init {
        viewAccessChecker.setLoginView(LoginView::class.java)
    }

    override fun serviceInit(serviceInitEvent: ServiceInitEvent) {
        serviceInitEvent.source.addUIInitListener { uiInitEvent: UIInitEvent ->
            uiInitEvent.ui.addBeforeEnterListener(viewAccessChecker)
        }
    }
}