package com.shreypandya.cryptocoin;
 
import java.util.ArrayList;
 
public class Main {
     
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static String previousHash = "0";
    public static int difficulty = 5;
     
    public static void main(String[] args) {
         
        blockchain.add(new Block("First block", "0"));
        blockchain.get(0).mineBlock(difficulty);
        
        System.out.println(isChainValid());
         
    }
     
    public static boolean isChainValid() {
         
        Block currentBlock;
        Block previousBlock;
         
        for (int i = 1; i < blockchain.size(); i++) {
             
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
             
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                 
                System.out.println("Current hashes not equal");
                return false;
                 
            }
             
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                 
                System.out.println("Previous hashes not equal");
                return false;
                 
            }
             
        }
         
        return true;
         
    }
 
}