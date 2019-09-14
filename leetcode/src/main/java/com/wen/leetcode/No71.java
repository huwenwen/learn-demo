package com.wen.leetcode;

import java.util.LinkedList;

/**
 * @author huwenwen
 * @since 2019/9/10
 */
public class No71 {

    public String simplifyPath(String path){
        LinkedList<String> queue = new LinkedList<>();
        for (String s : path.split("/")) {
            if("..".equals(s) && !queue.isEmpty()){
                queue.pop();
                continue;
            }
            if(!".".equals(s) && !"".equals(s) && !"..".equals(s)){
                queue.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true){
            if(queue.isEmpty()){
                break;
            }
            sb.append("/").append(queue.pop());
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        System.out.println(new No71().simplifyPath("/home/"));
    }


}
