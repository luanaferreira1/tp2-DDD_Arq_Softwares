package br.com.petfriends.domain;

import br.com.petfriends.domain.events.AgendamentoConfirmadoEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "agendamentos")
@Getter
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;
    private String status;
    private UUID clienteId;
    private Long veterinarioId;
    private Long lojaId;

    @Transient
    private final List<Object> domainEvents = new ArrayList<>();

    public Agendamento(UUID clienteId, Long lojaId, LocalDateTime dataHora) {
        this.clienteId = clienteId;
        this.lojaId = lojaId;
        this.dataHora = dataHora;
        this.status = "PENDENTE";
    }

    public void confirmar() {
        if (!this.status.equals("PENDENTE")) {
            throw new IllegalStateException("Apenas agendamentos PENDENTES podem ser confirmados.");
        }

        this.status = "CONFIRMADO";

        this.registerEvent(new AgendamentoConfirmadoEvent(
                this.id,
                this.clienteId,
                this.lojaId
        ));
    }

    public void adicionarVeterinario(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    protected void registerEvent(Object event) {
        this.domainEvents.add(event);
    }

    public Collection<Object> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }
}