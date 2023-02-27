package Algorithm;

import java.util.*;

public class B1181 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(sc.next());
        }

        Set<String> set = new HashSet<String>(list);
        List<String> newList = new ArrayList<String>(set);

        Collections.sort(newList);
        newList.sort(Comparator.comparing(String::length));

        for(int i=0;i<newList.size();i++){
            System.out.println(newList.get(i));
        }
    }
    
}
