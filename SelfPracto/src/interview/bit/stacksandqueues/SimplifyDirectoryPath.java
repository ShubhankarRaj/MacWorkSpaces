package com.interview.bit.stacksandqueues;

import java.util.ArrayList;
import java.util.Stack;

public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {

        if (A.contains("//"))
            A = A.replaceAll("//", "/");
        String[] arr = A.split("/");
        String returnStr = "";
        Stack<String> returStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) {
                continue;
            } else if (arr[i].contains(".")) {
                if (arr.length == 1 || arr.length == 2)
                    return "/";
                if (arr[i].equals("..")) {
                    if (!returStack.empty())
                        returStack.pop();
                } else
                    continue;

            } else {
                returStack.push(arr[i]);
            }
        }

        if (returStack.size() < 1 || returStack.peek().equals("/"))
            return "/";

        ArrayList<String> list = new ArrayList<>(returStack);
        return "/" + String.join("/", list);
    }

    public static void main(String[] args) {
        SimplifyDirectoryPath obj = new SimplifyDirectoryPath();
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
        System.out.println(obj.simplifyPath("/.."));
        System.out.println(obj.simplifyPath("/"));
        System.out.println(obj.simplifyPath("/../"));
        System.out.println(obj.simplifyPath("/home//foo/"));

        System.out.println(obj.simplifyPath("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."));
    }
}
