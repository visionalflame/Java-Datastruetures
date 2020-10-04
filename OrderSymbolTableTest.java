package symbolTable;

/**
 * @ClassName OrderSymbolTableTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/10 0:27
 * @Version 1.0
 **/
public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();
        table.put(1,"张三");
        table.put(2,"李四");
        table.put(4,"王五");
        table.put(5,"赵六");
        table.put(6,"钱七");
        table.put(3,"TEST VALUE");

    }
}
