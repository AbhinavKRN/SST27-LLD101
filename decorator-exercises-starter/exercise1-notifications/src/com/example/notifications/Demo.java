package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        System.out.println("\n=== Decorator Combinations ===\n");
        
        // a) Email + SMS
        System.out.println("1. Email + SMS:");
        Notifier smsAndEmail = new SmsDecorator(base, "+91-99999-11111");
        smsAndEmail.notify("Build green [SUCCESS]");
        
        System.out.println("\n2. Email + WhatsApp:");
        // b) Email + WhatsApp
        Notifier whatsAppAndEmail = new WhatsAppDecorator(base, "user_wa");
        whatsAppAndEmail.notify("Code review needed [REVIEW]");
        
        System.out.println("\n3. Email + Slack:");
        // c) Email + Slack
        Notifier slackAndEmail = new SlackDecorator(base, "deployments");
        slackAndEmail.notify("Database backup completed [BACKUP]");
        
        System.out.println("\n4. Email + WhatsApp + Slack:");
        // d) Email + WhatsApp + Slack
        Notifier allChannels = new SlackDecorator(
            new WhatsAppDecorator(base, "user_wa"), 
            "deployments"
        );
        allChannels.notify("Deployment completed [DEPLOY]");
        
        System.out.println("\n5. Email + SMS + WhatsApp + Slack (All channels):");
        // All notification channels
        Notifier superNotifier = new SlackDecorator(
            new WhatsAppDecorator(
                new SmsDecorator(base, "+91-99999-11111"), 
                "user_wa"
            ), 
            "critical-alerts"
        );
        superNotifier.notify("CRITICAL: System maintenance required! [WARNING]");
    }
}
