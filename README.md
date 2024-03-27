# ABOUT

#### A REST API Test Framework for developing the regression suites. The test cases can be run locally or through CI/CD.

# STEPS FOR INTEGRATING TESTNG & REPORT PORTAL

1. Download the latest docker-compose.yml
   from [here](https://github.com/reportportal/reportportal/blob/master/docker-compose.yml), a quicker way to download
   this is to use below command
   `curl https://raw.githubusercontent.com/reportportal/reportportal/master/docker-compose.yml -o docker-compose.yml`
2. Once downloaded, execute the below command to pull the required images and start containers
   `docker-compose -p reportportal up -d --force-recreate`
3. Verify login http://localhost:8080/ui/#login with `default\1q2w3e` or `superadmin\erebus`
4. Create a blank project and copy and paste the below config in `reportportal.properties` under `src/test/resources`.
   See the table below.
5. Read these great posts written below by [Automation Hacks](https://github.com/automationhacks) to configure Report portal. By far, these are the only posts with accurate steps.
    1. Further reading on setting up the reportportal
       is [here](https://automationhacks.io/2020/03/02/how-to-setup-reportportal-on-a-local-docker-instance/).
    2. Further reading on configuring logback with reportportal to push logs
       is [here](https://automationhacks.io/2020/09/25/logging-integration-with-logback-testng-in-report-portal/).

| Sl.No | Report portal Property Name | Report portal Property Value |
|-------|-----------------------------|------------------------------|
| 1     | rp.endpoint                 | http://localhost:8080        |
| 2     | rp.api.key                  | <API_KEY>                    |
| 3     | rp.launch                   | Java launch                  |
| 4     | rp.project                  | api_tests                    |


#### REPORT PORTAL OUTPUTS
<img width="1415" alt="Test_Logs_MVN_CMD" src="https://github.com/iamcharankumar/api_test_framework/assets/29479534/16b37790-994d-4a9f-9d86-ba6656b18522">
<img width="1728" alt="Test_Logs_Pushed_Report_Portal" src="https://github.com/iamcharankumar/api_test_framework/assets/29479534/652e0be2-748b-4d9e-ab1f-b68f1698b625">
<img width="1728" alt="Test_Suite_Launches_Report_Portal" src="https://github.com/iamcharankumar/api_test_framework/assets/29479534/9e22ff4c-4051-4b9e-af9a-001684c7a797">


# STEPS FOR THE TEST EXECUTION

**1. git clone https://github.com/iamcharankumar/api_test_framework.git**

**2. cd api_test_framework**

**3. git pull**

**4. mvn clean test -Dgroups=ALL_SMOKE,ALL_REGRESSION -Dtestng.parallel=methods -DthreadPoolSize=3
-Ddataproviderthreadcount=3**

**Note:** To run specific test cases, use appropriate Test groups present in 'TestGroups' class.
