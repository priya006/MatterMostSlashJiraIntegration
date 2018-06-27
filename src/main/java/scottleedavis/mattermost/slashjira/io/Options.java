package scottleedavis.mattermost.slashjira.io;

import com.atlassian.jira.rest.client.api.domain.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import scottleedavis.mattermost.slashjira.messages.Attachment;
import scottleedavis.mattermost.slashjira.messages.Response;

import java.util.Arrays;

@Component
public class Options {

    @Value("${jira.url}")
    String url;

    @Autowired
    JiraService jiraService;

    public static String errorMessage = ":wave: Need some help with `/jira`?\n" +
            "Use `/jira` to lookup a jira ticket.  e.g. /jira PROJECT-123";

    private String appUrl;

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Response responseMessage(String ticket) {

        Response response = new Response();
        try {
            Issue issue = jiraService.getIssue(ticket);

            String jiraMessage = "["+issue.getSummary()+"]("+url+"/browse/"+ticket+")\n" +
                "*Assignee* " + issue.getAssignee().getName() +"\n" +
                "*Priority* "+issue.getPriority().getName() + "\n" +
                issue.getDescription();
            Attachment attachment = new Attachment();
            attachment.setText(jiraMessage);
            response.setAttachments(Arrays.asList(attachment));
            response.setText("##### ["+ticket+"]("+url+"/browse/"+ticket+")");
        } catch( Exception e ) {
            response.setText(Options.errorMessage);
        }

        return response;
    }


}
