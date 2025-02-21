plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // add RxJava2 library
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    // add com.google.common.collect library
    implementation("com.google.guava:guava:30.1-jre")
}

tasks.test {
    useJUnitPlatform()
}