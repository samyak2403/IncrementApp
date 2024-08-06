# Welcome to Building IncrementApp! 🎉

Hello Future Developer! 👋

We’re excited to have you start your journey in app development with IncrementApp. This app is designed to help you learn the basics of Android app development. Let’s get started!

## What You’ll Learn

- **Creating a User Interface**: Design and layout your app’s screen.
- **Handling User Interactions**: Make buttons that can change a number.
- **Customizing UI Elements**: Style your buttons using drawable resources.

## Steps to Build IncrementApp

### 1. Set Up Your Development Environment

- **Install Android Studio**: This is the tool you'll use to write and test your code. Download it from the [Android Studio website](https://developer.android.com/studio) and follow the installation instructions.

### 2. Create a New Project

- **Open Android Studio** and start a new project.
- **Choose “Empty Activity”** and name your project `IncrementApp`.

### 3. Design Your App Layout

- **Open `activity_main.xml`**: This file is where you’ll define your app’s layout.
- **Add a TextView**: This will display the number.
- **Add Two Buttons**: One for incrementing and one for decrementing the number.

### 4. Add Custom Button Backgrounds

- **Create Drawable Resources**: To style your buttons, you’ll add XML files for custom backgrounds.
- **Place these files in `res/drawable`** and define how the buttons should look in different states (normal and pressed).

### 5. Write the App Logic

- **Open `MainActivity.java`**: This is where you’ll write the code for your app.
- **Set up Click Listeners**: Program the buttons to increase or decrease the number and update the display.

---

## IncrementApp Documentation

### Overview

IncrementApp is a simple Android app that demonstrates basic user interactions. It shows a number on the screen and has two buttons to increment or decrement the number.

![Screenshot](https://github.com/user-attachments/assets/73e7d170-2013-40f7-8f4d-7f4cd836a3df)

### Features

- **Increment Button**: Increases the displayed number by 1.
- **Decrement Button**: Decreases the displayed number by 1, with a lower limit of 0.
- **Custom Button Background**: Custom background for buttons in different states (pressed, default).

### Components

1. **Activity**
   - `MainActivity.java`: Manages the UI and handles user interactions.

2. **Layout**
   - `activity_main.xml`: Defines the user interface components and their layout.

3. **Drawable Resources**
   - `button_background.xml`: Custom background for the buttons.

### Screen Size and Responsiveness

- **Layout Design**: `activity_main.xml` adapts to different screen sizes using constraints.
- **Screen Sizes**: Works well on both small and large screens, including tablets and phones.
- **Responsive Design**: Uses flexible layouts and dimensions to handle various screen densities and orientations.

### How the App Works

#### `MainActivity.java`

This file contains the logic for updating the number and handling button clicks.

**Code Explanation:**

- **Imports**: Includes necessary Android classes for functionality.
- **Class Declaration**: `MainActivity` extends `AppCompatActivity` to create an activity.

**Variables:**

- `numberTextView`: Displays the current number.
- `incrementButton`: Button to increase the number.
- `decrementButton`: Button to decrease the number.
- `number`: Holds the current number value.

**`onCreate` Method:**

- Initializes the layout and assigns UI components to variables.
- Sets `OnClickListener` for both buttons to handle click events.

**Methods:**

- `incrementNumber()`: Increases the number by 1 and updates `numberTextView`.
- `decrementNumber()`: Decreases the number by 1 (if greater than 0) and updates `numberTextView`.

### Drawable Resource

**`button_background.xml`**

Create this XML file in `res/drawable` to define custom backgrounds for the buttons.

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Pressed state -->
    <item android:state_pressed="true" android:drawable="@drawable/button_pressed"/>
    <!-- Default state -->
    <item android:drawable="@drawable/button_default"/>
</selector>
