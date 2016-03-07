package practiceJava;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryRegularExpressions {
	//compare python and java in regular expressions
	// http://langref.org/python+java/pattern-matching

	public static void main(String[] args) {
		String str = "<Rule RuleId   =  \"dfsfrule_1\" Effect=\"Permit\"  >\n<Target>\n<AnyOf>\n<AllOf>\n<Match MatchId=\"urn:oasis:names:tc:xacml:1.0:function:string-equal\">\n<AttributeValue DataType=\"http://www.w3.org/2001/XMLSchema#string\">Patient</AttributeValue><AttributeDesignator AttributeId=\"urn:oasis:names:tc:xacml:1.0:subject:subject-id\" DataType=\"http://www.w3.org/2001/XMLSchema#string\" Category=\"urn:oasis:names:tc:xacml:1.0:subject-category:access-subject\" MustBePresent=\"true\"/>\n</Match>\n<Match MatchId=\"urn:oasis:names:tc:xacml:1.0:function:string-equal\">\n<AttributeValue DataType=\"http://www.w3.org/2001/XMLSchema#string\">My Demographics</AttributeValue><AttributeDesignator AttributeId=\"urn:oasis:names:tc:xacml:1.0:resource:resource-id\" DataType=\"http://www.w3.org/2001/XMLSchema#string\" Category=\"urn:oasis:names:tc:xacml:3.0:attribute-category:resource\" MustBePresent=\"true\"/>\n</Match>\n<Match MatchId=\"urn:oasis:names:tc:xacml:1.0:function:string-equal\">\n<AttributeValue DataType=\"http://www.w3.org/2001/XMLSchema#string\">Edit</AttributeValue><AttributeDesignator AttributeId=\"urn:oasis:names:tc:xacml:1.0:action:action-id\" DataType=\"http://www.w3.org/2001/XMLSchema#string\" Category=\"urn:oasis:names:tc:xacml:3.0:attribute-category:action\" MustBePresent=\"true\"/>\n</Match>\n</AllOf>\n</AnyOf>\n</Target>\n</Rule>";
		String pattern = "<Rule\\s+RuleId\\s*=\\s*\"([^\"]+)\"";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		if (m.find()) { //must call find() method before call group() method
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			int s = m.start(1);
			int e = m.end(1);
			System.out.println(str.substring(s, e));
			String randStr = UUID.randomUUID().toString();
			System.out.println(new StringBuilder(str).replace(s, e, randStr));
		}
	}

}

//