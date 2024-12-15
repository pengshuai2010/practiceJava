package leetCode;

import java.util.*;

public class Q721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // will there be a case where two accounts share email address, but have different names?
        // will accounts be empty? will name or email address be empty?
        Map<String, String> emailNameMap = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                emailNameMap.put(account.get(i), account.get(0));
            }
        }
        DisjointSet disjointSet = new DisjointSet(emailNameMap.keySet());
        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                disjointSet.union(account.get(1), account.get(i));
            }
        }
        Map<String, List<String>> merged = new HashMap<>();
        for (String email : emailNameMap.keySet()) {
            String root = disjointSet.find(email);
            if (!merged.containsKey(root)) {
                merged.put(root, new ArrayList<>());
            }
            merged.get(root).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : merged.entrySet()) {
            String root = entry.getKey();
            List<String> emails = entry.getValue();
            List<String> list = new ArrayList<>();
            String name = emailNameMap.get(root);
            list.add(name);
            Collections.sort(emails);
            list.addAll(emails);
            result.add(list);
        }
        return result;
    }

    static class DisjointSet {
        private final Map<String, String> parent;
        private final Map<String, Integer> size;

        DisjointSet(Set<String> nodes) {
            this.parent = new HashMap<>();
            this.size = new HashMap<>();
            for (String node : nodes) {
                this.parent.put(node, node);
                this.size.put(node, 1);
            }
        }

        String find(String a) {
            String curr = a;
            while (!parent.get(curr).equals(curr)) {
                curr = parent.get(curr);
            }
            String root = curr;
            curr = a;
            while (!parent.get(curr).equals(root)) {
                String tmp = parent.get(curr);
                parent.put(curr, root);
                curr = tmp;
            }
            return root;
        }

        void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (this.size.get(rootA) < this.size.get(rootB)) {
                String tmp = rootA;
                rootA = rootB;
                rootB = tmp;
            }
            this.parent.put(rootB, rootA);
            this.size.put(rootA, this.size.get(rootA) + this.size.get(rootB));
        }

    }
}
