# ABOUT

#### A REST API Test Framework for developing the regression suites. The test cases can be run locally or through CI/CD.

# STEPS FOR THE TEST EXECUTION

**1. git clone https://github.com/iamcharankumar/api_test_framework.git**

**2. cd api_test_framework**

**3. git pull**

**4. mvn clean test -Dgroups=ALL_SMOKE,ALL_REGRESSION -Dtestng.parallel=methods -DthreadPoolSize=3
-Ddataproviderthreadcount=3**

**Note:** To run specific test cases, use appropriate Test groups present in 'TestGroups' class.