public class Main {
    public static void main(String... args){
        // Innit database: 
        //innitDB.start("JMdict_e", "jdbc:mysql://localhost:3307/JMDict", "root", "");

        //String[][] n5Verbs = JLPT_Lists.n5List();

        //String[] presentConj = verbConjugations.present(n5Verbs[testKanji][0], n5Verbs[testKanji][2]);
        //String[] presentConj = verbConjugations.present("聞く","Godan verb"); 
        //for (String con : presentConj){
        //    System.out.println(con);
        //}

        //String[] conj = conjugations.past("行く","Godan verb");
        //for (String con : conj){
        //    System.out.println(con);
        //}

        //String[] conj = conjugations.teForm("頑張る","Godan verb");
        //for (String con : conj){
        //    System.out.println(con);
        //}

        //String[] conj = conjugations.potential("泳ぐ", "Godan verb");
        //for (String con : conj){
        //    System.out.println(con);
        //}

        String[] godanVerbs = {"会う", "立つ","写す","割る","書く","泳ぐ","死ぬ","学ぶ","休む"};

        for (String word: godanVerbs) {
            String[] conj = conjugations.volitional(word, "Godan verb");

            for (String con : conj){
                System.out.println(con);
            }
            System.out.println("");

        }


    }
}