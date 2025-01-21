package PAT_A1157_Anniversary;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> alumniSet = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String id = br.readLine().trim();
            alumniSet.add(id);
        }

        int m = Integer.parseInt(br.readLine());
        final int INF = 0x3f3f3f3f;
        String oldestAlumni = "";
        String oldestGuest = "";
        int oldestAlumniDate = INF;
        int oldestGuestDate = INF;
        int alumniCount = 0;
        for (int i = 0; i < m; i++) {
            String id = br.readLine().trim();
            int date = Integer.parseInt(id.substring(6, 14));

            if (alumniSet.contains(id)) {
                alumniCount++;
                if (date < oldestAlumniDate) {
                    oldestAlumniDate = date;
                    oldestAlumni = id;
                }
            } else {
                if (date < oldestGuestDate) {
                    oldestGuestDate = date;
                    oldestGuest = id;
                }
            }
        }

        System.out.println(alumniCount);
        if (alumniCount == 0) {
            System.out.println(oldestGuest);
        } else {
            System.out.println(oldestAlumni);
        }
    }
}