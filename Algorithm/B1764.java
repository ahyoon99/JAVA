package Algorithm;

import java.util.*;

public class B1764 {

    static class Person{
        boolean isSeen;
        boolean isHeard;

        Person(){}
        Person(boolean isSeen, boolean isHeard){
            this.isSeen=isSeen;
            this.isHeard=isHeard;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Person> personList = new HashMap<>();
        for(int i=0;i<n;i++){
            String name = sc.next();
            personList.put(name, new Person(true, false));
        }

        int cnt=0;
        for(int i=0;i<m;i++){
            String name = sc.next();
            if(personList.containsKey(name)){
                Person p = personList.get(name);
                p.isHeard=true;
                personList.put(name, p);
                cnt++;
            }
            else{
                personList.put(name, new Person(false, true));
            }
        }

        List<String> keySet = new LinkedList<>(personList.keySet());
        Collections.sort(keySet);

        System.out.println(cnt);
        for(String key : keySet){
            Person p = personList.get(key);
            if(p.isSeen==true && p.isHeard==true){
                System.out.println(key);
            }
        }
    }
}
