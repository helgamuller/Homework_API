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
    testImplementation("io.rest-assured:rest-assured:5.5.0")
    implementation("com.codeborne:selenide:7.2.1")
    implementation ("org.slf4j:slf4j-api:2.0.0")  // Библиотека SLF4J
    implementation ("org.slf4j:slf4j-simple:2.0.0")  // Простая реализация для логирования
    implementation ("org.seleniumhq.selenium:selenium-devtools-v118:4.14.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:4.5.1")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
    testCompileOnly("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.32")


}

tasks.test {
    useJUnitPlatform()
}