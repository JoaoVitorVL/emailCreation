public class EmailApp {
    public static void main(String[] args) {
        Email email = new Email("Jota","Vevie");

        System.out.println(email.showInfo());

        email.setAlternateEmail("jotaV@dev.mycompany.com");
        System.out.println(email.getAlternateEmail());

        email.setMailboxCapacity(500);
        System.out.println(email.getMailboxCapacity());

        email.changePassword("gumPop123@");
        System.out.println(email.getPassword());

        System.out.println(email.showInfo());

    }
}