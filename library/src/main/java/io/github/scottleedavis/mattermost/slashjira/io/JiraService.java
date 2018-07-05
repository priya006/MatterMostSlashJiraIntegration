package io.github.scottleedavis.mattermost.slashjira.io;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class JiraService {

    private String username;
    private String password;
    private String url;
    private JiraRestClient jiraRestClient;

    @Autowired
    public JiraService(@Value("${jira.username}") String username,
                       @Value("${jira.password}") String password,
                       @Value("${jira.url}") String url) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.jiraRestClient = getJiraRestClient();
    }

    public Issue getIssue(String key) {
        return jiraRestClient.getIssueClient().getIssue(key).claim();
    }

    private JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory().createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
    }

    private URI getJiraUri() {
        return URI.create(this.url);
    }
}
