package PAT_A1039_Course_List_for_Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int courseID = scanner.nextInt();
            int stuNum = scanner.nextInt();
            for (int j = 0; j < stuNum; j++) {
                String name = scanner.next();
                if (!hashMap.containsKey(name)) {
                    hashMap.put(name, new ArrayList<>());
                }
                hashMap.get(name).add(courseID);
            }
        }

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            if (hashMap.containsKey(name)) {
                ArrayList<Integer> arrayList = hashMap.get(name);
                Collections.sort(arrayList);
                sb.append(" ").append(arrayList.size());
                for (Integer integer : arrayList) {
                    sb.append(" ").append(integer);
                }
                System.out.println(sb);
            } else {
                System.out.println(name + " 0");
            }
        }
    }
}
