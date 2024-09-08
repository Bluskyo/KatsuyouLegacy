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

        String[] pastConj = verbConjugations.past("行く","Godan verb");
        for (String con : pastConj){
            System.out.println(con);
        }

    }
}