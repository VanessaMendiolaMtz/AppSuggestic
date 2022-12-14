# AppSuggestic

# Android Evaluation Project

In this folder you will find a list of steps to complete and that will serve as evaluation of your knowledge and skills when developing Android applications with Kotlin.

## Instructions

Create a new project and make the following modifications:

1. Include the `data.json` file to the project and parse it to a model. This model will later be used as the information to present.
2. Build a `RecyclerView`, with the layout of your preference, that presents each of the parsed objects in the previous step. The cell layout should be as accurate as possible to the inVision project (if the inVision project is not available take as reference the image in this folder).
3. When the user selects a cell, present an `AlertDialog` containing:
    - The selected object title as the `title` of the alert.
    - The selected object subtitle as the `message` of the alert.
    - An action button that says "OK" and when tapped closes the alert.
4. Finally, create a new flavour as a duplicate of the main one and that differs in the following:
    - Name of the app.
    - Background color and tint color of the circle in the cells created in step 2. It can be any color you want.


## Specifications

The only design to respect as close as possible is the cell layout, everything else not specified, you can freely decide how to do it.

In addition to all the visual design, details such as correct memory management and good code structure will also be taken into account. Also, if you see it necessary, feel free to change everything you think could be improved so that the project has a good architecture and could become maintainable in the future.
