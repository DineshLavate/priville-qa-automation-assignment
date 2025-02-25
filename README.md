

# Priville QA Automation Assignment - SIMFORM

## Overview

This repository contains automated test scenarios for the Priville website, focusing on validating key functionalities to ensure a seamless user experience (UX) and a robust user interface (UI). The tests aim to validate multiple features, including filtering, search functionalities, venue details, and their integration, ensuring that users can easily find venues, interact with the platform, and navigate through it without issues. This not only improves usability but also enhances the overall satisfaction of users.

## Features and Justifications

### 1. Filter Functionality for Pool & Beach

**Description:**  
This feature ensures that users can filter venues based on the "Pool & Beach" category. By verifying this functionality, we check that the system displays accurate results aligned with the selected filter criteria.

**Justification:**  
The filtering feature is a core part of the platform's user experience, helping users narrow down their search based on specific preferences. A smooth and intuitive filtering process is crucial for enhancing user satisfaction, making it easier for users to find venues relevant to their needs.

### 2. Filter Functionality for Dining with Multiple Selections

**Description:**  
This test validates that users can apply multiple filters (e.g., "Dining" category and discount filters) and receive correct venue results that match all selected criteria.

**Justification:**  
Allowing users to refine their search with multiple filters provides a tailored experience, ensuring they can find venues that meet all their preferences. Multiple filter selections are often crucial in complex systems where users may have several preferences they want to apply simultaneously.

### 3. Filter Functionality Based on Family Activities

**Description:**  
This feature checks that users can filter venues based on "Family Activities" and that the application responds promptly with accurate results. It ensures that the system provides the correct venues suited for family activities.

**Justification:**  
This feature is essential for family-oriented users who need venues offering specific activities. It ensures that the platform is designed to cater to the diverse needs of different user segments, making it easier for families to find suitable venues.

### 4. Search Functionality

**Description:**  
This test ensures that users can search for specific venues using the search bar. When a user types a venue name, the system should provide relevant suggestions, and upon selection, the user should be directed to the correct venue page.

**Justification:**  
Search functionality is a cornerstone of user navigation, helping users quickly find specific venues or categories. This feature ensures the platform remains user-friendly, allowing users to easily find the venues they're interested in without unnecessary steps.

### 5. Search Functionality with Invalid Search Pattern

**Description:**  
This feature tests the behavior of the search functionality when invalid search patterns (such as non-existent venues or symbols) are entered. The system should return a "No Results Found" message to indicate no matches for the search query.

**Justification:**  
Handling invalid search inputs gracefully is important for a good UX. Users should be clearly informed when no results are found for their query, ensuring that they aren't left in confusion.

## API Testing with Newman

API tests are executed using [Newman](https://www.npmjs.com/package/newman), the command-line companion for [Postman](https://www.postman.com/).

**Running API Tests:**

To execute the API test collection and generate reports, use the following command:

```bash
newman run Simform_gorest_API_collection.json -e Simform_gorest_environment.json
```

**Explanation:**

- `Simform_gorest_API_collection.json`: Path to the Postman collection file.
- `Simform_gorest_environment.json`: Path to the Postman environment file.
- `-r cli,json,junit`: Specifies the reporters to use:
  - `cli`: Command line interface reporter.
  - `json`: Generates a JSON report.
  - `junit`: Generates a JUnit XML report.

For more details on Newman command options, refer to the [official documentation](https://learning.postman.com/docs/collections/using-newman-cli/newman-options/).

## Report Generation

After running the tests with Newman, the following reports are generated:

- **CLI Report:** Displays test results directly in the terminal.
- **JSON Report:** Saves detailed test results in a JSON file for further analysis.
- **JUnit Report:** Produces an XML file compatible with CI tools for integration purposes.

These reports provide comprehensive insights into the API test executions, facilitating effective monitoring and debugging.

## Privilee UI Automation Framework Information

- **Project Structure:**
  - `Priville_Automation/`: Contains the main automation test scripts.
  - `TestData/`: Holds test data files used during test execution.
  - `ReportGenarator/`: Includes scripts and templates for generating test reports.
  - `test-output/`: Directory where test execution reports are stored.

- **Prerequisites:**
  - Ensure that [Node.js](https://nodejs.org/) and [Newman](https://www.npmjs.com/package/newman) are installed on your system.
  - Install necessary dependencies by running:

    ```bash
    npm install
    ```

- **Execution:**
  - To run the automation tests, navigate to the `Priville_Automation` directory and execute:

    ```bash
    mvn test
    ```

  - Ensure that the `pom.xml` file is properly configured with all required dependencies.

For any questions or further assistance, please refer to the project's [GitHub repository](https://github.com/DineshLavate/priville-qa-automation-assignment) or contact the maintainer.