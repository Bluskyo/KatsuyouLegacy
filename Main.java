public class Main {
    public static void main(String... args){
        // Innit database: 
        //innitDB.start("JMdict_e", "jdbc:mysql://localhost:3307/JMDict", "root", "");
        //test.testDB("jdbc:mysql://localhost:3308/BookStore", "root", "");

        //String[][] n5Verbs = JLPT_Lists.n5List();


        String[] godanVerbs = {"会う", "立つ","写す","割る","書く","泳ぐ","死ぬ","学ぶ","休む"};
        //String[] presentConj = verbConjugations.present(n5Verbs[testKanji][0], n5Verbs[testKanji][2]);


        // PRESENT
        //String[] presentConj = verbConjugations.present("聞く","Godan verb"); 
        //for (String con : presentConj){
        //    System.out.println(con);
        //}

        // PAST
        //String[] conj = conjugations.past("行く","Godan verb");
        //for (String con : conj){
        //    System.out.println(con);
        //}

        // TE FORM
        //String[] conj = conjugations.teForm("頑張る","Godan verb");
        //for (String con : conj){
        //    System.out.println(con);
        //}

        // POTENTIAL 
        //System.out.println("POTENTIAL:");
        //for (String word : godanVerbs) {
        //String[] conju = conjugations.potential(word, "Godan verb");
        //for (String con : conju){
        //    System.out.println(con);
        //}
        //System.out.println("");
        //}

        // VOLITIONAL
        //for (String word: godanVerbs) {
        //    String[] conj = conjugations.volitional(word, "Godan verb");
        //    for (String con : conj){
        //        System.out.println(con);
        //    }
        //    System.out.println("");
        //}

        // PASSIVE 
        System.out.println("PASSIVE:");
        for (String word : godanVerbs) {
            String[] conj = conjugations.passive(word, "Suru verb");
            for (String con : conj){
                System.out.println(con);
            }
            System.out.println("");
        }

    }
        
}