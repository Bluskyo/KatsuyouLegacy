
public class main {
    public static void main(String... args){
        // Innit database: 
        //innitDB.start("JMdict_e", "jdbc:mysql://localhost:3307/JMDict", "root", "");

        String[][] n5Verbs = JLPT_Lists.n5List();

        String[] presentConj = conjugations.present(n5Verbs[0][0], n5Verbs[0][2]);

        for (String con : presentConj){
            System.out.println(con);
        }


    }
}