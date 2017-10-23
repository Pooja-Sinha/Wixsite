# Wixsite

### Core framework used:
        POM utilising Selenium WebDriver , Java , TestNG & Maven.
        
Project has been divided into four packages:

a> utilities - contains class Utilities.java which has common methods & attributes.

b> pages - contains classes corresponding to each page being navigated to eg. LandingPage.java, BlogPage.java

c> components - contains Components.java which serves as a linkage between page navigations.

d> scripts - contains classes corresponding to each of the scripts eg. VerifyBlogComments.java , VerifyPageTitleAndReportBrokenLinks.java

Others :
- pom.xml specifies all the dependencies & plugins needed for the project.
- testng.xml specifies the structure in which tests should be run. This can be modified on need basis (if any test needs to be skipped,parameters to be passed to tests etc.)
- common.properties lists all the locators to be used in one place.

## Guidelines
1>Wixsite repository contains a POM project automating "https://rishubhatia.wixsite.com/website" as per the given problem statement.

2>To run tests, run testng.xml as TestNG Suite
        Run As> TestNG Suite.

3>The tests will run serially since parallel="none" has been set in testng.xml file.

4>The tests correspond to classes in src/scripts package.Modifications can be done as needed from here.
Wish to run the scripts individually, these classes in script package can be run individually
    Run As> TestNG Test

5> Also, before running install all the dependencies by running pom.xml as Maven Install -- Run As> Maven Install.
