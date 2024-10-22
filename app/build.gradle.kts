plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "novalogics.android.styles"
    compileSdk = 34

    defaultConfig {
        applicationId = "novalogics.android.styles"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Architecture
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.swipe.refresh.layout)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    //Compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigate.compose)
    implementation(libs.androidx.hilt.compose)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.animation)
    implementation(libs.androidx.foundation)
    //Room Database
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    //OkHttp
    implementation(libs.okHttp)
    //Gson
    implementation(libs.gson)
    //Coil
    implementation(libs.coil)
    //Coroutines
    implementation(libs.coroutine.core)
    implementation(libs.coroutine.android)
    //Material
    implementation(libs.material)
    //Hilt
    implementation(libs.dagger.android)
    ksp(libs.dagger.compiler)
    ksp(libs.hilt.compiler)
    //Palette
    implementation(libs.androidx.palette.ktx)
    //Splashscreen
    implementation(libs.androidx.core.splashscreen)
    //Accompanist Pager Indicators
    implementation(libs.accompanist.pager.indicators)

    //Unit Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
