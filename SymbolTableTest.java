package symbolTable;

/**
 * @ClassName SymbolTableTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/9 22:20
 * @Version 1.0
 **/
public class SymbolTableTest {
    public static void main(String[] args) {
        //创建符号表对象
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        //测试put方法
        symbolTable.put(1,"123");
        symbolTable.put(2,"345");
        symbolTable.put(3,"-00042");
        System.out.println(symbolTable.size());
        //测试put替换
        symbolTable.put(1,"23456");
        System.out.println(symbolTable.size());
        //测试get方法
        System.out.println(symbolTable.get(1));
        //测试delete方法
        symbolTable.delete(1);
        System.out.println(symbolTable.size());
    }
}
