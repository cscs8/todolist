plugins {
    kotlin("jvm") version ("1.3.70")
    id("org.jlleitschuh.gradle.ktlint") version ("9.2.1")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    "implementation"(kotlin("stdlib-jdk8"))
    "implementation"("com.sparkjava:spark-core:2.9.1")
    "implementation"("org.slf4j:slf4j-simple:1.7.30")
    "implementation"("com.fasterxml.jackson.core:jackson-databind:2.10.3")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
}

tasks {
    //    withType<KotlinCompile> {
//        kotlinOptions {
//            jvmTarget = "1.8"
//        }
////        compileTestKotlin {
////            kotlinOptions.jvmTarget = "1.8"
////        }
//    }
    withType<Wrapper> {
        gradleVersion = "6.2.2"
    }
}