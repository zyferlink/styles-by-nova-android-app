<h1 align="center" > Managing Dependencies with Version Catalogs </h1>

<br>

Using Gradle version catalogs makes managing dependencies and plugins easier when you have multiple modules. Instead of hardcoding dependency names and versions in individual build files and updating each entry whenever you need to upgrade a dependency, you can create a central version catalog of dependencies that various modules can reference in a type-safe way with Android Studio assistance.


- **Benefits for Developers :**  Ability to make libraries and plugins generic across multiple applications or modules in a project.

<!-- ------------ 1.1 Version Catalog Structure ------------ -->
#
## 1.1 Version Catalog Structure

<br>

- **Sections:**
  1. Versions
  2. Libraries
  3. Plugins
- **Libraries Section:** Contains group, name, and version reference (`version.ref`) for each library.
- **Plugins Section:** Contains ID and version reference (`version.ref`) for each plugin.

> [!Important]  
> After initializing libraries and plugins in the `libs.versions.toml` file, you must sync the project to generate the dependencies in Android Studio.

<br>

```toml
[versions]
# initialize the versions number of the libraries and plugins

[libraries]
# initialize the libraries group, name and version number

[plugins]
# initialize the plugins id, and version number

```


### Version Catalogs with Kotlin

- The **group** section refers to the first part before the colon (`:`)
    - For example, in `androidx.activity:activity-compose`, the group section is `androidx.activity`.
- The **name** section refers to the second part after the colon. In the example `androidx.activity:activity-compose`, the name section is `activity-compose`.
- The **version** section refers to the library version number that follows.

Example:  
`androidx.activity:activity-compose:1.3.1`

- Group: `androidx.activity`
- Name: `activity-compose`
- Version: `1.3.1`

#

> libs.versions.toml

```toml
[version]
activityCompose = "1.3.1"

[libraries]
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
```
#

> Application Gradle | build.gradle.kts

```java
dependencies {
    implementation(libs.androidx.activity.compose)
}
```

<br>

<!-- ------------ 1.2 Version Catalog Plugins ------------ -->

#
## 1.2 Version Catalog Plugins

<br>

**( OLD way )**
> Application Gradle | app /-> build.gradle.kts 

```java
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

```
#
**( NEW way )**
> libs.versions.toml

```toml
[version]
agp = "8.5.2"
kotlin = "2.0.20"

# Here is the library section

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
jetbrains-kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }

```

#

> Application Gradle | app /-> build.gradle.kts

```java
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}
```

<br>

<br>

<br>

<!-- ------------ 1.3 Top Libraries and Plugins for Project Development ------------ -->

#
## 1.3 Top Libraries and Plugins for Project Development

<br>

> libs.versions.toml

```toml
[versions]
agp = "8.5.2"
kotlin = "2.0.20"
coreKtx = "1.13.1"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
lifecycleRuntimeKtx = "2.8.6"
activityCompose = "1.9.2"
composeVersion = "1.7.3"
composeHiltNavigationVersion = "1.2.0"
composeNavigationVersion = "2.8.2"
uiComposeVersion = "1.7.3"
animationComposeVersion = "1.7.3"
foundationComposeVersion = "1.7.3"
composeBom = "2024.09.03"
roomVersion = "2.6.1"
kspVersion = "2.0.20-1.0.25"
retrofitVersion = "2.11.0"
okHttpVersion = "4.12.0"
coilVersion = "2.7.0"
coroutineVersion = "1.9.0"
materialVersion = "1.12.0"
hiltVersion = "2.52"
hiltCompilerVersion = "1.2.0"
swipeRefreshLayoutVersion = "1.1.0"
gsonVersion = "2.11.0"
paletteVersion = "1.0.0"
splashscreen = "1.0.1"


[libraries]
# Architecture
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-swipe-refresh-layout = { group = "androidx.swiperefreshlayout", name = "swiperefreshlayout", version.ref = "swipeRefreshLayoutVersion" }
# Compose
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui", version.ref = "uiComposeVersion" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-navigate-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "composeNavigationVersion" }
androidx-hilt-compose = { group = "androidx.hilt", name = "hilt-navigation-compose", version.ref = "composeHiltNavigationVersion" }
androidx-compose-runtime = { group = "androidx.compose.runtime", name = "runtime", version.ref = "composeVersion" }
androidx-compose-runtime-livedata = { group = "androidx.compose.runtime", name = "runtime-livedata", version.ref = "composeVersion" }
androidx-lifecycle-viewmodel-compose = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-compose", version.ref = "lifecycleRuntimeKtx" }
androidx-animation = { group = "androidx.compose.animation", name = "animation", version.ref = "animationComposeVersion" }
androidx-foundation = { group = "androidx.compose.foundation", name = "foundation", version.ref = "foundationComposeVersion" }
# Room Database
androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "roomVersion" }
androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "roomVersion" }
androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "roomVersion" }
# Retrofit
retrofit = { group = "com.squareup.retrofit2", name = "retrofit", version.ref = "retrofitVersion" }
retrofit-gson = { group = "com.squareup.retrofit2", name = "converter-gson", version.ref = "retrofitVersion" }
# OkHttp
okHttp = { group = "com.squareup.okhttp3", name = "okhttp", version.ref = "okHttpVersion" }
# Gson
gson = { group = "com.google.code.gson", name = "gson", version.ref = "gsonVersion" }
# Coil
coil = { group = "io.coil-kt", name = "coil-compose", version.ref = "coilVersion" }
# Coroutine
coroutine-core = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version.ref = "coroutineVersion" }
coroutine-android = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-android", version.ref = "coroutineVersion" }
# Material
material = { group = "com.google.android.material", name = "material", version.ref = "materialVersion" }
# Hilt
dagger-android = { group = "com.google.dagger", name = "hilt-android", version.ref = "hiltVersion" }
dagger-compiler = { group = "com.google.dagger", name = "hilt-compiler", version.ref = "hiltVersion" }
hilt-compiler = { group = "androidx.hilt", name = "hilt-compiler", version.ref = "hiltCompilerVersion" }
# Palette
androidx-palette-ktx = { group = "androidx.palette", name = "palette-ktx", version.ref = "paletteVersion" }
# Unit Test
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest", version.ref = "composeVersion" }
androidx-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-core-splashscreen = { group = "androidx.core", name = "core-splashscreen", version.ref = "splashscreen" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
jetbrains-kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
ksp = { id = "com.google.devtools.ksp", version.ref = "kspVersion" }
hilt-android = { id = "com.google.dagger.hilt.android", version.ref = "hiltVersion" }
compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }

```

[ View Current Project's Version Catalogs  --> ](../../gradle/libs.versions.toml)

<br>

<br>

> Application Gradle | app /-> build.gradle.kts

```java
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.compose.compiler)
}
```

```java
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
    //Unit Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
```

<br>

<br>

> Top Level Gradle | build.gradle.kts

```java
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.compose.compiler) apply false
}
```

---
<br>

<kbd>[&nbsp; ◄ &nbsp;  BACK TO Project &nbsp;&nbsp;&nbsp;](../../README.md#-project-documents) </kbd>

<br>

---
