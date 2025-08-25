# Exercise ex02 - Single Responsibility Principle

## SOLID Violations Fixed:
- **Single Responsibility Principle**: Separated media player concerns into focused classes

## How to run:
```bash
cd src
javac *.java
java Demo02
```

## Refactoring Details:
- Created `MediaDecoder` for frame decoding
- Created `FrameCache` for frame management  
- Created `PlaybackUI` for user interface display
- Updated `Player` to orchestrate these components
- Each class now has a single, focused responsibility

## Behavior Preserved:
- Frame decoding and caching
- Playback status display
- Console output for demonstration
