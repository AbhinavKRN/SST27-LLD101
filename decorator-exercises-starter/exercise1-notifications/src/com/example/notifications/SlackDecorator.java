package com.example.notifications;

/**
 * Concrete decorator that adds Slack notification capability.
 */
public class SlackDecorator extends NotifierDecorator {
    private final String slackChannel;
    
    public SlackDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }
    
    @Override
    public void notify(String text) {
        super.notify(text); // Send via wrapped notifier first
        sendSlack(text);    // Then send Slack
    }
    
    private void sendSlack(String text) {
        System.out.println("[SLACK -> #" + slackChannel + "]: " + text);
    }
}
