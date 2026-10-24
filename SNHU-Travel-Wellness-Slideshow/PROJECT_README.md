# SNHU Travel — Wellness Destinations Slideshow

A Java Swing slideshow created for SNHU CS-250: Software Development Lifecycle. The application presents five wellness-themed travel destinations with images, descriptions, and Previous/Next navigation.

## Features
- Five wellness destinations displayed with Java Swing and `CardLayout`
- Coordinated image and description navigation
- Corrected `BorderLayout` arrangement so destination descriptions and navigation buttons remain visible together

## Technologies
Java, Swing (`JFrame`, `JPanel`, `JLabel`, `JButton`), `CardLayout`, `BorderLayout`, and event listeners.

## Run in Eclipse
Import or create a Java project, place `SlideShow.java` and the `resources` directory inside its source folder, and run the `SlideShow` class. The images are loaded from `/resources/...` on the Java classpath.

## Scope and learning
This is a travel-destination slideshow, **not a full booking or recommendation system**. Personalized destination recommendations and preference-driven updates were discussed as user-story requirements but were not implemented. A layout issue previously hid the descriptions; revising the bottom panel allowed the descriptions and navigation controls to display together.

## Image credits
Photos are credited in the Java source to Perspective Nature, Margaret Young, Emily Irene Photo Co, and Daniele Franchi (Unsplash). The forest photograph is credited to Crystal Young. Please verify usage permissions and attribution details before redistributing images beyond this educational portfolio.
