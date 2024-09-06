public class conjugations {
    public static String[] present(String dictFormKanji, String pos){


        if (pos == "Ichidan verb"){
            // informal conjugations
            String wordStem = dictFormKanji.substring(0, dictFormKanji.length() - 1); //naive way, maybe check all letters if kanji? (unicode)
            String informalNegative = wordStem + "ない";

            // formal conjugations
            String formalPositive = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            String[] conjugations = {dictFormKanji, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }
        else if (pos == "Godan verb"){


            //String[] conjugations = {dictFormKanji, informalNegative, formalPositive, formalNegative};

            String[] lol = {""};
            
            return lol;
        }

        


        return null;
    }
    
}
