package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReservation")
    private Long idReservation;

    @Column(name="startDate")
    private Date startDate;

    @Column(name="devolutionDate")
    private Date devolutionDate;
    
    @Column(name="status")
    private String status  = "created";

    @ManyToOne
    @JoinColumn(name="farm", foreignKey = @ForeignKey(name = "fk_ReservationFarm"))
    @JsonIgnoreProperties({"reservations"})
    private Farm farm;
    
    @ManyToOne
    @JoinColumn(name="client", foreignKey = @ForeignKey(name = "fk_ReservationClient"))
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    @OneToOne(cascade ={CascadeType.PERSIST},mappedBy = "reservation")
    @JsonIgnoreProperties("score")
    private Score score;

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
          
}
