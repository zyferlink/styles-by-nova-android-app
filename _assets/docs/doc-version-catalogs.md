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
