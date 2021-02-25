package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WhoIsWinner {
    public void check(String[] in){
        Map<String, Integer> m = new HashMap<>(); // мапа для определения макс кол-ва баллов
        for(int i = 0; i < in.length; i++){
            String[] tmp = in[i].split(" ");
            if(m.containsKey(tmp[0]))
                m.put(tmp[0], m.get(tmp[0]) + Integer.parseInt(tmp[1]));
            else
                m.put(tmp[0], Integer.parseInt(tmp[1]));// tmp0 - user tmp1 - score
        }

        Map<String, Integer> out = new HashMap<>(); //мапа для определения 1го набравшего макс кол-ва баллов
        for(int i = 0; i < in.length; i++){
            String[] tmp = in[i].split(" ");
            if(out.containsKey(tmp[0])) {
                if((out.get(tmp[0]) + Integer.parseInt(tmp[1])) == Collections.max(m.values())){
                    /*Если на текущем шаге игрок набирает макс, то выводим результат и заканчиваем работу с мап */
                    System.out.println(tmp[0] + " " + Collections.max(m.values()));
                    break;
                }
                out.put(tmp[0], out.get(tmp[0]) + Integer.parseInt(tmp[1]));

            }
            else {
                if(out.get(tmp[0]) == Collections.max(m.values())){
                    /*Если на текущем шаге игрок набирает макс, то выводим результат и заканчиваем работу с мап */
                    System.out.println(tmp[0] + " " + Collections.max(m.values()));
                    break;
                }
                out.put(tmp[0], Integer.parseInt(tmp[1]));
            }
        }
    }
}
