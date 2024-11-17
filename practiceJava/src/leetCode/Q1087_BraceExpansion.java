package leetCode;

import java.util.ArrayList;
import java.util.List;

class Element {
    List<Character> choices; // omit gettters and setters

    Element(List<Character> choices) {
        this.choices = choices;
    }
}

public class Q1087_BraceExpansion {
    private static void expand(List<Element> elements, int index, StringBuilder partial, List<String> solutions) {
        if (index == elements.size()) {
            solutions.add(partial.toString());
            return;
        }
        Element element = elements.get(index);
        for (char ch : element.choices) {
            partial.append(ch);
            expand(elements, index + 1, partial, solutions);
            partial.deleteCharAt(partial.length() - 1);
        }
    }

    private static List<Element> preprocess(String s) {
        List<Element> elements = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) != '{') {
                List<Character> choices = new ArrayList<>();
                choices.add(s.charAt(index));
                Element element = new Element(choices);
                elements.add(element);
                index++;
                continue;
            }
            List<Character> choices = new ArrayList<>();
            index++; // skip '{'
            while (s.charAt(index) != '}') {
                if (s.charAt(index) == ',') {
                    index++;
                    continue;
                }
                choices.add(s.charAt(index));
                index++;
            }
            Element element = new Element(choices);
            elements.add(element);
            index++; // skip '}'
        }
        return elements;
    }

    public static void main(String[] args) {
        Q1087_BraceExpansion problem = new Q1087_BraceExpansion();
        problem.expand("abc");
    }

    public String[] expand(String s) {
        // will there be duplicates in the choices? will there be nested braces?
        // can I assume the input is valid? matching braces?
        if (s == null || s.isEmpty()) {
            return new String[0];
        }
        List<Element> elements = preprocess(s);
        List<String> solutions = new ArrayList<>();
        expand(elements, 0, new StringBuilder(), solutions);
        System.out.println(solutions);
        return solutions.toArray(new String[0]);
    }
}
