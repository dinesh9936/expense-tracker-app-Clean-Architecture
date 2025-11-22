# 💰 Expense Tracker App

A modern **Expense Tracking** Android application built using **Clean Architecture**, **Jetpack Compose**, **Room**, **Hilt**, **Coroutines**, and **Flow**.  
This project is designed to be scalable, testable, and production-level — perfect for learning real-world Android development.

---

## 🚀 Features

- ➕ Add expense  
- ✏️ Edit expense (optional)  
- 🗑 Delete expense  
- 📅 Monthly filtering  
- 📊 Insights with Pie + Bar charts  
- 🔄 Real-time updates (Flow)  
- ⚡ Offline-first with Room  
- 🎨 Jetpack Compose UI  
- 🧱 Clean Architecture (MVVM + UseCases + Repository)  
- 🌙 Dark mode support  

---

## 🏛️ Architecture

The app follows **Clean Architecture**:

com.yourname.expensetracker
│
├── data
│ ├── local
│ │ ├── database
│ │ ├── dao
│ │ └── entity
│ ├── repository
│ │ └── impl
│ └── mappers
│
├── domain
│ ├── model
│ ├── repository
│ └── usecase
│
├── presentation
│ ├── home
│ ├── addexpense
│ ├── insights
│ ├── components
│ └── navigation
│
├── di
└── utils



---

## 🧪 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Coroutines**
- **StateFlow**
- **Room Database**
- **Hilt Dependency Injection**
- **Material 3**
- **MVVM Architecture**
- **Clean Architecture**
- **Navigation Compose**

---

## 💾 Database (Room)

Entity example:

```kotlin
@Entity(tableName = "expenses")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val amount: Double,
    val category: String,
    val date: Long
)
