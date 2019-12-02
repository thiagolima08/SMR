import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class TesteTime {

	public static void main(String[] args) {
		LocalDateTime time;
		time = LocalDateTime.now();
	    System.out.println(time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))); 
	  }
}
