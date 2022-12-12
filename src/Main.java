import java.util.Stack;

public class Main {

	static boolean solution(String sequence) {

		Stack<String> stackSequence = new Stack<>();

		if (sequence.length() == 0) {
			return true;
		} else {

			int contParentesesAbrindo = 0;
			int contParentesesFechando = 0;

			int contChavesAbrindo = 0;
			int contChavesFechando = 0;

			int contColchetesAbrindo = 0;
			int contColchetesFechando = 0;

			for (int i = 0; i < sequence.length(); i++) {

				char c = sequence.charAt(i);

				if (c == '(') {
					contParentesesAbrindo++;
					stackSequence.push(String.valueOf(c));
				}

				if (c == ')') {
					contParentesesFechando++;
					if (!stackSequence.isEmpty() && stackSequence.peek().equals("("))
						stackSequence.pop();
				}

				if (c == '{') {
					contChavesAbrindo++;
					stackSequence.push(String.valueOf(c));
				}

				if (c == '}') {
					contChavesFechando++;
					if (!stackSequence.isEmpty() && stackSequence.peek().equals("{"))
						stackSequence.pop();
				}

				if (c == '[') {
					contColchetesAbrindo++;
					stackSequence.push(String.valueOf(c));
				}

				if (c == ']') {
					contColchetesFechando++;
					if (!stackSequence.isEmpty() && stackSequence.peek().equals("["))
						stackSequence.pop();
				}
			}

			if (stackSequence.isEmpty()
					&& (contChavesAbrindo == contChavesFechando && contColchetesAbrindo == contColchetesFechando
							&& contParentesesAbrindo == contParentesesFechando))
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		
		System.out.println(solution("()[]}{"));
		System.out.println(solution("()[]{(})"));
		System.out.println(solution("()[]{()}"));
		System.out.println(solution("()[]{()}[]}"));
		System.out.println(solution("()[]{}"));
		
	}
}
