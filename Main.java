public class Main {
    public static void main(String... args){
        // Innit database: 
        //innitDB.start("JMdict_e", "jdbc:mysql://localhost:3307/JMDict", "root", "");
        //test.testDB("jdbc:mysql://localhost:3308/BookStore", "root", "");

        //String[][] n5Verbs = JLPT_Lists.n5List();


        String[] godanVerbs = {"会う", "立つ","写す","割る","書く","泳ぐ","死ぬ","学ぶ","休む"};
        String[] ichiVerb = {"食べる"};
        String[] suruVerb = {"為る"};
        String[] kuruVerb = {"来る"};
        //String[] presentConj = verbConjugations.present(n5Verbs[testKanji][0], n5Verbs[testKanji][2]);


        // PRESENT
        //System.out.println("PRESENT:");
        //for (String word : godanVerbs) {
        //    String[] conju = Conjugations.present(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conju){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // PAST
        //System.out.println("PAST:");
        //for (String word : godanVerbs) {
        //    String[] conju = Conjugations.past(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conju){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // TE FORM
        //System.out.println("TE FORM:");
        //for (String word : godanVerbs) {
        //    String[] conju = Conjugations.teForm(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conju){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // POTENTIAL 
        //System.out.println("POTENTIAL:");
        //for (String word : godanVerbs) {
        //    String[] conju = Conjugations.potential(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conju){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // VOLITIONAL
        //for (String word: godanVerbs) {
        //    String[] conj = Conjugations.volitional(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conj){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // PASSIVE 
        //System.out.println("PASSIVE:");
        //for (String word : godanVerbs) {
        //    String[] conj = Conjugations.passive(word, "Godan verb");
        //  System.out.println(word);
        //    for (String con : conj){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // CAUSATIVE
        //System.out.println("CAUSATIVE:");
        //for (String word : godanVerbs) {
        //    String[] conj = Conjugations.causative(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conj){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // CAUSATIVE PASSIVE 
        //System.out.println("CAUSATIVE PASSIVE :");
        //for (String word : godanVerbs) {
        //    String[] conj = Conjugations.causativePassive(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conj){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // IMPERATIVE
        //System.out.println("IMPERATIVE:");
        //for (String word : kuruVerb) {
        //    String[] conj = Conjugations.imperative(word, "Godan verb");
        //    System.out.println(word);
        //    for (String con : conj){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // CONDITIONAL
        System.out.println("CONDITIONAL:");
        for (String word : godanVerbs) {
            String[] conj = Conjugations.conditional(word, "Godan verb");
            System.out.println(word);
            for (String con : conj){
                System.out.println(con);
            }
            System.out.println("");
        }

    }
        
}