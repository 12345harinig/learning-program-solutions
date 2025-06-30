package DecoratorPatternExample;

public class NotificationTest {
    public static void main(String[] args) {
        Notifier basicNotifier = new EmailNotifier(); 
        Notifier smsNotifier = new SMSNotifierDecorator(basicNotifier);      
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);
        fullNotifier.send("System Update: New features released!");
    }
}
