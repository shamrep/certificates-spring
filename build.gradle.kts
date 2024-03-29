plugins {
    id("java")
//    java
    war
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "org.certspring"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.assertj:assertj-core:3.25.3")

    implementation("org.springframework.data:spring-data-jdbc:3.2.3")

    implementation("com.h2database:h2:2.2.224")

    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")


    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}