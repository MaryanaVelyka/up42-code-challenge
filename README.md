# UP42 QA challenge

## UI testing

### Implementation details
The website automation is implemented using Selenide framework which is Selenium wrapper.

Test framework has set of Page Object(s) implementation. 
There is `CreateWorkflowTest` test class. The test takes following steps:
1. Login to the application.
2. Start a project.
3. Create workflow with two hardcoded blocks, mentioned in the task.
4. Check if created project is in the list of existing projects.

## API testing

### Implementation details
The API automation is implemented using RestAssured framework.

Test framework has two clients implemented.
There is `WorkflowJobTest` test class. The test executes three endpoints:
1. Get bearerToken.
2. Create and run job.
3. Retrieving job status.


## Running application
To execute tests run `mvn clean test`. This command will trigger both UI and API tests.

## Improvements:
The task is timeboxed, so there is a room for improvement.

1. Adding logging.
2. Extracting common code blocks (duplications in selectors, common step tests).
3. Reading base url, credentials from properties that will allow to run tests on different environments.
4. Extracting hardcoded values to properties.
5. Adding assertions in tests both UI and API.
6. Adding checks on UI side if project/workflow/block was created successfully.
7. Understand API job execution better, to be able to extend API test to evaluate all possible job statuses. 
8. Add option to execute UI and API tests separately.
