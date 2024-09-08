public class conjugations {
    public static String[] present(String kanji, String pos){

        String wordStem = kanji.substring(0, kanji.length() - 1); //Creates string without last hiragana in word.

        if (pos == "Ichidan verb"){ // Ru-Verbs
            // informal conjugations
            String informalNegative = wordStem + "ない";

            // formal conjugations
            String formalPositive = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            String[] conjugations = {kanji, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }
        else if (pos == "Godan verb"){ // U-Verbs

            int nextHiragana = kanji.charAt(kanji.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            int nextHiraganaFormal = kanji.charAt(kanji.length() - 1 ) - 2; // finds next hiragana of conjugation.
            char formalStem = (char)nextHiraganaFormal;

            // u, tsu, ru, mu verbs have different unicode than ku, gu, su verbs.
            char hiragana = kanji.charAt(kanji.length() - 1);

            switch (hiragana) {
                case 'う' -> stem  = 'わ';
                case 'つ' -> {
                    stem = 'た';
                    formalStem  = 'ち';
                }
                case 'る' -> {
                    stem = 'ら';
                    formalStem  = 'り';
                }
                case 'む' -> {
                    stem = 'ま';
                    formalStem  = 'み';
                }
                default -> {
                }
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

        return null;
    }

    public static String[] past(String kanji, String pos){

        String wordStem = kanji.substring(0, kanji.length() - 1); //Creates string without last hiragana in word.

        if (pos == "Ichidan verb"){
            // informal conjugations
            String informalPositive = wordStem + "た";
            String informalNegative = wordStem + "なかった";

            // formal conjugations
            String formalPositive = wordStem + "ました";
            String formalNegative = wordStem + "ませんでした";

            String[] conjugations = {informalPositive, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }
        else if (pos == "Godan verb"){

            char hiragana = kanji.charAt(kanji.length() - 1);

            String informalPositive = "";
            String informalNegative = "";
            String formalPositive = "";
            String formalNegative = "";

            switch (hiragana) {
                case 'す' -> {
                    // informal conjugations
                    informalPositive = wordStem + "した";
                    informalNegative = wordStem + "さなかった";
                    // formal conjugations
                    formalPositive = wordStem + "しました";
                    formalNegative = wordStem + "しませんでした";
                }
                case 'く', 'ぐ' -> {
                    // informal conjugations
                    informalPositive = wordStem + "いた";
                    if (hiragana == 'ぐ'){
                        informalPositive = wordStem + "いだ";
                    }
                    informalNegative = wordStem + "かなかった";
                    // formal conjugations
                    formalPositive = wordStem + "きました";
                    formalNegative = wordStem + "きませんでした";
                }
                case 'む', 'ぶ', 'ぬ' -> {
                    // informal conjugations
                    informalPositive = wordStem + "んだ";
                    informalNegative = wordStem + "さなかった";
                    // formal conjugations
                    formalPositive = wordStem + "しました";
                    formalNegative = wordStem + "しませんでした";
                }
                case 'る', 'う', 'つ' -> System.out.println("");
                default -> {
                }
            }


            String[] conjugations = {informalPositive, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }


        return null;
    }

    

    

}
