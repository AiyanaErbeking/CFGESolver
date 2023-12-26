import cfg.ContextFreeGrammar;
import cfg.ReductionCfgeToFolSat;
import org.junit.Test;

import java.util.*;

public class ReductionCfgeSatTest {

    public ReductionCfgeToFolSat reductionCfgeToFolSat = new ReductionCfgeToFolSat();



    @Test
    public void  testReduction(){

        // Creating a map of rules
        Map<String, Set<List<String>>> rulesMap = new HashMap<>();

        // Adding rules for variable 'S'
        Set<List<String>> sRules = new HashSet<>();
        sRules.add(Arrays.asList("a", "A", "b"));
        sRules.add(Arrays.asList("c", "S", "a"));
        sRules.add(List.of("A"));
        rulesMap.put("S", sRules);

        // Adding rules for variable 'A'
        Set<List<String>> aRules = new HashSet<>();
        aRules.add(Collections.singletonList("b"));
        aRules.add(Arrays.asList("y", "A", "z"));
        aRules.add(Collections.singletonList("ε"));
        rulesMap.put("A", aRules);

        // Creating an instance of ContextFreeGrammar
        ContextFreeGrammar grammar = new ContextFreeGrammar("ExampleGrammar", rulesMap);

        grammar.toChomskyNormalForm();
        System.out.println("Grammar Name: " + grammar.getName());
        System.out.println("Rules:");
        for (Map.Entry<String, Set<List<String>>> entry : grammar.getRules().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println(grammar.getAlphabet());


        //System.out.println(reductionCfgeToFolSat.encodingWordStructure(C1, C2).writeToTPTP());
        //System.out.print(reductionCfgeToFolSat.subwordsLengthOne(C1.getVariables(), C1.getRules(), C1.getName()).writeToTPTP());
        //System.out.println(reductionCfgeToFolSat.encodingGrammarInequivalence(C1, C2).writeToTPTP());
        //System.out.println(reductionCfgeToFolSat.subwordsGreaterOne(C1.getVariables(), C1.getRules(), C1.getName()).writeToTPTP());
        //System.out.println(reductionCfgeToFolSat.encodingCYKTable(C2).writeToTPTP());
        //System.out.println(reductionCfgeToFolSat.reduce(C1, C2).writeToTPTP());

        //VampireHandler vampireHandler = new VampireHandler();

        //vampireHandler.runVampire("20", Boolean.TRUE);


        /*String grammarString = "S -> a S b | A | B | ?\n" +
                    "A -> a A a | C\n" +
                    "B -> b B b | C\n" +
                    "C -> b C a | ?";
        */
        //CFGParser.parseGrammarString(grammarString).getAlphabet();

        //SelectingCFGPairs selectingCFGPairs = new SelectingCFGPairs();
        //selectingCFGPairs.readCSVFile();
    }

}
