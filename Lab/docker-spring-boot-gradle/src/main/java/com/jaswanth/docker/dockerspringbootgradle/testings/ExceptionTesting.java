package com.jaswanth.docker.dockerspringbootgradle.testings;

public class ExceptionTesting {
    public static void main(String[] args) {
        
        try{
            throw new Exception("Exception formed");
        }
        catch(Exception e){
            e.printStackTrace();;
        }
        finally{
            System.out.println("In Finally Block ");
        }
        System.out.println("After  finally block");



    }
    
}
