# Exercise ex01 - Single Responsibility Principle & Dependency Inversion

## SOLID Violations Fixed:
- **Single Responsibility Principle**: Separated order processing from notification logic
- **Dependency Inversion Principle**: Introduced NotificationService interface

## How to run:
```bash
cd src
javac *.java
java Demo01
```

## Refactoring Details:
- Created `NotificationService` interface
- Implemented `EmailNotificationService` 
- Updated `OrderService` to use dependency injection
- Separated concerns: order processing vs. notification

## Behavior Preserved:
- Order processing with tax calculation
- Email notification functionality
- Console output for demonstration
