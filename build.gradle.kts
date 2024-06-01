import org.gradle.kotlin.dsl.support.kotlinCompilerOptions
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
    maven("https://maven.tryformation.com/releases") {
        content {
            includeGroup("com.jillesvangurp")
            includeGroup("com.github.jillesvangurp")
            includeGroup("com.tryformation")
            includeGroup("com.tryformation.fritz2")
        }
    }
}

kotlin {
    js(IR) {
        browser {
            testTask {
                useMocha()
            }
        }
    }.binaries.executable()

    sourceSets {

        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("dev.fritz2:core:_")
                implementation("dev.fritz2:headless:_")
                implementation("org.jetbrains:markdown:_")
                implementation(KotlinX.serialization.json)
                implementation(Koin.core)
                implementation("com.jillesvangurp:kotlinx-serialization-extensions:_")

            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("io.kotest:kotest-assertions-core:_")
            }
        }


        jsMain {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation(npm("tailwindcss", "_"))
                implementation(npm("@tailwindcss/forms", "_"))

                // fluent-js
                implementation("com.tryformation:fluent-kotlin:_")

                // webpack
                implementation(devNpm("postcss", "_"))
                implementation(devNpm("postcss-loader", "_"))
                implementation(devNpm("autoprefixer", "_"))
                implementation(devNpm("css-loader", "_"))
                implementation(devNpm("style-loader", "_"))
                implementation(devNpm("cssnano", "_"))
            }
        }

        jsTest {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        targets.all {
            compilations.all {
                kotlinOptions.freeCompilerArgs
            }
        }
        all {
            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            compilerOptions {
                // FIXME fugly syntax?!
                freeCompilerArgs.set(freeCompilerArgs.get() + "-Xcontext-receivers")

            }
            languageSettings.apply {
                optIn("kotlin.ExperimentalStdlibApi")
                optIn("kotlin.RequiresOptIn")
            }
        }
    }
}




