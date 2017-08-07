import java.util.LinkedList;
import java.io.*;
import java.util.Random;

public class Raffle {

	LinkedList<Student> students = new LinkedList<Student>();
	LinkedList<Student> entries = new LinkedList<Student>();
	int numContestants;
	int prizes;
	
	public Raffle(LinkedList<Student> students, int numContestants, int prizes) throws FileNotFoundException, IOException{
		this.students = initalize();
		this.numContestants = numContestants;
		this.prizes = prizes;
	}
	
	public LinkedList<Student> initalize() throws FileNotFoundException, IOException{
		LinkedList<Student> returnList = new LinkedList<Student>();
		Student s;
		String name;
		int studentChances;

		try(BufferedReader br = new BufferedReader(new FileReader("Entries.txt"))){
		String line;
		
		for(int i = 0; i < numContestants; i++){
			line = br.readLine();
			name = line;
			line = br.readLine();
			studentChances = Integer.parseInt(line);
			s = new Student(name,studentChances);
			returnList.add(s);
		}
	}	
		for(Student st : students){
			for(int j = 0; j < st.entries; j++){
				entries.add(st);
			}
		}
		return returnList;
	}
	
	public Student getWinner(){
		Student winner;
		int numEntries = entries.size();
		Random rg = new Random();
		int randomInt = rg.nextInt(numEntries);
		
		winner = entries.get(randomInt);
		entries.remove(randomInt);
		
		return winner;
	}
	
}
