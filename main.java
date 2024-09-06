
public class main {
    public static void main(String... args){
        // Innit database: 
        //innitDB.start("JMdict_e", "jdbc:mysql://localhost:3307/JMDict", "root", "");

        String[][] n5Verbs = JLPT_Lists.n5List();

        String[] presentConj = conjugations.present(n5Verbs[3][0], n5Verbs[3][2]);

        for (String con : presentConj){
            System.out.println(con);
        }

        String kanji = "聞く";


        int kanjiStem = kanji.charAt(kanji.length() - 1 ) - 14;

        System.out.println(kanjiStem);
        
       


        //System.out.println(kanjiStem - 4);



        

    }
}