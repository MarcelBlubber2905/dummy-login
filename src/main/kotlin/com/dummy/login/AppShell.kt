package com.dummy.login;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme

/**
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@PWA(name = "dummy-app", shortName = "dummy-app")
@Theme("starter-theme")
class AppShell: AppShellConfigurator