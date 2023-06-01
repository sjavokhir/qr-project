plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.mapsplatform.secrets)
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Compose application framework"
        homepage = "empty"
        ios.deploymentTarget = "11.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.datetime)
                implementation(libs.koin.core)
                implementation(libs.sqlDelight.extensions)
                implementation(libs.multiplatformSettings)
                implementation(libs.voyager.navigator)
                implementation(libs.voyager.bottomSheetNavigator)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.camera.camera2)
                implementation(libs.androidx.camera.lifecycle)
                implementation(libs.androidx.camera.view)
                implementation(libs.compose.uitooling)
                implementation(libs.compose.activity)
                implementation(libs.compose.accompanist.permissions)
                implementation(libs.compose.maps)
                implementation(libs.google.material)
                implementation(libs.google.playservices.maps)
                implementation(libs.google.playservices.location)
                implementation(libs.google.mlkit.barcode)
                implementation(libs.google.zxing.embedded)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.koin.android)
                implementation(libs.sqlDelight.driver.android)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.sqlDelight.driver.native)
            }
        }

        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "uz.qrscanner.qrcodescanner.barcodereader.barcodescanner"
    compileSdk = 33

    defaultConfig {
        applicationId = "uz.qrscanner.qrcodescanner.barcodereader.barcodescanner"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
    }

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources.excludes.add("META-INF/**")
    }
}

sqldelight {
  databases {
    create("AppDatabase") {
      // Database configuration here.
      // https://cashapp.github.io/sqldelight
      packageName.set("uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.db")
    }
  }
}

secrets {
    defaultPropertiesFileName = "default.local.properties"
    propertiesFileName = "local.properties"
}
