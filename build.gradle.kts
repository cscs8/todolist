import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version ("1.3.72")
    id("org.jlleitschuh.gradle.ktlint") version ("9.2.1")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    "implementation"("com.sparkjava:spark-core:2.9.1")
    "implementation"("org.slf4j:slf4j-simple:1.7.30")
    "implementation"("com.fasterxml.jackson.core:jackson-databind:2.10.3")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
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
        gradleVersion = "6.4-rc-3"
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}