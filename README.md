# 📱 Experiment 12 – Access Web Services Using HTTP Requests

## Implement an Android Application to Access Web Services Using HTTP Requests

---

## 👨‍💻 Author

**Name:** Manikandan P  
**USN:** 25MCAR0186  
**Subject:** Mobile Application Development Lab

---

## 📖 Experiment Description

This experiment demonstrates accessing web services in Android using **HTTP Requests** with Kotlin and XML.

The application connects to a remote REST API using `HttpURLConnection` and sends an HTTP GET request to retrieve data from the server.

The application uses the JSONPlaceholder API to fetch sample post information in JSON format. The retrieved response is processed using the `JSONObject` class and displayed on the application screen.

Network operations are performed in a background thread to avoid blocking the main UI thread. The application also handles server errors and connection failures.

### Scenario

The application simulates a **Student Web Service Data Retrieval System**.

```text
             Android HTTP Request App
                       ↓
                Display Home Screen
                       ↓
               Tap Fetch Data Button
                       ↓
              Establish HTTP Connection
                       ↓
                Send HTTP GET Request
                       ↓
              Connect to Remote REST API
                       ↓
               Receive JSON Response
                       ↓
              Check HTTP Response Code
                       ↓
              Parse JSON Response Data
                       ↓
             Display Retrieved Information
                       ↓
              Show ID, Title and Body
```

---

## 🧠 Concept / Technology Used

### HTTP Requests and REST API Integration

HTTP (Hypertext Transfer Protocol) is used for communication between Android applications and remote web servers. REST APIs allow applications to retrieve or exchange data using HTTP methods.

This application uses the following concepts:

* **HTTP Protocol** – Enables communication between the Android application and remote servers.
* **HTTP GET Request** – Retrieves information from a remote web service.
* **REST API** – Provides an interface for accessing server-side resources.
* **HttpURLConnection** – Establishes an HTTP connection and sends requests to the server.
* **URL** – Specifies the web service endpoint.
* **JSON (JavaScript Object Notation)** – Represents the data received from the server.
* **JSONObject** – Parses JSON response data and extracts individual values.
* **Background Thread** – Performs network operations without blocking the main UI thread.
* **runOnUiThread()** – Updates the user interface with the retrieved server response.
* **Internet Permission** – Allows the application to access internet services.
* **Kotlin** – Handles HTTP requests, JSON parsing, and application logic.
* **XML** – Defines the user interface layout.
* **Android Studio** – Used for application development, execution, and testing.

---

## 🚀 Features

* 📱 Attractive HTTP Request application interface
* 🌐 Connects to a remote REST API
* 📡 Sends HTTP GET requests
* 🔗 Uses JSONPlaceholder web service
* 📥 Retrieves JSON response data from the server
* 📄 Parses JSON using JSONObject
* 🆔 Displays Post ID
* 📝 Displays Post Title
* 📃 Displays Post Description
* ⚡ Performs network operations in a background thread
* 🔄 Updates the UI with the server response
* ⚠️ Handles connection errors and server responses
* 💬 Displays error messages using Toast
* 🎨 Simple and clean user interface
* 🎓 Displays student name and USN

---

# 📂 Project Structure

```text
app/
│
├── manifests/
│   └── AndroidManifest.xml
│
├── java/
│   └── com/
│       └── project/
│           └── exp12/
│               └── MainActivity.kt
│
├── res/
│   │
│   ├── layout/
│   │   └── activity_main.xml
│   │
│   └── values/
│       ├── colors.xml
│       ├── strings.xml
│       └── themes.xml
│
└── Gradle Scripts
```

---

# 🎨 User Interface

The application contains the following interface elements:

* Application heading – HTTP Request Demo
* Fetch Data from Server button
* Server response display area
* Post ID information
* Post Title information
* Post Description information
* Loading message while fetching data
* Error message for connection failures
* Light background with purple-blue styling
* Scrollable response display area

---

# 🔑 Permission Used

The application requires the following permission in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

The Internet permission allows the application to establish connections with remote web services and retrieve data from the internet.

Unlike sensitive permissions such as contacts or location, Internet permission does not require a runtime permission dialog.

---


# 🧪 Test Cases

## Test Case 1 – Application Launch and Home Screen

### Objective

To verify that the application launches successfully and displays the HTTP Request Demo interface.

### Input

1. Launch the Experiment 12 application.
2. Observe the application home screen.
3. Verify that the Fetch Data from Server button is displayed.

### Expected Result

The application should launch successfully and display the heading, fetch button, and server response area.

### Actual Result

The application launches successfully and displays the HTTP Request Demo interface.

### Status

✅ **Passed**

### Screenshot – Application Home Screen

<img width="400" height="660" alt="1000182838" src="https://github.com/user-attachments/assets/09f88a08-4ba8-4ed6-ada5-3e29b20deb7d" />


---

## 🧪 Test Case 2 – Send HTTP GET Request and Retrieve Data

### Objective

To verify that the application sends an HTTP GET request to the REST API and retrieves JSON data successfully.

### Input

1. Open the application.
2. Tap the **Fetch Data from Server** button.
3. Wait for the server response.

### Expected Result

The application should connect to the JSONPlaceholder API, send an HTTP GET request, and receive a successful JSON response from the server.

### Actual Result

The application successfully connects to the remote REST API and retrieves the JSON response.

### Status

✅ **Passed**

### Screenshot – HTTP Request Execution

<img width="440" height="660" alt="1000182839" src="https://github.com/user-attachments/assets/1a99e367-27e1-4967-b3f4-780478ccf98a" />


---

## 🧪 Test Case 3 – Display Retrieved JSON Response

### Objective

To verify that the application parses the received JSON response and displays the Post ID, Title, and Description.

### Input

1. Tap the Fetch Data from Server button.
2. Wait until the JSON response is received.
3. Observe the displayed information.

### Expected Result

The application should parse the JSON response using `JSONObject` and display the Post ID, Title, and Description on the screen.

### Actual Result

The application successfully displays the retrieved Post ID, Title, and Description.

### Status

✅ **Passed**

### Screenshot – Retrieved Server Data

<img width="400" height="660" alt="1000182841" src="https://github.com/user-attachments/assets/dbbc3fa0-289c-407b-a0b8-245bb87aa2c7" />


---
