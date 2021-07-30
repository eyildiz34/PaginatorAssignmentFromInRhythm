**Pagination Helper Task**

This project is combination of Maven and JUnit for unit test. After downloading or cloning the project on your local system, execute following commands in the terminal.

Specify project path on the terminal
cd project path

**to execute all test cases**

mvn -Dtest=PaginationHelperTest test

**to execute specific test case**

mvn -Dtest=PaginationHelperTest#getItemCount test
mvn -Dtest=PaginationHelperTest#getPageIndex test
mvn -Dtest=PaginationHelperTest#getPageCount test
mvn -Dtest=PaginationHelperTest#getPageItemCount test

**without command line**

go to test resources and find runner package, then execute runnertest.xml file