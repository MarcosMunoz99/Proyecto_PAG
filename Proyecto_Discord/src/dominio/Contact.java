package dominio;

// CLASE CONTACTOS
public class Contact {
    private int id;
    private String nombreContact;

    public Contact(int id, String nombreContact) {
        this.id = id;
        this.nombreContact = nombreContact;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreContact() {
        return nombreContact;
    }

    public void setNombreContact(String nombreContact) {
        this.nombreContact = nombreContact;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", nombreContact=" + nombreContact + "]";
    }

}
