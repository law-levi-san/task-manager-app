# Task Manager App Setup Guide

This guide outlines the complete setup for running the **Task Manager App**, including database configuration, backend setup, API testing, and frontend setup.

---

## 🛠 Tools Required

1. **Database**: MongoDB Compass & MongoDB Atlas  
2. **Backend**: IntelliJ Community Edition  
3. **API Testing**: Postman  
4. **Frontend**: Visual Studio Code  
5. **Mobile App Testing**: Expo Go  

---

## 📁 Clone the Repository

Open a command line terminal and run:

```bash
git clone https://github.com/law-levi-san/task-manager-app.git
```

---

## 🗄️ Database Setup (MongoDB Atlas + Compass)

1. Download [MongoDB Compass](https://www.mongodb.com/try/download/compass)
2. Visit [MongoDB Atlas](https://www.mongodb.com/products/platform/atlas-database) and create an account
3. Go to the **Network Access** tab on the left and click **Add Current IP Address**
4. Create a **Cluster**
5. Choose **Connect** → **Compass** → Select **"I have MongoDB Compass"**
6. Copy the **Connection String**
7. Open MongoDB Compass → **New Connection**
8. Paste the copied string → Save and **Connect**

---

## ⚙️ Backend Setup (Spring Boot)

1. Open **IntelliJ Community Edition**
2. Navigate to:  
   ```
   C:/
   └── Users
       └── your-username/Dell/etc
           └── task-manager-app
               └── backend
   ```
3. Open the project folder
4. Paste the MongoDB connection string in `application.properties`
5. Locate `WorkShopBEApplication.java` and click **Run**

Your backend server should now be running.

---

## 📬 Testing APIs with Postman

1. Open **Postman**
2. Create a **New Collection**
3. Add the following requests:

### a) Add Task  
- **Method**: POST  
- **URL**: `http://localhost:8080/addTask`  
- **Body** (raw JSON):
  ```json
  {
    "taskName": "Example Task",
    "description": "This is a test task"
  }
  ```

### b) Get All Tasks  
- **Method**: GET  
- **URL**: `http://localhost:8080/getAllTasks`

### c) Get Task by ID  
- **Method**: GET  
- **URL**: `http://localhost:8080/getTasksById?id=<your-task-id>`

### d) Mark Task as Completed  
- **Method**: PUT  
- **URL**: `http://localhost:8080/markTaskAsCompleted/<your-task-id>`

---

## 🎨 Frontend Setup (React Native with Expo)

1. Open Terminal / Command Prompt / PowerShell
2. Run:
   ```bash
   cd task-manager-app
   cd frontend
   code .
   ```

3. Open a new terminal in VS Code and run:
   ```bash
   npm install
   npm start
   ```

> If `npm` is not recognized, install the latest version of Node.js from [https://nodejs.org](https://nodejs.org)

4. A QR code should be generated in the terminal or browser.  
   Scan the QR code using **Expo Go** on your mobile device.

---

## ✅ You're all set!

Feel free to fork or contribute to the [repository](https://github.com/law-levi-san/task-manager-app.git).
