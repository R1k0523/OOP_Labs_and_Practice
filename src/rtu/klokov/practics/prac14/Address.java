package rtu.klokov.practics.prac14;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {
        String country;
        String region;
        String city;
        String street;
        String building;
        String corpus;
        String flat;

        public Address(String adress){
            this.setAddress2(adress);
        }


        public void setAddressSplit(String adress) {
            String[] words = adress.split(",");
            country = words[0];
            region = words[1];
            city = words[2];
            street= words[3];
            building = words[4];
            corpus = words[5];
            flat = words[6];
        }


        public void setAddress(String address) {
            Pattern pattern = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(address);
            ArrayList<String> words=new ArrayList<>();
            while (matcher.find())
                words.add(matcher.group());
            country= words.get(0);
            region= words.get(1);
            city= words.get(2);
            street= words.get(3);
            building = words.get(4);
            corpus = words.get(5);
            flat= words.get(6);
        }

        public void setAddress2(String address) {
            StringTokenizer st = new StringTokenizer(address, " .,;-()");
            ArrayList<String> words=new ArrayList<>();
            while (st.hasMoreTokens())
                words.add(st.nextToken());
            country= words.get(0);
            region= words.get(1);
            city= words.get(2);
            street= words.get(3);
            building = words.get(4);
            corpus = words.get(5);
            flat= words.get(6);
        }

        public String toString(){
            return "Страна: "+country+"\nРегион: "+region+"\nГород: "+city+"\nУлица: "+street+"\nДом: "+ building +"\nКорпус: "+ corpus +"\nКвартира: "+flat;
        }
}
