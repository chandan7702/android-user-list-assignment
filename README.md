# Android Assignment – User List & Detail App

This project is an Android app built in **Kotlin** as part of an assignment.

## What it does

- Shows a list of **5 sample users** on the first screen using `RecyclerView`.
- Each row uses a **custom layout** displaying:
    - User **name**
    - User **email**
- When a user taps a list item:
    - The app opens a **new Activity** (`UserDetailActivity`).
    - Data is passed using **Intent extras only**.

The detail screen displays:

- Name
- Email
- Age

The layout is built with **ConstraintLayout** and uses a card-style UI for a clean look.

## Tech Summary

- Language: **Kotlin**
- Architecture: **Activities + Intent extras** (as required by the assignment)
- UI:
    - `RecyclerView` for the user list
    - Custom item layout with `CardView`
    - Detail screen with `ConstraintLayout`
- Extras:
    - Simple UI animations for list items
    - "Send Email" button on the detail screen that opens an email app