package luca.campion.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity

@Table(name= "persone")

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_persona;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="cognome", nullable = false)
    private String cognome;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="data di nascita", nullable = false)
    private Date dataDiNascita;

    @Column(name="sesso", nullable = false)
    @Enumerated(EnumType.STRING)
    private sesso sesso;

    @OneToMany(mappedBy = "id_persona")
    private List<Partecipazione> listaPartecipazioni;


    public Persona(){} // costruttore vuoto


    public Persona(String cognome, Date dataDiNascita, String email, String nome, luca.campion.entities.sesso sesso) {
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.nome = nome;
        this.sesso = sesso;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public luca.campion.entities.sesso getSesso() {
        return sesso;
    }

    public void setSesso(luca.campion.entities.sesso sesso) {
        this.sesso = sesso;
    }
}
