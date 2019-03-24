package domain.eventi;

import domain.model.Proposta;

public interface CreatoreProposta {
    void onCreazioneProposta(Proposta proposta);
}
