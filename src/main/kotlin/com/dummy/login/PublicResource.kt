package com.dummy.login

import com.dummy.login.db.model.Member
import io.quarkus.elytron.security.common.BcryptUtil
import io.quarkus.security.Authenticated
import javax.annotation.security.PermitAll
import javax.annotation.security.RolesAllowed
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.SecurityContext


@Path("/api")
class PublicResource {
    @GET
    @Path("/public")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    fun publicResource(): String {
//        Member(
//            username = "admin",
//            password = BcryptUtil.bcryptHash("admin"),
//            role = "admin"
//        ).persistAndFlush()
//        Member(
//            username = "user",
//            password = BcryptUtil.bcryptHash("user"),
//            role = "user"
//        ).persistAndFlush()
        return "public"
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    fun adminResource(): String? {
        return "admin"
    }

    @GET
    @Authenticated
    @Path("/me")
    fun me(@Context securityContext: SecurityContext): String? {
        return securityContext.userPrincipal.name
    }
}