package GreedyAlogrithms;


import java.util.*;
class HuffmanNode implements Comparable<HuffmanNode>{
    int data;
    char ch;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int data,char ch) {
        this.data=data;
        this.ch=ch;
        left=null;
        right=null;
    }

    public int compareTo(HuffmanNode n) {
        return this.data-n.data;
    }
}

public class HuffmanCoding {

    static HuffmanNode HuffmanTree(char[]sym,int[]freq) {
        PriorityQueue<HuffmanNode>queue=new PriorityQueue<>();
        for(int i=0;i<sym.length;i++) {
            HuffmanNode n=new HuffmanNode(freq[i],sym[i]);
            queue.add(n);
        }
        HuffmanNode root=null;
        while(queue.size()>1) {
            HuffmanNode n1=queue.poll();
            HuffmanNode n2=queue.poll();
            HuffmanNode mix=new HuffmanNode((n1.data+n2.data),'-');
            mix.left=n1;
            mix.right=n2;
            queue.add(mix);
            root=mix;
        }
        printTree(root,"");
        return root;

    }

    static void printTree(HuffmanNode root,String s) {

        if(root.left==null && root.right==null) {
            System.out.println(root.ch+":"+s);
            return;
        }
        printTree(root.left,s+"0");
        printTree(root.right,s+"1");
    }

    static void decryptMsg(String msg,HuffmanNode root){
       HuffmanNode node=root;
        for(int i=0;i<=msg.length();i++){
            if(node.left==null && node.right==null){
                System.out.print(node.ch);
                node=root;
            }
            if(i<msg.length()){
                if(msg.charAt(i)=='0'){
                    node=node.left;
                }
                else {
                    node=node.right;
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[]sym= {'a','b','c','d','e','f'};
        int[]freq= {15,9,112,53,96,45};
        HuffmanNode root= HuffmanTree(sym,freq);
        decryptMsg("0101011101100",root);

    }

}

