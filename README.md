# Android Template with MVVM/CleanArchitecture

## Project Description
- This is a template that can be conveniently used when starting an Android project, with MVVM and Clean Architecture applied.

## Architecture
This project combines the MVVM and Clean Architecture principles to ensure scalability, maintainability, and testability. Here’s a brief overview of the architecture and how each module is implemented:

### MVVM Components
- **Model** - Handles the data logic and business rules.
- **View** - Responsible for rendering the UI and receiving user interactions, primarily composed of Compose views.
- **ViewModel** - Acts as a bridge between the Model and the View, managing UI-related data.

### Clean Architecture Layers
- **Data Module**: Contains everything related to data handling, such as network communication, API calls, response models, and dependency injection setup.
- **Domain Module**: Encapsulates business logic and business models, serving as an intermediary between the Data and Feature modules.
- **Feature Module**: Comprises the UI components using Jetpack Compose and ViewModels, organizing them according to features.
- **App Module**: Houses the application’s main components such as Activities and Fragments.

Each layer is designed to be independent and interchangeable, promoting a separation of concerns that facilitates easier testing and maintenance.

### Prerequisites
- Android Studio [Iguana | 2023.2.1]
- Minimum SDK version [24]
- Target SDK version [34]

```bash
git clone https://github.com/ok0035/AndroidTemplate.git
cd AndroidTemplate
