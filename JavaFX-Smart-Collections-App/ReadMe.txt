# Smart Collections

Smart Collections is a JavaFX desktop application that helps users organize and preview digital resources, including notes, documents, audio, and video files. It supports recursive folder import, keyword-based search, undo functionality, and media playback. The app is designed with a modular architecture and a responsive user interface.

## 📦 Project Structure

SmartCollections/
├── src/                         # Java source files
├── sample-data/                # Sample folder tree for import testing
├── lib/                        # JavaFX SDK JARs
├── SmartCollections.jar        # Runnable JAR
├── README.md                   # This file
├── report.pdf                  # Final report
```

## How to Build & Run

### Requirements
- Java 17+
- JavaFX SDK 21+
- Eclipse or any Java IDE

### Option A: Run from Eclipse
1. Import the project into Eclipse.
2. Add JavaFX SDK to your build path.
3. Set VM arguments:
   ```
   --module-path /path/to/javafx-sdk-21/lib --add-modules javafx.controls,javafx.fxml,javafx.media
   ```
4. Run `MainApp.java`.

### Option B: Run JAR from Terminal
If you have `SmartCollections.jar`:

```bash
java --module-path /path/to/javafx-sdk-21/lib \
     --add-modules javafx.controls,javafx.fxml,javafx.media \
     -jar SmartCollections.jar


## Java/JavaFX Version

- Java: 17+
- JavaFX: 21+



## Documentation

See `report.pdf` for architecture, design decisions, data structures, testing strategy, and future work.



## Author

Amir  
Project submitted for ITEC627 - ADVANCED PROGRAMMING CONCEPTS-2025, Semester 2