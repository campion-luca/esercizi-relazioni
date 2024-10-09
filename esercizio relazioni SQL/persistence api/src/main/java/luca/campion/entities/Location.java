package luca.campion.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity

@Table(name= "location")

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_location;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="città", nullable = false)
    private String citta;

    @OneToMany(mappedBy = "id_evento")
    private List<Eventi> eventiList;

    public Location(){} // costruttore vuoto


    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }


    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
