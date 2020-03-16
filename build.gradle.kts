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