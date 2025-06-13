package BasicAlgorithms.BigIntCalc;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = new BigInteger(scanner.next());

        BigInteger b = new BigInteger(scanner.next());
        
        // 读取进制（可选，默认为10）
        int radix = 10;
        try {
            String radixStr = scanner.nextLine();
            if (!radixStr.isEmpty()) {
                radix = Integer.parseInt(radixStr);
            }
        } catch (NumberFormatException e) {
            System.out.println("无效的进制，使用默认值10");
        }
        
        // 加法运算
        BigInteger sum = a.add(b);
        System.out.println("a + b = " + sum.toString(radix));
        
        // 减法运算
        BigInteger diff = a.subtract(b);
        System.out.println("a - b = " + diff.toString(radix));
        
        // 乘法运算
        BigInteger product = a.multiply(b);
        System.out.println("a * b = " + product.toString(radix));
        
        // 除法运算
        if (b.equals(BigInteger.ZERO)) {
            System.out.println("a / b = Inf");
        } else {
            BigInteger[] result = a.divideAndRemainder(b);
            System.out.println("a / b = " + result[0].toString(radix) + " ... " + result[1].toString(radix));
        }
        
        // 比较大小
        int cmpResult = a.compareTo(b);
        if (cmpResult > 0) {
            System.out.println("a > b");
        } else if (cmpResult < 0) {
            System.out.println("a < b");
        } else {
            System.out.println("a = b");
        }
        
        scanner.close();
    }
}