# Prog01_aOrderedList

## Project Description
This project is part of a multi-phase effort to create a custom class for managing an ordered list of Car objects in Java. Phase 1 includes creating the Car class and an aOrderedList class, reading data from an input file, and managing the ordered list.

## Getting Started
### Prerequisites
- Java Development Environment
- Git (optional, for version control)

### Installation
1. Clone this repository (if using Git): https://github.com/PhucNguyen0203/Project-CSC1351.git

## Supported Operations
- `A,Make,Year,Price`: Add a new car to the ordered list.
- `D,Make,Year`: Delete a car from the ordered list based on make and year.

## Class Descriptions
### `Car`
- Represents a car with make, year, and price.
- Supports comparison for sorting.

### `aOrderedList`
- Manages an ordered list of `Car` objects.
- Automatically resizes the array as needed.
- Supports add, get, remove, and iteration methods.

## File Input
- The program reads input from a text file where each line specifies an operation (A or D) and car data.

## File Output
- The program outputs the ordered list in a special format, including car details.

## Extending the Project
This project can be extended by implementing additional functionality, such as:
- Searching for cars by make and year.
- Updating car information.
- Handling more operations (e.g., update, search).

## Authors
- Phuc Nguyen

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
