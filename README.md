# mattermost-io.github.scottleedavis.mattermost.slashjira
A /jira slash command for [Mattermost](https://mattermost.com/) built with [Spring Boot](https://spring.io/projects/spring-boot)
ttermost

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
