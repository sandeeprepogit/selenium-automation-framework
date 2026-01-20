
# Java QA & Utilities Workspace

A Maven-based Java workspace that brings together:

- **Selenium WebDriver** examples for UI automation
- **Playwright for Java** quickstart (headless/headed browser automation)
- **Database utilities** for MongoDB and relational DBs (JDBC)
- **DSA practice**: easy/basic logic-building problems

> This README is generated from the folder structure you shared. Update the sections to match your exact class names/methods if they change.

---

## 📁 Project Structure

```
.mvn/
src/
└─ main/
   ├─ java/
   │  ├─ DBUtils/
   │  │  ├─ MogoDB/          # MongoDB helper utilities (e.g., connect, ping, basic CRUD)
   │  │  └─ SQLconnection/   # JDBC connection helpers for RDBMS (MySQL/Postgres/etc.)
   │  │
   │  ├─ javaDSA.logicBuildingProblems/
   │  │  ├─ BasicProblems/   # Basic DSA/logic problems
   │  │  └─ EasyProblems/    # Easy DSA/logic problems
   │  │
   │  ├─ org.example/
   │  │  └─ Main             # Application entry point / scratch runner
   │  │
   │  ├─ playWright/
   │  │  └─ PlayWright       # Playwright for Java demo/test runner
   │  │
   │  └─ seleniumWebDriver/
   │     └─ LaunchBrowser    # Minimal Selenium WebDriver example
   │
   └─ resources/             # Config files, test data, log configs
```

> Note: The folder name appears as `MogoDB` in your structure. If this is a typo, rename to `MongoDB` or keep as-is and update package references accordingly.

---

## 🧰 Prerequisites

- **Java**: JDK 11+ (JDK 17 recommended)
- **Maven**: 3.8+
- **Browsers**:
  - For **Selenium**: Any modern Chrome/Edge/Firefox. Selenium 4+ can auto-manage drivers via Selenium Manager.
  - For **Playwright**: Install Playwright browsers once (see below).
- **Databases (optional)**:
  - MongoDB Atlas/local instance for Mongo demos
  - A relational DB (MySQL/PostgreSQL/etc.) for JDBC demos

---

## 🚀 Quick Start

### 1) Clone & Build
```bash
mvn -v
java -version
mvn clean compile
```

### 2) (Optional) Configure environment variables
Create a `.env` or set env vars in your shell/IDE Run Configurations:
```bash
# MongoDB
export MONGO_URI="mongodb+srv://<user>:<pass>@<cluster>.mongodb.net/?retryWrites=true&w=majority"
# or for local
# export MONGO_URI="mongodb://localhost:27017"

# JDBC
export DB_URL="jdbc:postgresql://localhost:5432/appdb"   # or mysql/oracle/sqlserver
export DB_USER="appuser"
export DB_PASS="secret"
```

### 3) Install Playwright browsers (one-time)
Any one of the following works depending on your setup:
```bash
# Option A: Use Maven property
mvn -Dplaywright.cli.install=true test

# Option B: Run the CLI via exec plugin style (if configured)
# mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

### 4) Run the Main class
Add/ensure the Maven Exec Plugin is configured, then run:
```bash
mvn -q -DskipTests exec:java -Dexec.mainClass=org.example.Main
```
> You can also run any class directly from your IDE.

---

## 🗂️ Package-by-Package Guide

### `org.example.Main`
A simple entry point to call into any demo you want to run (e.g., call Selenium/Playwright/DB utils). Customize it to orchestrate local experiments.

### `DBUtils/MogoDB`
Utilities to connect to MongoDB and run basic operations.

### `DBUtils/SQLconnection`
Simple JDBC helpers for relational databases.

### `seleniumWebDriver/LaunchBrowser`
Minimal Selenium example to launch a browser and open a page.

### `javaDSA.logicBuildingProblems`
Folders for **Basic** and **Easy** problems. Each class should be small and runnable with a `main` method and/or unit tests. Keep input/output simple for quick verification.


## 🧪 How to Run Examples

- **Run Selenium demo**: Run the `LaunchBrowser` class (or your actual class) from IDE or via `exec:java`.
- **Run Playwright demo**: Run the `PlayWright` class; set `headless` true/false in code.
- **Run Mongo/JDBC demo**: Ensure env vars are set, then run the respective DB utils or a small `main` wrapper.
- **Run DSA problems**: Run individual classes with `main`, or add unit tests.

---

## 🛠️ Troubleshooting

- **Driver not found (Selenium)**: Use Selenium 4+; it auto-manages drivers. If behind a proxy, configure proxy env settings.
- **Playwright fails to launch**: Ensure browsers installed; re-run `mvn -Dplaywright.cli.install=true test`.
- **Mongo connection timeout**: Check `MONGO_URI`, network allowlist (Atlas), or local `mongod` running.
- **JDBC auth/URL issues**: Verify `DB_URL` format and driver on classpath; test connection with a simple `SELECT 1`.

---

## 📌 Notes & Next Steps

- Consider renaming `MogoDB` → `MongoDB` for clarity.
- Add unit tests (JUnit/TestNG) for DSA problems and utilities.
- Introduce a simple `Config` class to read from `src/main/resources`.
- CI-friendly runs can be wired via Maven profiles.

---

## 📄 License
Add your chosen license here (e.g., MIT/Apache-2.0) or keep the project private.

