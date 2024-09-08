public class conjugations {
    public static String[] present(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos)){ // Ru-Verbs
            String informalNegative = wordStem + "ない";
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

        if ("Ichidan verb".equals(pos) || ("Suru verb".equals(pos) || "Kuru verb".equals(pos))){
            String informalPlain = wordStem + "た";
            String informalNegative = wordStem + "なかった";
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
                case 'う' -> {
                    ending = "った";
                    stem = 'わ';
                    formalStem = 'い';
                }
                case 'く' ->{
                    if ("行".equals(wordStem)){ // 行った is an exception in this conjugation.
                        ending = "った";
                    }else{
                        ending = "いて";
                    }
                }
                case 'ぐ' -> {
                    ending = "いだ";
                }
                case 'す' -> {
                    ending = "した";
                }
                case 'つ' -> {
                    ending = "った";
                    stem = 'た';
                    formalStem = 'ち';
                }
                case 'ぬ', 'む'-> { 
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
                default -> {
                }
                
            }

            String informalPlain = wordStem + ending;
            String informalNegative = wordStem + stem + "なかった";
            String formalPositive = wordStem + formalStem +"ました";
            String formalNegative = wordStem + formalStem +"ませんでした";

            String[] conjugations = {informalPlain, informalNegative, formalPositive, formalNegative};
            
            return conjugations;
        }

        return null;
    }

    public static String[] teForm(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Suru verb".equals(pos) || "Kuru verb".equals(pos) ){

            String positiveForm = wordStem + "て";
            String negativeForm = wordStem + "なくて";
            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;

        }
        else if ("Godan verb".equals(pos)){

            char hiragana = plainForm.charAt(plainForm.length() - 1);
            String ending = "";

            switch (hiragana) {
                case 'す'->{
                    ending = "して";
                }
                case 'く'->{
                    if ("行".equals(wordStem)){ // 行って is an exception in this conjugation.
                        ending = "って";
                    }else{
                        ending = "いて";
                    }
                }
                case 'ぐ'->{
                    ending = "いで";
                }
                case 'ぬ', 'ぶ', 'む'->{
                    ending = "んで";
                }
                case 'う', 'つ', 'る' ->{
                    ending = "って";
                }
            }

            String positiveForm = wordStem + ending;
            String negativeForm = wordStem + "なくて";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }

        return null;
    }

    public static String[] potential(String plainForm, String pos){ 

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Kuru verb".equals(pos)){
            String positiveForm = wordStem + "られる";
            String negativeForm = wordStem + "られない";
            String formalPositive = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;
            
            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ','む', 'る' -> {
                    stem -= 1;
                }
                case 'ぶ' -> {
                    stem = 'べ';
                }
            }

            String positiveForm = wordStem + stem + "る";
            String negativeForm = wordStem + stem + "ない";
            String formalPositive = wordStem + stem + "ます";
            String formalNegative = wordStem + stem + "ません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Suru verb".equals(pos)){
            String positiveForm = "できる";
            String negativeForm = "できない";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }

        return null;
    }
    
    

}
