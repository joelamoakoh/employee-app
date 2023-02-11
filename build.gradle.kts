
plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "me.joelamoakoh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation ("org.slf4j:slf4j-simple:1.7.36")
    implementation ("io.github.microutils:kotlin-logging:2.1.23")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
