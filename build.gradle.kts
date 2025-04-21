// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val hiltVersion = "2.48"  // Объявляем переменную для версии Hilt

        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        classpath("com.android.tools.build:gradle:7.4.2") // Плагин для Android
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion") // Плагин для Hilt
    }
}
