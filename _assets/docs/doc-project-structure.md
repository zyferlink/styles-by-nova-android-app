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
