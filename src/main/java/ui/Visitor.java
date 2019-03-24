package ui;

import domain.model.PartitaDiCalcio;

public interface Visitor {
    void visit(PartitaDiCalcio categoria);
}
