# Automation-challenge

## Assignment
A. Create 5 functional test cases and automate them  
- Create an item  
-  Edit another existing item  
-  Delete the item created  
-  Check max long in description  
-  Check if exist in the list the item with text “Creators: Matt Duffer, Ross Duffer”  

B. Report at least 3 bugs and write a test case for each bug report that should pass if the issue is
fixed

### Bugs report

|                      | __BUG #1__                                                                                                                                                                |
|----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| __Issue type__       | Bug                                                                                                                                                                       |
| __Summary__          | When editing the image for an existing item it is not being saved                                                                                                         |
| __Product__          | Stranger List                                                                                                                                                             |
| __Env__              | Test                                                                                                                                                                      |
| __Priority__         | P2                                                                                                                                                                        |
| __Severity__         | Sev3                                                                                                                                                                      |
| __Steps to repro__   | 1. Go to the Stranger List home page <br /> 2. Click the Edit button of any item in the list<br />  3. Select a different image<br />  4. Click on the Update item button |
| __Actual result__    | The image is still the previous one                                                                                                                                       |
| __Expected result__  | The image is the new one                                                                                                                                                  |

|                      | __BUG #2__                                                                                                                                          |
|----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| __Issue type__       | Bug                                                                                                                                                 |
| __Summary__          | Image input is not clear after item creation                                                                                                        |
| __Product__          | Stranger List                                                                                                                                       |
| __Env__              | Test                                                                                                                                                |
| __Priority__         | P4                                                                                                                                                  |
| __Severity__         | Sev4                                                                                                                                                |
| __Steps to repro__   | 1. Go to the Stranger List home page <br /> 2. Select an image<br />  3. Write a text (max long 300 char)<br />  4. Click on the Create item button |
| __Actual result__    | The image input field has the value of the latest item created                                                                                      |
| __Expected result__  | The image input field should be empty                                                                                                               |

|                      | __BUG #3__                                                                                                                                        |
|----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| __Issue type__       | Bug                                                                                                                                               |
| __Summary__          | Item action buttons are not visible when the description is too long                                                                              |
| __Product__          | Stranger List                                                                                                                                     |
| __Env__              | Test                                                                                                                                              |
| __Priority__         | P2                                                                                                                                                |
| __Severity__         | Sev3                                                                                                                                              |
| __Steps to repro__   | 1. Go to the Stranger List home page <br /> 2. Select an image<br />  3. Write a text of 300 characters<br />  4. Click on the Create item button |
| __Actual result__    | The Edit/delete buttons are not visible                                                                                                           |
| __Expected result__  | The Edit/delete buttons of the item should be visible                                                                                             |

### Requirements
#### Java jdk version
```sh
1.8.0
```

#### Maven version
```sh
3.8.1
```

### Execution
#### Clean and install

```sh
mvn clean install
```

#### Run test

Chrome:

```sh
mvn test -Dbrowser=chrome
```
Firefox:

```sh
mvn test -Dbrowser=firefox
```
Chrome Mobile (iPhone 12 Pro):

```sh
mvn test -Dbrowser=chromeMobile
```
