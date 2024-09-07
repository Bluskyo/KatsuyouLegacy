public class conjugations {
    public static String[] present(String kanji, String pos){

        String wordStem = kanji.substring(0, kanji.length() - 1); //Creates string without last hiragana in word.

        if (pos == "Ichidan verb"){
            // informal conjugations
            String informalNegative = wordStem + "ない";

            // formal conjugations
            String formalPositive = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            String[] conjugations = {kanji, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }
        else if (pos == "Godan verb"){ 

            int nextHiragana = kanji.charAt(kanji.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            int nextHiraganaFormal = kanji.charAt(kanji.length() - 1 ) - 2; // finds next hiragana of conjugation.
            char formalStem = (char)nextHiraganaFormal;

            char hiragana = kanji.charAt(kanji.length() - 1);

            // u, tsu, ru verbs have different unicode than ku, gu, su verbs.
            switch (hiragana) {
                case 'う':
                    stem  = 'わ';
                    break;
                case 'つ':
                    stem = 'た';
                    formalStem  = 'ち';
                    break;
                case 'る':
                    stem = 'ら';
                    formalStem  = 'り';
                    break;
                default:
                    break;
            }

            String informalNegative = wordStem + stem + "ない";
            String formalPositive = wordStem + formalStem + "ます";
            String formalNegative = wordStem + formalStem + "ません";

            String[] conjugations = {kanji, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }

        else if (pos == "Suru verb" || pos == "Kuru verb"){
            String informalNegative = wordStem + "ない";
            String formalPositive = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            String[] conjugations = {kanji, informalNegative, formalPositive, formalNegative};

            return conjugations;
        }
        else if (pos == "Kuru verb"){
            System.out.println("");
        }

        return null;
    }
    

}
