# IncrementApp Documentation

## Overview

IncrementApp is a simple Android application designed to demonstrate basic user interactions. The app displays a number on the screen and provides two buttons to increment or decrement that number.


![Screenshot (5)](https://github.com/user-attachments/assets/73e7d170-2013-40f7-8f4d-7f4cd836a3df)

## Features

- **Increment Button**: Increases the displayed number by 1.
- **Decrement Button**: Decreases the displayed number by 1, with a lower limit of 0.
- **Custom Button Background**: The buttons have a custom background for different states (pressed, default).

## Components

1. **Activity**
   - `MainActivity.java`: Manages the UI and handles user interactions.

2. **Layout**
   - `activity_main.xml`: Defines the user interface components and their layout.

3. **Drawable Resources**
   - `button_background.xml`: Provides the custom background for the buttons.

## Screen Size and Responsiveness

The `IncrementApp` is designed to be responsive across various screen sizes:

- **Layout Design**: The `activity_main.xml` layout file is designed to adapt to different screen sizes using constraints to ensure that UI elements are positioned correctly on various devices.
- **Screen Sizes**: The app's layout should work well on both small and large screens, including tablets and phones.
- **Responsive Design**: The app uses flexible layouts and dimensions to handle different screen densities and orientations.

## How the App Works

### `MainActivity.java`

This file contains the logic for updating the number and handling button clicks.

**Code Explanation:**

- **Imports**: Imports necessary Android classes for functionality.
- **Class Declaration**: `MainActivity` extends `AppCompatActivity` to create an activity in Android.

**Variables:**

- `numberTextView`: Displays the current number.
- `incrementButton`: Button to increment the number.
- `decrementButton`: Button to decrement the number.
- `number`: Holds the current number value.

**`onCreate` Method:**

- Initializes the layout and assigns UI components to variables.
- Sets `OnClickListener` for both buttons to handle click events.

**Methods:**

- `incrementNumber()`: Increases the number by 1 and updates `numberTextView`.
- `decrementNumber()`: Decreases the number by 1 (if greater than 0) and updates `numberTextView`.

## Drawable Resource

**`button_background.xml`**

Create this XML file in the `res/drawable` directory to define custom backgrounds for the buttons.

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Pressed state -->
    <item android:state_pressed="true" android:drawable="@drawable/button_pressed"/>
    <!-- Default state -->
    <item android:drawable="@drawable/button_default"/>
</selector>
