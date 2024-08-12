public class Main {
    public static void main(String[] args) {
        MyService myService = new MyService();

        try {
            myService.performOperation();
        } catch (MyCheckedException e) {
            System.err.println("Caught MyCheckedException: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("abc");
    }
}

