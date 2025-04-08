plugins {
    id("java")
}

group = "net.peng1104"
version = "1.0.0"

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    mavenCentral()
}

dependencies {
    compileOnly(libs.bundles.spigot)
}