package JavaCore_10_1_JVM;

public class JvmComprehension {
    // Класс JvmComprehension отдается для загрузки в систему загрузчиков классов ClassLoader
    // перемещается в область памяти Metaspace, где хранятся данных о классе JvmComprehension.
    public static void main(String[] args) { // В момент вызова метода main создается фрейм в стеке.
        int i = 1;                      // 1 Во фрейме main создается переменная i со значением 1.
        Object o = new Object();        // 2 В heap создается объект Object, во фрейме main создается переменная o, ей присваивается ссылка на этот объект.
        Integer ii = 2;                 // 3 В heap создается объект Integer со значением 2, а во фрейме main появляется переменная ii со ссылкой на этот объект.
        printAll(o, i, ii);             // 4 В stack создается фрейм printAll и в нем записываются переменные  o, i и ii.
        System.out.println("finished"); // 7 В stack создается фрейм println, которому передается ссылка на созданный в куче объект "finished".
        // Garbage Collector.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В heap создается объект Integer со значением 700, а во фрейме printAll появляется переменная uselessVar 
                                                    // со ссылкой на этот объект.
        System.out.println(o.toString() + i + ii);  // 6 В stack создается фрейм println, куда передаются ссылки на o, i и ii.  
                                                    // В stack созается фрейм toString.
    }
}
