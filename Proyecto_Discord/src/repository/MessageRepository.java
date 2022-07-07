package repository;

import java.util.ArrayList;
import java.util.List;

import dominio.Contact;
import dominio.Mensaje;

public class MessageRepository {

    private List<Mensaje> messages = new ArrayList<>();
    private List<Contact> contacts = new ArrayList<>();

    // LA LISTA DE LOS CONTACTOS CON MENSAJES ALEATORIOS
    public MessageRepository() {

        contacts.add(new Contact(1, "Yo"));
        contacts.add(new Contact(2, "Luis"));
        contacts.add(new Contact(3, "Juan"));
        contacts.add(new Contact(4, "Fernando"));
        contacts.add(new Contact(5, "Rosa"));
        contacts.add(new Contact(6, "Gabriel"));
        contacts.add(new Contact(7, "Gonzalo"));
        contacts.add(new Contact(8, "Enrique"));
        contacts.add(new Contact(9, "Emilio"));
        contacts.add(new Contact(10, "Carlos"));
        contacts.add(new Contact(11, "Elver"));
        contacts.add(new Contact(12, "Contreras"));
        contacts.add(new Contact(13, "Alvarado"));
        contacts.add(new Contact(14, "Controras"));
        contacts.add(new Contact(15, "Peralta"));
        contacts.add(new Contact(16, "Quijije"));
        contacts.add(new Contact(17, "Alarcon"));

        messages.add(new Mensaje(1, contacts.get(0), contacts.get(1), "22/06/2022 10:10 ", "Hola nex..,Como estas"));
        messages.add(new Mensaje(2, contacts.get(1), contacts.get(0), "22/06/2022 10:10 ", "Hola nex.. a los años"));
        messages.add(new Mensaje(3, contacts.get(0), contacts.get(1), "22/06/2022 10:10 ", "Juegas lol?"));
        messages.add(new Mensaje(4, contacts.get(1), contacts.get(0), "22/06/2022 10:10 ", "Nop"));

        messages.add(new Mensaje(5, contacts.get(0), contacts.get(2), "22/06/2022 10:10 ", "Hola Marcos, Como estas?"));
        messages.add(new Mensaje(6, contacts.get(2), contacts.get(0), "22/06/2022 10:11 ", "Hola nex.. a los años"));
        messages.add(new Mensaje(7, contacts.get(0), contacts.get(2), "22/06/2022 10:12 ", "Juegas lol?"));
        messages.add(new Mensaje(8, contacts.get(2), contacts.get(0), "22/06/2022 10:13 ", "Nop"));

        messages.add(
                new Mensaje(9, contacts.get(0), contacts.get(3), "22/06/2022 10:10 ", "Hola Fernando, Como estas?"));
        messages.add(new Mensaje(10, contacts.get(3), contacts.get(0), "22/06/2022 10:11 ", "Hola nex.. a los años"));
        messages.add(new Mensaje(11, contacts.get(0), contacts.get(3), "22/06/2022 10:12 ", "Juegas lol?"));
        messages.add(new Mensaje(12, contacts.get(3), contacts.get(0), "22/06/2022 10:13 ", "Nop"));

        messages.add(
                new Mensaje(13, contacts.get(0), contacts.get(4), "22/06/2022 10:10 ", "Hola Roberto, Como estas?"));
        messages.add(new Mensaje(14, contacts.get(4), contacts.get(0), "22/06/2022 10:11 ", "Hola nex.. a los años"));
        messages.add(new Mensaje(15, contacts.get(0), contacts.get(4), "22/06/2022 10:12 ", "Juegas lol?"));
        messages.add(new Mensaje(16, contacts.get(4), contacts.get(0), "22/06/2022 10:13 ", "Nop"));
    }

    public List<Mensaje> getMessage(int user, int contact) {
        List<Mensaje> result = new ArrayList<>();
        for (Mensaje msg : messages) {
            if ((msg.getFrom().equals(contacts.get(user)) && msg.getContact().equals(contacts.get(contact)))
                    || msg.getContact().equals(contacts.get(contact)) && msg.getFrom().equals(contacts.get(user))) {
                result.add(msg);
            }
        }
        return result;
    }

    public List<Contact> getContact(int contact) {
        List<Contact> result = new ArrayList<>();
        for (Contact ctc : contacts) {
            result.add(ctc);
        }
        return result;
    }

}
