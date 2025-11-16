package br.com.petfriends.domain.events;

import br.com.petfriends.domain.events.AbstractDomainEvent;
import java.util.UUID;

public class AssinaturaDeRacaoCriadaEvent extends AbstractDomainEvent {


    private final UUID assinaturaId;
    private final UUID clienteId;
    private final String periodicidade;
    private final String tipoAnimal;

    public AssinaturaDeRacaoCriadaEvent(UUID assinaturaId, UUID clienteId, String periodicidade, String tipoAnimal) {
        super();
        this.assinaturaId = assinaturaId;
        this.clienteId = clienteId;
        this.periodicidade = periodicidade;
        this.tipoAnimal = tipoAnimal;
    }

    public UUID getAssinaturaId() {
        return assinaturaId;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }
}