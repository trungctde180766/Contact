package Contact;

import Controller.ContactController;
import View.ContactView;

public class Main {
    public static void main(String[] args) {
        ContactView view = new ContactView();
        ContactDAO dao = new ContactDAOImpl();
        ContactController controller = new ContactController(view, dao);
        controller.processUserInput();
    }
}
