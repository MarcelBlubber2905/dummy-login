import java.time.format.DateTimeFormatter

group = "com.dummy.login.brevets"
version = "0.1"

defaultTasks("build")

repositories {
    mavenCentral()
}

plugins {
    java
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.allopen") version "1.6.20"
    kotlin("plugin.noarg") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.10"
    id("org.jetbrains.dokka") version "1.6.20"
    id("org.ajoberstar.grgit") version "4.1.0"
    id("io.quarkus") version "2.9.0.Final"
    id("com.vaadin") version "23.0.8"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

vaadin {
    pnpmEnable = false
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

noArg {
    annotation("javax.persistence.Entity")
}

dependencies {
    implementation(enforcedPlatform("com.vaadin:vaadin-bom:23.0.8"))
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:2.9.0.Final"))

    // Vaadin
    implementation("com.vaadin:vaadin-core")
    implementation("com.vaadin:vaadin-core-jandex")
    implementation("com.vaadin:vaadin-quarkus")

    // Quarkus
    implementation("io.quarkus:quarkus-websockets")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-undertow")
    implementation("io.quarkus:quarkus-resteasy-reactive")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.smallrye.reactive:mutiny-kotlin")
    implementation("io.quarkus:quarkus-hibernate-orm-panache-kotlin")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("io.quarkus:quarkus-reactive-pg-client")
    implementation("io.quarkus:quarkus-container-image-jib")
    implementation("io.quarkus:quarkus-scheduler")
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-security-jpa")


    // logging
    // currently we are logging through the SLF4J API to SLF4J-Simple. See src/main/resources/simplelogger.properties file for the logger configuration
    implementation("org.slf4j:slf4j-simple:1.7.36")

    //Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    implementation("org.eclipse.rdf4j:rdf4j-repository-sparql:4.0.1")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
            languageVersion = "1.6"
            apiVersion = "1.6"
        }
    }

    compileJava {
        sourceCompatibility = "17"
        targetCompatibility = "17"
        options.encoding = "UTF-8"
    }

    withType<GenerateModuleMetadata>().configureEach {
        suppressedValidationErrors.add("enforced-platform")
    }

    withType<Test> {
        useJUnitPlatform()
    }
}

