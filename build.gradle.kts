plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:4.3.1") // for kotest framework
}
