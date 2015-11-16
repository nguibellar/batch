package org.devware.batch.model;

import java.util.Date;


public class Item {
        
   /*
     Identifiant de la personne
    */
    private String id;
    
    /*
     Nom de la personne
    */
    private String name;
    
    /*
     Prenom de la personne
    */
    private String surname;
    
     /*
     Prenom de la personne
    */
    private Date date;
    
    
    /*
     Constructeur sans parametres
    */
    public Item() {

    }
    /*
     Constructeur avec parametres
    */
    public Item(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", name=" + name + ", surname=" + surname + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if ((this.name == null) ? (other.name != null)
                : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.surname == null) ? (other.surname != null) 
                : !this.surname.equals(other.surname)) {
            return false;
        }
        return true;
    }

    
	
}
