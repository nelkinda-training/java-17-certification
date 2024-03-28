plugins {
    id("java")
}

group = "com.nelkinda.training"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    runtimeOnly("com.h2database:h2:2.2.224")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.3.3")
    runtimeOnly("org.postgresql:postgresql:42.7.3")

}

tasks.test {
    useJUnitPlatform()
}
