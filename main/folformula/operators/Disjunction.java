package folformula.operators;

import folformula.FOLFormula;

public class Disjunction extends FOLFormula {

    public Disjunction(FOLFormula leftSubFormula, FOLFormula... rightSubformulae) { super(leftSubFormula, rightSubformulae); }

}