package br.com.petfriends.domain.events;

import java.time.LocalDateTime;
import java.util.UUID;

public class AgendamentoConfirmadoEvent {

    private final Long agendamentoId;
    private final UUID clienteId;
    private final Long lojaId;
    private final LocalDateTime dataConfirmacao;

    public AgendamentoConfirmadoEvent(Long agendamentoId, UUID clienteId, Long lojaId) {
        this.agendamentoId = agendamentoId;
        this.clienteId = clienteId;
        this.lojaId = lojaId;
        this.dataConfirmacao = LocalDateTime.now();
    }

    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public Long getLojaId() {
        return lojaId;
    }

    public LocalDateTime getDataConfirmacao() {
        return dataConfirmacao;
    }
}