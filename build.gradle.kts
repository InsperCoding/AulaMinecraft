plugins {
    id("java")
}

group = "net.peng1104"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    implementation("com.google.code.gson:gson:2.12.1") // Dentro do Jar

    compileOnly(libs.spigot) // Fora do Jar

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}