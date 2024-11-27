# Smart House Management System

[Click to Watch Demo Video](https://fhdoprod-my.sharepoint.com/:v:/g/personal/amir_pakdel001_stud_fh-dortmund_de/EakbVsEf1lRKg2pF1ShJqpgB3aRBl4bHBujx0VG53h9_YQ)


The Smart House Management System is a Java-based console application that provides an intuitive interface for managing batteries, smart objects, and system logs in a smart home environment. It allows users to efficiently manage energy sources, monitor device states, and track system events with ease.

## Role Distribution

### Hadis Delbord 7222043
**Simulation of the Energy Sources**
- Energy source manager
- Battery manager
- Charging of batteries with progress bar
- Logs of energy source (write log)
- Unit tests for energy source

### Yug Dave 7222111
**Simulation of the Smart Objects**
- Smart object manager
- Consumption of smart objects
- Logs of smart objects (write log)
- Unit tests

### Amir Hossein Pakdel 7221789
**Management system for the house consumption**
- User Interface
- Logs management (read, delete, export, filter)
---

## Features

### Battery Management
- Add, remove, and monitor batteries.
- Simulate real-time charging using dynamic progress bars.
- Monitor battery charge percentage and energy consumption.

### Energy Source Management
- Choose energy sources dynamically based on weather conditions (e.g., sunny, rainy, windy).
- Concurrently charge multiple batteries using available energy sources.

### Smart Object Management
- Create, remove, and control smart devices.
- Toggle devices on/off and monitor their energy consumption.

### Logging and Analytics
- Maintain logs for battery and energy source activities.
- Filter logs by date, source, or device.
- Export logs to a CSV file for analysis.

---

## Overview

This project was developed as part of a final capstone to demonstrate advanced Java programming skills. It simulates a smart house management system where users can control smart objects, manage batteries, and keep track of system logs. The application provides a user-friendly menu-driven interface to perform all actions.

---

## Technologies Used

- **Java**: Core language for development.  
- **Object-Oriented Programming (OOP)**: Implemented using principles like encapsulation, inheritance, and polymorphism.  
- **File Handling**: Supports log storage and export functionality.  

---

## Steps to Run the Project

1. **Clone the Repository:**  
   Use the following command to clone the project repository:  
   ```bash
   git clone https://github.com/hadisdelbord/Final_Capstone_Project_G5.git
2. Open the Project:
   Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

3. Build the Project:
   Build the project in your IDE to resolve all dependencies.

4. Run the Application:
   Locate and run the Main class to start the application.

---

## Usage

1. Launch the application by running the `Main` class.  
2. Use the console-based menu to navigate through the available options:  
   - **Charge Batteries:** Based on weather conditions (sunny, rainy, windy).  
   - **Add and Manage Smart Objects:** Add new devices and control their states.  
   - **View Logs:** Access logs for energy sources and smart objects.  
   - **Monitor Battery Status:** Observe real-time updates of battery states.  
   - Follow on-screen instructions for each task.

---

## Menu Options

### Main Menu Options

#### 1. **Charging Batteries**
- Select a weather condition: sunny, rainy, or windy.
- All batteries are charged in parallel, with progress displayed in a status bar.

#### 2. **Add New Smart Object**
- Add a new smart object by entering its name and energy usage.

#### 3. **Show List of Smart Objects**
- Displays a complete list of all registered smart objects, including their details.

#### 4. **ON/OFF Smart Objects**
- Select one or more smart objects (comma-separated) to turn them ON or OFF.
- Simulate energy consumption with real-time battery usage and remaining percentage updates.
- You can interrupt the process by pressing "Enter" or wait for the simulation to complete.

#### 5. **Show Logs**
- Access logs related to energy sources and smart objects. Available options:
  - View all logs.
  - Filter logs by specific criteria.
  - Delete logs by ID.
  - Export logs to a file for external analysis.

#### 6. **Batteries**
- Displays the status of all batteries, including charge percentage, in a real-time status bar.

#### 7. **Exit**
- Terminates the application.

---

## Class Overview

1. **Main**  
   - Entry point of the application.  
   - Handles the console-based user interface and menu navigation.

2. **SmartObjectManager**  
   - Manages smart objects and their interactions with batteries.  
   - Simulates energy consumption and tracks device states.

3. **Battery**  
   - Represents individual batteries, tracking charge levels and usage.  
   - Simulates charging based on weather conditions.

4. **LogManager**  
   - Records and manages logs for energy sources and smart objects.  
   - Supports filtering, deletion, and exporting of logs.

- Additional classes encapsulate specific functionalities for modular and efficient code management.

---


## System Requirements

- Manage batteries and energy sources based on weather conditions.
- Support concurrent operations for battery charging and smart object management energy consumption.
- Enable real-time monitoring of battery charging progress and device energy usage.
- Maintain logs for actions performed by smart objects and energy sources with support of read, export, filter, and delete logs
- User interaction to connect energy sources based on weather to batteries, add and manage smart objects, display logs, and view battery status.

---

## Architecture
The system follows an **Object-Oriented Design** with the following main components:

### Classes
1. **Battery**: Represents a battery with methods to monitor energy levels.
2. **EnergySource**: Represents energy sources like solar, wind, or electricity.
3. **SmartObject**: Represents user-defined smart devices with energy consumption tracking.
4. **Managers**:
   - `BatteryManager`: Manages battery operations.
   - `EnergySourceManager`: Handles energy source selection and charging logic.
   - `SmartObjectManager`: Manages smart object creation and consumption.
5. **Log Managers**:
   - `LogManager`: Handles smart objects activity logs.
   - `ESLogManager`: Specifically logs energy sources and battery-related activities.
---
