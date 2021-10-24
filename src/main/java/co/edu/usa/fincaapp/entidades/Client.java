package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clients")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idClient;
    
    @Column(name="email", nullable = false, length=45)
    private String email;

    @Column(name="password", nullable = false, length=45)
    private String password;

    @Column(name="name", nullable = false, length=250)    
    private String name;
    
    @Column(name="age")
    private Integer age;
    

    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")    
    private List<Reservation> reservations;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

        
}
