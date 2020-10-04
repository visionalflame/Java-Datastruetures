package mystack;

/**
 * @ClassName RecersePolishNotationTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/6 20:41
 * @Version 1.0
 **/
public class RecersePolishNotationTest {
    public static void main(String[] args) {

        String[] notation={"2","5","61","-","*","16","4","/","+"};
        float result =caculate(notation);
        System.out.println("逆波兰表达式结果："+result);
    }
    /**
     * @Author Visional Flame
     * @Date  2020/7/6
     * @Param [strings]
     * @return int
     * @Description 逆波兰表达式计算
     **/
    public static float caculate(String[] strings){
        //定义一个栈存储操作数
        Stack<Integer> oprands = new Stack<>();
        //从左往右遍历逆波兰表达式，得到元素
        for (int i = 0; i < strings.length; i++) {
            String curr=strings[i];

            //判断元素是运算符还是操作数
            Integer o1;
            Integer o2;
            Integer result;
            switch (curr){
                //运算符，从栈中弹出两个操作数完成运算，把结果压入栈中
                case "+":
                    o1=oprands.pop();
                    o2=oprands.pop();
                    result = o2 + o1;
                    oprands.push(result);
                        break;
                case "-":
                    o1=oprands.pop();
                    o2=oprands.pop();
                    result = o2 -o1;
                    oprands.push(result);
                        break;
                case "*":
                    o1=oprands.pop();
                    o2=oprands.pop();
                    result = o2 * o1;
                    oprands.push(result);
                        break;
                case "/":
                    o1=oprands.pop();
                    o2=oprands.pop();
                    result = o2 / o1;
                    oprands.push(result);
                        break;
                //操作数，把操作数放入栈中
                default:
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }

        //得到栈中最后一个元素，就是结果
        Integer result = oprands.pop();
        return result;
    }
}
