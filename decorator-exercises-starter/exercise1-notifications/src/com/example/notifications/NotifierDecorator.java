package com.example.notifications;

/**
 * Base decorator class for notifiers.
 * This allows adding additional notification channels to any existing notifier.
 */
public abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    
    @Override
    public void notify(String text) {
        notifier.notify(text);
    }
}
