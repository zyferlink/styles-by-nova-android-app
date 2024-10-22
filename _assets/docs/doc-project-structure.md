<h1 align="center" > 
Jetpack Compose Project Structure Guide  
</h1>

<br>

Organizing a Jetpack Compose project helps make it easier to read, maintain, and expand. Since Compose is a declarative UI framework, its structure is slightly different from traditional Android projects.  
Here's a simplified guide with examples:

<br>
<!-- ------------ Project Structure Example ------------ -->

<div align="center" > 
📂 represents a folder &ensp; | &ensp; 📄 represents a file  
</div>

---

com.example.android  
├── 📂 app  
│ &ensp; &ensp; ├── 📂 android  
│ &ensp; &ensp; └── 📂 host  
│       
├── 📂 data  
│ &ensp; &ensp; ├── 📂 network  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 service  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 client  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 model  
│ &ensp; &ensp; │ &ensp; &ensp; └── 📂 error  
│ &ensp; &ensp; │  
│ &ensp; &ensp; ├── 📂 db  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 entity  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 dao  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 database  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 converter  
│ &ensp; &ensp; │ &ensp; &ensp; └── 📂 migration  
│ &ensp; &ensp; │  
│ &ensp; &ensp; ├── 📂 pref  
│ &ensp; &ensp; │    
│ &ensp; &ensp; └── 📂 repository  
│ &ensp; &ensp;  
├── 📂 domain    
│ &ensp; &ensp; ├── 📂 model  
│ &ensp; &ensp; └── 📂 repository  
│  
├── 📂 di  
│ &ensp; &ensp; ├── 📂 modules  
│ &ensp; &ensp; ├── 📂 scopes  
│ &ensp; &ensp; └── 📂 components  
│  
├── 📂 presentation  
│ &ensp; &ensp; ├── 📂 ui  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 screen1  
│ &ensp; &ensp; │ &ensp; &ensp; │ &ensp; &ensp; ├── 📄 Screen1.kt  
│ &ensp; &ensp; │ &ensp; &ensp; │ &ensp; &ensp; ├── 📄 ViewModel1.kt  
│ &ensp; &ensp; │ &ensp; &ensp; │ &ensp; &ensp; └── 📂 components  
│ &ensp; &ensp; │ &ensp; &ensp; │ &ensp; &ensp; &ensp; &ensp; &ensp;  ├── 📄 Component1.kt  
│ &ensp; &ensp; │ &ensp; &ensp; │  &ensp; &ensp; &ensp; &ensp; &ensp; └── 📄 Component2.kt  
│ &ensp; &ensp; │ &ensp; &ensp; │  
│ &ensp; &ensp; │ &ensp; &ensp; └── 📂 screen2  
│ &ensp; &ensp; │ &ensp; &ensp; &ensp; &ensp; &ensp; ├── 📄 Screen2.kt  
│ &ensp; &ensp; │ &ensp; &ensp; &ensp; &ensp; &ensp; ├── 📄 ViewModel2.kt  
│ &ensp; &ensp; │ &ensp; &ensp; &ensp; &ensp; &ensp; └── 📂 components  
│ &ensp; &ensp; │ &ensp; &ensp; &ensp; &ensp; &ensp;&ensp; &ensp; &ensp; &ensp;  ├── 📄 Component1.kt  
│ &ensp; &ensp; │ &ensp; &ensp; &ensp; &ensp; &ensp;&ensp; &ensp; &ensp; &ensp;  └── 📄 Component2.kt  
│ &ensp; &ensp; │  
│ &ensp; &ensp; ├── 📂 common  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📂 shared components  
│ &ensp; &ensp; │ &ensp; &ensp; └── 📂 shared viewmodels  
│ &ensp; &ensp; │     
│ &ensp; &ensp; └── 📂 theme  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📄 color  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📄 shape  
│ &ensp; &ensp; │ &ensp; &ensp; ├── 📄 theme  
│ &ensp; &ensp; │ &ensp; &ensp; └── 📄 type  
│ &ensp; &ensp; │  
│ &ensp; &ensp; └── 📂 navigation  
│         
├── 📂 notification  
├── 📂 workers  
└── 📂 utils

---

## 1. App Layer
Responsible for the main entry point and setup for the application.

**Example:**
- `app/android` → Contains the `Application` class and custom components.
- `app/host` → Contains the `MainActivity` or main entry point of the app.

---
<br>

## 2. Data Layer
Handles all data operations (API calls, database, preferences).

#### Subfolders: network

- **`data/network`** → Manages API communication.
    - `service/` → Contains API interfaces (e.g., Retrofit services).
    - `client/` → Sets up network clients (like Retrofit).
    - `model/` → Holds data models for API responses.
    - `error/` → Handles API errors (e.g., custom exceptions).

  **Example:**
    - `data/network/service/WeatherService.kt` → Defines weather API calls.

#
#### Subfolders: db

- **`data/db`** → Manages local database with Room.
    - `entity/` → Defines database tables (Room entities).
    - `dao/` → Contains DAO interfaces for database operations.
    - `database/` → Sets up the Room database class.
    - `converter/` → Handles type conversions for custom data types.
    - `migration/` → Manages database schema updates.

  **Example:**
    - `data/db/entity/User.kt` → Defines user table.

#
#### Subfolders: pref

- **`data/pref`** → Manages key-value storage (e.g., SharedPreferences).

  **Example:**
    - `data/pref/UserPreferences.kt` → Handles user preferences.

#
#### Subfolders: repository

- **`data/repository`** → Acts as the single source of truth for data from APIs, DB, or preferences.

  **Example:**
    - `data/repository/UserRepository.kt` → Combines user data from API and local DB.

---
<br>


## 3. Domain Layer
Contains business logic and domain-specific data.

#### Subfolders: domain

- **`domain/model`** → Holds core business models.
- **`domain/repository`** → Defines repository interfaces.

#

**Example:**
- `domain/model/User.kt` → Core user model for the business logic.

---
<br>

## 4. Dependency Injection (DI)
Sets up dependency injection using Hilt or Dagger.

#### Subfolders: di

- **`di/modules`** → Contains modules for providing dependencies.
- **`di/scopes`** → Manages custom scopes if needed.
- **`di/components`** → Sets up DI components.

#

**Example:**
- `di/modules/NetworkModule.kt` → Provides network-related dependencies like Retrofit.

---
<br>

## 5. Presentation Layer
Manages the UI and related logic using Jetpack Compose.

#### Subfolders: ui
- **`presentation/ui`** → Organized by screens or features.
    - `screen1/` → Contains the UI and ViewModel for the first screen.
        - `Screen1.kt` → The UI for Screen 1.
        - `ViewModel1.kt` → Manages Screen 1's logic.
        - `components/` → Reusable UI components for Screen 1.

  **Example:**
    - `presentation/ui/screen1/Screen1.kt` → Compose UI for Screen 1.
    - `presentation/ui/screen1/ViewModel1.kt` → Logic for Screen 1.

#
#### Subfolders: common

- **`presentation/common`** → Shared UI components and ViewModels across multiple screens.
    - `shared components/` → Reusable UI components for any screen.
    - `shared viewmodels/` → Common ViewModels for multiple screens.

  **Example:**
    - `presentation/common/sharedcomponents/Button.kt` → Custom button used in multiple screens.

#
#### Subfolders: theme

- **`presentation/theme`** → Manages Compose themes (e.g., colors, shapes, typography).

  **Example:**
    - `presentation/theme/Color.kt` → Defines app colors.

#
#### Subfolders: navigation

- **`presentation/navigation`** → Manages navigation between screens using Jetpack Navigation.

---
<br>

## 6. Notification Layer
Manages app notifications.

**Example:**
- `notification/NotificationHelper.kt` → Handles push notifications.

---
<br>

## 7. Workers Layer
Contains background tasks using WorkManager.

**Example:**
- `workers/SyncWorker.kt` → Syncs data in the background.

---
<br>

## 8. Utils Layer
Holds utility functions and helper classes.

**Example:**
- `utils/DateUtils.kt` → Common functions for date formatting.

---
<br>

<kbd>[&nbsp; ◄ &nbsp;  BACK TO Project &nbsp;&nbsp;&nbsp;](../../README.md#-project-documents) </kbd>

<br>

---
