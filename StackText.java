package mystack;

/**
 * @ClassName StackText
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/6 10:41
 * @Version 1.0
 **/
public class StackText {
    public static void main(String[] args) {
        //创建栈对象
        Stack<String> stack = new Stack<>();
        //测试压栈
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        for (String item:stack
             ) {
            System.out.println(item);
        }
        System.out.println("---------------");
        //测试弹栈
        String result = stack.pop();
        System.out.println("弹出"+result);
        System.out.println("剩余个数"+stack.size());
    }
}
