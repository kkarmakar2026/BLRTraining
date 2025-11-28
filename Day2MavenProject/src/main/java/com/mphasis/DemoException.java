package com.mphasis;


class DemoException{
    public static void main(String[] args) {
        String str = null; // str is not pointing to any object

        try {
            // This will throw NullPointerException
            str.equals("Hello");
        } catch (NullPointerException npe) {
            System.out.println("Caught NullPointerException: " + npe.getMessage());
            npe.printStackTrace();
        }

        System.out.println("Program continues after handling exception.");
    }
}


    
        
//        catch (ArithmeticException ae) {
//            System.out.println("ArithmeticException caught: Division by zero!");
//            ae.printStackTrace();
//        } catch (RuntimeException re) {
//            System.out.println("RuntimeException caught: " + re);
//        } catch (Exception e) {
//            System.out.println("General Exception caught: " + e);
//        } finally {
//            System.out.println("Finally block called");
//        }

//        System.out.println("Application closed successfully");
//    }

