package folformula;

import folformula.tree.Tree;
import folformula.writers.CollectRelations;
import folformula.writers.TFFWriter;
import folformula.writers.TPTPWriter;
import folformula.writers.LaTeXWriter;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class FOLFormula extends Tree {

    /**
     * the name of a FOL Formula is only != null if it is a Variable.
     * */
    private String name;


    //////////////////
    // CONSTRUCTORS
    ////////////////

    // for top and bottom:
    public FOLFormula(){}

    // for variables:
    public FOLFormula(String name){
        super();
        this.name = name;
    }

    // for unary operators:
    public FOLFormula(FOLFormula subFormula){
        addChild(subFormula);
        this.name = null;
    }

    public FOLFormula(FOLFormula leftSubFormula, FOLFormula... rightSubformulae){
        addChild(leftSubFormula);
        for (FOLFormula rightSubformula : rightSubformulae){
            addChild(rightSubformula);
        }
        this.name = null;
    }

    public FOLFormula(ArrayList<FOLFormula> subFormulae){
        for (FOLFormula sub : subFormulae){
            addChild(sub);
        }
    }




    public String getName() { return name; }


    /**
     * @return a string which can directly be fed to Vampire as input (after first being written to a .p file).
     *
     * the "role" of the TPTP fof formula is negated_conjecture because Vampire assumes there to be a set of axioms;
     * Vampire answers the question: does the given conjecture follow from the axioms. Hence, Vampire returns
     * the satisfiability of the NEGATED conjecture (conjoined with axioms if given). This is avoided here by already
     * negating the input conjecture.
     * */
    public String writeToFOF(){
        TPTPWriter tptpWriter = new TPTPWriter();

        String tptpString = "fof(cfge, negated_conjecture, ";

        return tptpString + tptpWriter.visitChildrenRecursively(this) + " ).";
    }

    public String writeToTFF(){
        TFFWriter tffWriter = new TFFWriter();
        CollectRelations collectRelations = new CollectRelations();

        HashSet<String> tffStrings = collectRelations.visitChildrenRecursively(this);

        String tffString = "";

        for (String string : tffStrings)
            tffString += string;

        tffString += "tff(cfge, negated_conjecture, ";

        return tffString + tffWriter.visitChildrenRecursively(this) + " ).";
    }

    public String writeToLaTeX(){
        LaTeXWriter laTeXWriter = new LaTeXWriter();

        return "\\[ \n" +  laTeXWriter.visitChildrenRecursively(this) + "\n \\]";
    }

}