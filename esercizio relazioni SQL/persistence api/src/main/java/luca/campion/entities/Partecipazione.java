package luca.campion.entities;

import jakarta.persistence.*;

@Entity

@Table(name= "partecipazione")

public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partecipazione;

    @Column(name="stato dell'invito", nullable = false)
    @Enumerated(EnumType.STRING)
    private statoPartecipazione statoPartecipazione;

    @ManyToOne // collegamento many to one -> una persona può avere più partecipazioni
    @JoinColumn(name= "id_persona", nullable = false)
    private Persona id_persona;

    @ManyToOne
    @JoinColumn(name= "id_evento", nullable = false)
    private Eventi id_evento;

    public Partecipazione(){} // costruttore vuoto

    public Partecipazione(luca.campion.entities.statoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

    public luca.campion.entities.statoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(luca.campion.entities.statoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }


}
