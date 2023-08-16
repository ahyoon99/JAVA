package Algorithm;

import java.util.*;

public class P17686 {
    static class File{
        String head;
        String number;
        String tail;
        
        File(){}
        File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    static public void main(String args[]){
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        
        String[] result = solution(files);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    
    static public String[] solution(String[] files) {
        
        ArrayList<File> fileList = new ArrayList<>();
        
        for(int i=0;i<files.length;i++){
            String temp = files[i];
            boolean first = false;
            String head = "";
            int numberIdx = -1;
            String number= "";
            String tail = "";
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j)>='0' && temp.charAt(j)<='9'){
                    if(!first){
                        head = temp.substring(0,j);
                        numberIdx=j;
                        first = true;
                    }
                    if(first){
                        if(j==temp.length()-1){
                            number = temp.substring(numberIdx, j+1);
                        }
                        else if((temp.charAt(j+1)<'0' || temp.charAt(j+1)>'9')){
                            number = temp.substring(numberIdx, j+1);
                            tail = temp.substring(j+1, temp.length());
                            break;
                        }
                    }
                }
                
            }
            
            fileList.add(new File(head, number, tail));
        }
        
        fileList.sort((o1, o2) -> {
            int num1 = Integer.parseInt(o1.number);
            int num2 = Integer.parseInt(o2.number);
            if(o1.head.toLowerCase().equals(o2.head.toLowerCase())){
                if(num1 == num2){
                    return 0;
                }
                else{
                    return num1 - num2;
                }
            }
            return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
        });
    
        String[] answer = new String[fileList.size()];
        
        for(int i=0;i<fileList.size();i++){
            File f = fileList.get(i);
            String origin = "";
            origin += f.head;
            origin += f.number;
            origin += f.tail;
            answer[i]=origin;
        }
        return answer;
    }
}
