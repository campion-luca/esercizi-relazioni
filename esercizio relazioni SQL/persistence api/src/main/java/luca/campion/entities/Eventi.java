package luca.campion.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity

@Table(name="eventi")


public class Eventi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_evento;

    @Column(name="titolo_evento", nullable = false)
    private String titolo;

    @Column(name="data_evento", nullable = false)
    private LocalDate dataEvento;

    private String descrizione;

    @Column(name="numero_massimo_dei_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;

    @Column(name="tipo_di_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;

    //aggiunta post prima parte esercizio, collegamento tabella
    @ManyToOne
    @JoinColumn(name="id_location", nullable = false)
    private Location location;


    public Eventi(){} // costruttore vuoto nella entities

    public Eventi(String descrizione, luca.campion.entities.tipoEvento tipoEvento, String titolo, int numeroMassimoPartecipanti) {
        this.dataEvento = LocalDate.now();
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.titolo = titolo;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }


    public Eventi(int numeroMassimoPartecipanti, luca.campion.entities.tipoEvento tipoEvento, String titolo, Location location, String descrizione, LocalDate dataEvento) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.tipoEvento = tipoEvento;
        this.titolo = titolo;
        this.location = location;
        this.descrizione = descrizione;
        this.dataEvento = dataEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public luca.campion.entities.tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(luca.campion.entities.tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Eventi{" +
                "dataEvento=" + dataEvento +
                ", id_evento=" + id_evento +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", tipoEvento=" + tipoEvento +
                ", id_location=" + location +
                '}';
    }
}
