/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kecuopvatrieuphu;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Tung's PC
 */
public class KeCuopVaTrieuPhu {
    TT bo1 = new TT(0, 1, 0);
    TT kt = new TT(0, 0, 0);
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         KeCuopVaTrieuPhu main = new KeCuopVaTrieuPhu();
        Check check = new Check();
        Boolean exit = true;
       
        HashMap<TT, TT> hashMap = new HashMap<>();
        
        List<TT> L = new ArrayList<>();
        List<TT> Q = new ArrayList<>();
        L.add(main.bo1);
        Q.add(main.bo1);
        while (exit) {
          
            if(L.size() == 0){
                System.out.println("Không tìm thấy!");
                break;
            }     
            TT bo1 = new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen());
            System.out.println("Xét từ Bờ: " + bo1);
            if (main.kt.compareTo(bo1) == 0) {
                
               exit = false;
               main.inKetQua(hashMap);
                break;
            }
      
            if (check.motkecuop(bo1, new TT(3 - bo1.getTrieuphu(), 3 - bo1.getKecuop(), 1 - bo1.getThuyen()), Q) != null) {
                System.out.println("TH 1 ke cuop: " + bo1);
                Q.add(bo1);
                L.add(bo1);
                 hashMap.put(bo1, new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen()));
            }
        
            bo1 = new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen());
              
            if (check.mottrieuphu(bo1, new TT(3 - bo1.getTrieuphu(), 3 - bo1.getKecuop(), 1 - bo1.getThuyen()), Q) != null) {
              System.out.println("TH 1 trieu phu: " + bo1);
                Q.add(bo1);
                L.add(bo1);
                hashMap.put(bo1, new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen()));

            }
            bo1 = new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen());
            if (check.mottrieuphumotkecuop(bo1, new TT(3 - bo1.getTrieuphu(), 3 - bo1.getKecuop(), 1 - bo1.getThuyen()), Q) != null) {
                System.out.println("TH ca 2: " + bo1);
                Q.add(bo1);
                L.add(bo1);
                hashMap.put(bo1, new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen()));

            }
            bo1 = new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen());
            if (check.haikecuop(bo1, new TT(3 - bo1.getTrieuphu(), 3 - bo1.getKecuop(), 1 - bo1.getThuyen()), Q) != null) {
             System.out.println("TH 2 ke cuop: " + bo1);
                Q.add(bo1);
                L.add(bo1);
                hashMap.put(bo1, new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen()));

            }
            bo1 = new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen());
            if (check.haitrieuphu(bo1, new TT(3 - bo1.getTrieuphu(), 3 - bo1.getKecuop(), 1 - bo1.getThuyen()), Q) != null) {
                System.out.println("TH 2 trieu phu: " + bo1);
                Q.add(bo1);
                L.add(bo1);
                hashMap.put(bo1, new TT(L.get(0).getTrieuphu(), L.get(0).getKecuop(), L.get(0).getThuyen()));
                   
            }
             L.remove(0);
//            for (int i = 0; i < Q.size(); i++) {
//                System.out.println("Q: " + Q.get(i));
//            }
//            for (int i = 0; i < L.size(); i++) {
//                System.out.println("L: " + L.get(i));
//            }
            
            
            
        }
       
    }
    
    public void inKetQua(HashMap<TT,TT> hashMap){
            
            ArrayList<TT> list=new ArrayList<>();
            TT current=new TT(0, 0, 0);
            while(current!=null)
            {
                
             list.add(current);
             current=hashMap.get(current);
            
            }
            Collections.reverse(list);
            for (TT tt : list) {
                System.out.print(tt.toString()+"=>");
        }
    }

    void HamDanhGia(TT bo1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
