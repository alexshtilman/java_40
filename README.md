1. Complete the project for validation constraints we have started at classwork #40
   - Write additional 5 constraints-annotations
     - NotEmpty – only for String objects with validation of not empty string
     - Past – only for LocalDate (Optional challenge – for any Temporal) with validation of a date that should be in past
     - Future – only for LocalDate (Optional challenge – for any Temporal) with validation of a date that should be in future
     - Email – only for String with validation of a valid email address according to the regular expression of the homework #4
     - Valid – for any objects containing constraints inside (consider recursion method call)
   - Think of refactoring the method “validate” of the class Validator for getting rid of if/else statements for each constraint (the operator switch should be avoided as well)
