//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//import java.util.function.Consumer;
//
//public class ProcessFileLambda {
//    public static void main(String[] args) throws IOException {
//        //        String FORMAT = "(.*?)\\s+version\\s*(?:([^(]*?)\\s*(?:\\(\\s*build\\s*([^)]*?)\\s*\\))?)?";
//        //        Pattern PATTERN = Pattern.compile(FORMAT);
//        //        String a = "creator:                         parquet-mr version 1.8.1 (build 4aba4dae7bb0d4edbcf7923ae1339f28fd3f7fcf)";
//        //        Matcher matcher = PATTERN.matcher(a);
//        //        System.out.println("Hello " + matcher.matches());
//
//        System.out.println(processFile(new Main.BufferedReaderInterface() {
//            @Override public String process(BufferedReader bufferedReader) throws IOException {
//                return bufferedReader.readLine().replaceAll("\\p{Cntrl}", "abcd");
//            }
//        }));
//
//
//        //        System.out.println(helper((test) () -> "hello1"));
//        //        forEach(Arrays.asList(1, 2, 3, 4, 5), s -> System.out.println(s));
//        //
//        //        Runnable r = () -> System.out.println("sacsdv");
//        //
//        //        String str = "4312f1191eeb6fb420a7bda13ef0f55a2cbdee7c        tags    acquisition_reftag      ";
//        //
//        //        str.replaceAll("\\p{Cntrl}", "");
//        //        System.out.println(str);
//
//    }
//
//    public static <T> void forEach(List<T> list, Consumer<T> c) {
//        for (T i : list) {
//            c.accept(i);
//        }
//    }
//
//    public static String processFile(Main.BufferedReaderInterface bufferedReaderInterface) throws IOException {
//        try (BufferedReader br = new BufferedReader(new FileReader("/Users/kushagar/Desktop/null.txt"))) {
//            return bufferedReaderInterface.process(br);
//        }
//    }
//
//    @FunctionalInterface interface BufferedReaderInterface {
//        abstract String process(BufferedReader bufferedReader) throws IOException;
//    }
//
//    public static String helper(Main.test test) {
//        return test.process();
//    }
//
//    @FunctionalInterface interface test {
//        abstract String process();
//    }
//}
