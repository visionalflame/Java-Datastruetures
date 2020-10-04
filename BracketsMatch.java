package mystack;

/**
 * @ClassName BracketsMatch
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/6 12:13
 * @Version 1.0
 **/
public class BracketsMatch {
    public static void main(String[] args) {
        String str="(上海()))";
        boolean match=isMatch(str);
        System.out.println(str+"是否匹配？"+match);

    }
    public static boolean isMatch(String string){
        //创建栈对象，存储左括号
        Stack<String> chars = new Stack<>();
        //从左往右遍历字符串
        for (int i = 0; i < string.length(); i++) {
            String currChar = string.charAt(i)+"";

            //判断当前字符是否为左括号，是则放入栈中
            if (currChar.equals("(")) {
                chars.push(currChar);
            }else if (currChar.equals(")")) {
                //判断是否有右括号，是则弹出一个左括号，判断是否为null，如果是null则证明没有匹配的左括号，不为null证明还有匹配的左括号
                String pop=chars.pop();
                if (pop == null) {
                    return false;
                }
            }
        }

        //判断栈中有没有剩余左括号，如果有则证明括号不匹配，返回false
        if (chars.size() == 0) {
            return true;
        }else {
        return false;
        }
    }
}
