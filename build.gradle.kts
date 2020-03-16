//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version ("1.3.70")
//    id("org.jetbrains.kotlin.jvm") version ("1.3.70")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    "implementation"(kotlin("stdlib-jdk8"))
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