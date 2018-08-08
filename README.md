# mattermost-slashjira
A /jira slash command for [Mattermost](https://mattermost.com/) built with [Spring Boot](https://spring.io/projects/spring-boot) [![Build Status](https://travis-ci.org/scottleedavis/mattermost-slashjira.svg?branch=master)](https://travis-ci.org/scottleedavis/mattermost-slashjira) [![codecov](https://codecov.io/gh/scottleedavis/mattermost-slashjira/branch/master/graph/badge.svg)](https://codecov.io/gh/scottleedavis/mattermost-slashjira)
 [![Codacy Badge](https://api.codacy.com/project/badge/Grade/ddb524b9874144a6ae0029b3ec56bdf4)](https://www.codacy.com/app/scottleedavis/mattermost-slashjira?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=scottleedavis/mattermost-slashjira&amp;utm_campaign=Badge_Grade)

`/jira [issue id]`

### usage

* **/jira PROJECT-123**

### bugs & issues

* Want to see a feature or report a bug?  Head to the [issues tab](https://github.com/scottleedavis/mattermost-io.github.scottleedavis.mattermost.slashjira/issues).

### requirements
* Build: [Maven](https://maven.apache.org/download.cgi) & [Java8](http://openjdk.java.net/install/)
    * `mvn package`
* Run: [Java8 JRE](http://openjdk.java.net/install/)
* Use: [Mattermost](https://mattermost.com/) 

### setup
##### Mattermost Integration
_Requires slash command and webhook integrations_
* Ensure Custom Integrations (in System Console) has the following enabled
  * `Enable Custom Slash Commands`
  * `Enable integrations to override usernames` & `Enable integrations to override profile picture icons`
    * OR... create a `slash-jira` user to setup the slash command and webhook with system icon
* create `remind` as slash command
  * Title & Autocomplete: `Jira issue`
  * Response Username: `jira-slash`
  * Autocomplete hint: `[issue id]`
  * Request URL: `<path_to_mattermost-remind>/jira`
  * set jira system icon
  * put token in [application.properties](application/src/main/resources/application.properties) 
    * slashCommandToken=<YOUR_TOKEN>
##### Jira credentials
* put credentials in [application.properties](application/src/main/resources/application.properties) 
  * jira.username=<JIRA_USERNAME>
  * jira.password=<JIRA_PASSWORD>
  * jira.url=http:<JIRA_BASE_URL>
