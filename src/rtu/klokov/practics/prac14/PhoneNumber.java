package rtu.klokov.practics.prac14;

public class PhoneNumber {

    int code;
    long number;

    public PhoneNumber(String numbers){
        if (numbers.charAt(0)!='+'){
            code=7;
            this.number=Long.parseLong(numbers.substring(1));
        }else{
            number=Long.parseLong(numbers.substring(numbers.length()-10, numbers.length()));
            code =Integer.parseInt(numbers.substring(0, numbers.length()-10));
        }
    }

    public String toString(){
        return String.format("+%d %d %d %d",code,number/10000000,number%10000000/10000,number%10000);
    }
}
