package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="messages")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    @Column(name="messageText", nullable = false, length=250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name="farm", foreignKey = @ForeignKey(name = "fk_MessageFarm"))
    @JsonIgnoreProperties({"messages","reservations"})
    private Farm farm;

    @ManyToOne
    @JoinColumn(name="client", foreignKey = @ForeignKey(name = "fk_messagesClient"))
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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


        
}
