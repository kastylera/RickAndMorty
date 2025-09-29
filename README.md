# Rick and Morty Characters App

Тестове завдання **Middle Android Developer**.  
Додаток відображає пагінований список персонажів із [Rick and Morty API](https://rickandmortyapi.com/) та екран деталей кожного персонажа.

## 🚀 Функціонал
- Пагінація списку персонажів
- Екран деталей персонажа
- UI-стани: loading, error, empty
- Архітектура **MVI**
- Дві реалізації:
  - **Decompose** (основна)
  - **ViewModel + MVI** (альтернативна)

## 🏗 Технології
- Kotlin, Coroutines, Flow
- Jetpack Compose
- Paging 3
- Decompose / ViewModel
- Hilt / Koin (DI)
- Room (опціональне кешування)

## 📂 Структура
data/ # API, DTO, Room, репозиторії
domain/ # UseCases, domain-моделі
ui/ # Екрани, MVI-стани
di/ # Dependency Injection

## 🔀 Гілки
- `main` — реалізація з **Decompose**  
- `viewmodel-version` — реалізація через **ViewModel**
