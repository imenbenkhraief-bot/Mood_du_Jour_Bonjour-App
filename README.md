# 😊 Mood du Jour Bonjour

> A minimalist Android app for tracking your daily well-being — one emoji at a time.

**Mood du Jour Bonjour** lets you check in on five key wellness indicators every day using a simple, intuitive emoji-based interface. Your data is stored locally via MySQL (XAMPP), giving you a private, persistent history of how you've been doing.

---

## ✨ Features

- **Daily check-in form** — rate Sleep, Hydration, Nutrition, Physical Activity, and Social Energy using emoji buttons (😊 Happy · 😐 Neutral · ☹️ Low)
- **Global Emoji Score** — auto-calculated average displayed as a summary emoji after each submission
- **Wellness Guide** — always-accessible legend explaining each indicator and its scoring criteria
- **History view** — scrollable list of past entries showing date, global emoji, and your personal note
- **Detail & Edit** — tap any history entry to view full scores, edit, or delete it
- **Free-text notes** — attach an optional written comment to any daily entry

---

## 📱 Screenshots

> _Add screenshots of each activity here once the app is running._

---

## 🏗️ Architecture

The app follows a **3-Tier architecture**:

```
┌─────────────────────────────────┐
│         Presentation Layer       │
│  XML Layouts · Java Activities   │
│  (MainActivity, FormActivity…)   │
├─────────────────────────────────┤
│          Business Layer          │
│  Score Logic · HistoryAdapter    │
│  Background Threads (non-block)  │
├─────────────────────────────────┤
│            Data Layer            │
│  MoodDAO · DBConnection (Singleton)│
│  JDBC Connector/J 9.0 · MySQL    │
└─────────────────────────────────┘
```

### Design Patterns Used
| Pattern | Where |
|---|---|
| **Singleton** | `DBConnection` — single shared MySQL connection |
| **DAO** | `MoodDAO` — all SQL queries isolated from UI logic |
| **Adapter** | `HistoryAdapter` — binds database records to ListView rows |
| **Background Thread** | Save/fetch operations run off the main UI thread |

---

## 🗂️ Project Structure

```
app/
├── java/
│   └── com.example.mooddujour/
│       ├── MainActivity.java           # Dashboard / entry point
│       ├── GuideActivity.java          # Wellness guide screen
│       ├── SummaryActivity.java        # Post-save summary
│       ├── FormulaireSaisieActivity.java # Daily check-in form
│       ├── HistoriqueActivity.java     # History list
│       ├── DetailsActivity.java        # Detail / edit / delete
│       ├── db/
│       │   ├── DBConnection.java       # Singleton JDBC connection
│       │   └── MoodDAO.java            # CRUD operations
│       └── adapter/
│           └── HistoryAdapter.java     # ListView adapter
├── res/
│   ├── layout/                         # XML layouts for all activities
│   └── drawable/                       # Emoji and UI assets
└── libs/
    └── mysql-connector-j-9.0.x.jar    # JDBC driver
```

---

## 🗄️ Database Setup

### Requirements
- [XAMPP](https://www.apachefriends.org/) with MySQL running on your local machine

### Steps

1. Start **Apache** and **MySQL** in your XAMPP Control Panel.
2. Open **phpMyAdmin** (`http://localhost/phpmyadmin`).
3. Run the SQL script located at [`database/setup.sql`](database/setup.sql).

This will create the `mdjb_db` database and the `daily_wellnesss` table.

### Schema

```sql
CREATE DATABASE IF NOT EXISTS mdjb_db;
USE mdjb_db;

CREATE TABLE IF NOT EXISTS daily_wellnesss (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    date            DATE         NOT NULL,
    sleep_status    VARCHAR(20),
    water_status    VARCHAR(20),
    food_status     VARCHAR(20),
    activity_status VARCHAR(20),
    energy_status   VARCHAR(20),
    note            TEXT         NULL
);
```

> **Emoji status values:** `"happy"`, `"neutral"`, or `"sad"` — stored as plain strings.

---

## ⚙️ Setup & Run

### Prerequisites
- Android Studio (latest stable)
- JDK 11+
- XAMPP (MySQL)
- Android device or emulator (API 24+)

### Installation

```bash
git clone https://github.com/YOUR_USERNAME/mood-du-jour-bonjour.git
cd mood-du-jour-bonjour
```

1. Open the project in **Android Studio**.
2. Place the JDBC driver (`mysql-connector-j-9.0.x.jar`) in the `app/libs/` folder if not already present.
3. In `DBConnection.java`, update the connection string to match your machine's local IP:
   ```java
   private static final String URL = "jdbc:mysql://YOUR_LOCAL_IP:3306/mdjb_db";
   private static final String USER = "root";
   private static final String PASSWORD = "";
   ```
   > On an emulator, use `10.0.2.2` instead of `localhost`. On a physical device, use your PC's local network IP.
4. Run the database setup script (see [Database Setup](#-database-setup)).
5. Build and run the app on your device or emulator.

---

## 👩‍💻 Team

| Member | Module | Responsibilities |
|---|---|---|
| **Imen Ben Khraief** | Module A — Consultation & Infrastructure | Dashboard, Wellness Guide, Summary, `DBConnection` Singleton, `saveRecord` (INSERT) |
| **Line Chouchane** | Module B — Data Entry & Management | Check-in Form, History, Details/Edit/Delete, `HistoryAdapter`, `getAllRecords` / UPDATE / DELETE in `MoodDAO` |

---

## 🎓 Academic Context

This project was developed as part of the **Mobile Development** module at **École Polytechnique de Sousse**, 2nd year preparatory cycle (TIC), academic year **2025–2026**.

---

## 📄 License

This project is for academic purposes only.
