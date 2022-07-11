package com.dummy.login.views;

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import io.quarkus.security.Authenticated


@Route(value = "/")
@Authenticated
class DashboardView: VerticalLayout() {

    init {
       add(Text("Hello authenticated"))
    }
}
