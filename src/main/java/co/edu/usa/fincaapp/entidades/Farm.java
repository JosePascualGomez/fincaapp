package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="farms" )
public class Farm implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false, length=45)
    private String name;
    @Column(name="address", nullable = false, length=45)
    private String address;
    @Column(name="extension", precision=5, scale = 0)
    private Integer extension;
    @Column(name="description",  length=250)
    private String description;
    
    @ManyToOne
    @JoinColumn(name="category", foreignKey = @ForeignKey(name = "fk_FarmCategory"))
    @JsonIgnoreProperties("farms")
    private Category category;

    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm","client"})
    private List<Message> messages;


    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties("farm")
    private List<Reservation> reservations;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getExtension() {
        return extension;
    }
    public void setExtension(Integer extension) {
        this.extension = extension;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
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
