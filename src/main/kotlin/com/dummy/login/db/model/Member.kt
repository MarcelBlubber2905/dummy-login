package com.dummy.login.db.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import io.quarkus.security.jpa.Password
import io.quarkus.security.jpa.Roles
import io.quarkus.security.jpa.UserDefinition
import io.quarkus.security.jpa.Username
import java.time.ZonedDateTime
import javax.persistence.Entity

@Entity
@UserDefinition
class Member(
    @Username
    var username: String,
    @Password
    var password: String,
    @Roles
    var role: String? = null
): PanacheEntity()