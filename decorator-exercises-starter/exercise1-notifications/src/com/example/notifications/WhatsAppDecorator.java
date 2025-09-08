package com.example.notifications;

/**
 * Concrete decorator that adds WhatsApp notification capability.
 */
public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsAppId;
    
    public WhatsAppDecorator(Notifier notifier, String whatsAppId) {
        super(notifier);
        this.whatsAppId = whatsAppId;
    }
    
    @Override
    public void notify(String text) {
        super.notify(text); // Send via wrapped notifier first
        sendWhatsApp(text); // Then send WhatsApp
    }
    
    private void sendWhatsApp(String text) {
        System.out.println("[WHATSAPP -> " + whatsAppId + "]: " + text);
    }
}
