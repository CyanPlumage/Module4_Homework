package Homework1;

public class WorkerTest {
    public static void main(String[] args) {

        //
        Worker w1 = null;
        try {
            w1 = new Worker("", 16);
        } catch (AgeException e) {
            e.printStackTrace();
        } catch (NullException e) {
            e.printStackTrace();
        } finally {
            System.out.println("w1 = " + w1);
        }
    }
}
