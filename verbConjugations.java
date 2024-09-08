public class verbConjugations {
    public static String[] present(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos)){ // Ru-Verbs
            // informal conjugations
            String informalNegative = wordStem + "ない";

            // formal conjugations
            String formalPositive = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            String[] conjugations = {plainForm, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }
        else if ("Godan verb".equals(pos)){ // U-Verbs

            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            int nextHiraganaFormal = plainForm.charAt(plainForm.length() - 1 ) - 2; // finds next hiragana of conjugation.
            char formalStem = (char)nextHiraganaFormal;

            // u, tsu, ru, mu verbs have different unicode than ku, gu, su verbs.
            char hiragana = plainForm.charAt(plainForm.length() - 1);

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

            String[] conjugations = {plainForm, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }

        else if ("Suru verb".equals(pos) || "Kuru verb".equals(pos)){
            String informalNegative = wordStem + "ない";
            String formalPositive = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            String[] conjugations = {plainForm, informalNegative, formalPositive, formalNegative};

            return conjugations;
        }

        return null;
    }
    public static String[] past(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos)){
            // informal conjugations
            String informalPlain = wordStem + "た";
            String informalNegative = wordStem + "なかった";

            // formal conjugations
            String formalPositive = wordStem + "ました";
            String formalNegative = wordStem + "ませんでした";

            String[] conjugations = {informalPlain, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }
        else if ("Godan verb".equals(pos)){

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            int nextHiraganaFormal = plainForm.charAt(plainForm.length() - 1 ) - 2; // finds next hiragana of conjugation.
            char formalStem = (char)nextHiraganaFormal;

            String ending = "";

            switch (hiragana) {
                case 'す' -> {
                    ending = "した";
                }
                case 'く', 'ぐ' -> {
                    if (hiragana == 'ぐ'){
                        ending = "いだ";
                    }
                    else {
                        ending = "いた";
                    }
                }
                case 'む', 'ぬ'-> { 
                    ending = "んだ";
                    stem += 2;
                    formalStem += 1;
                }
                case 'ぶ' -> {
                    ending = "んだ";
                    stem = 'ば';
                    formalStem = 'び';
                }
                case 'る' -> {
                    ending = "った";
                    stem = 'ら';
                    formalStem = 'り';
                }
                case 'う' -> {
                    ending = "った";
                    stem = 'わ';
                    formalStem = 'い';
                }
                case 'つ' -> {
                    ending = "った";
                    stem = 'た';
                    formalStem = 'ち';
                }
                default -> {
                }
                
            }

            if ("行く".equals(plainForm)){
                ending = "った";
            }

            String informalPlain = wordStem + ending;
            String informalNegative = wordStem + stem + "なかった";
            String formalPositive = wordStem + formalStem +"ました";
            String formalNegative = wordStem + formalStem +"ませんでした";

            String[] conjugations = {informalPlain, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }
        else if ("Suru verb".equals(pos) || "Kuru verb".equals(pos)){

            String informalPlain = wordStem + 'た';
            String informalNegative = wordStem + "なかった";
            String formalPositive = wordStem + "ました";
            String formalNegative = wordStem + "ませんでした";

            String[] conjugations = {informalPlain, informalNegative, formalPositive, formalNegative};

            return conjugations;
        }

        return null;
    }

    

    

}
