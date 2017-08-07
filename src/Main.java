import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
	
	static int NUM_CONTESTANTS = 2;
	static int NUM_PLANTS = 2;
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		LinkedList<Student> students = initalize();
		Raffle r = new Raffle(students,NUM_CONTESTANTS, NUM_PLANTS);
		Student winningStudent;
		for(int cnt = 0; cnt < NUM_PLANTS; cnt++){
			winningStudent = r.getWinner();
			System.out.println("Winner" + cnt + ":" + winningStudent.getName());
		}
	}
	
	public static LinkedList<Student> initalize() throws FileNotFoundException, IOException{
		LinkedList<Student> returnList = new LinkedList<Student>();
		Student s;
		String name;
		int studentChances;

		try(BufferedReader br = new BufferedReader(new FileReader("Entries.txt"))){
		String line;
		
		for(int i = 0; i < NUM_CONTESTANTS; i++){
			line = br.readLine();
			name = line;
			line = br.readLine();
			studentChances = Integer.parseInt(line);
			s = new Student(name,studentChances);
			returnList.add(s);
		}
	}	
		return returnList;
	}

}
