package dominio;

// MENSAJE UNIDOS CON CONTACTOS
public class Mensaje {
    private int id;
    private Contact from;
    private Contact contact;
    private String date;
    private String content;

    public Mensaje(int id, Contact from, Contact contact, String date, String content) {
        this.id = id;
        this.from = from;
        this.contact = contact;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mensaje [contact=" + contact.toString() + ", content=" + content + ", date=" + date + ", from=" + from
                + ", id="
                + id + "]";
    }

}
