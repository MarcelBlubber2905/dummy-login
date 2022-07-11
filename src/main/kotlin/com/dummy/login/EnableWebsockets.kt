package com.dummy.login

import javax.websocket.Endpoint
import javax.websocket.server.ServerApplicationConfig
import javax.websocket.server.ServerEndpointConfig

class EnableWebsockets : ServerApplicationConfig {
    override fun getEndpointConfigs(endpointClasses: Set<Class<out Endpoint?>>): Set<ServerEndpointConfig> {
        return HashSet()
    }

    override fun getAnnotatedEndpointClasses(scanned: Set<Class<*>?>?): Set<Class<*>> {
        return HashSet()
    }
}
