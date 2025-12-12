import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

class Main{
	public static void main (String[] args) throws Exception{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy\nMM\ndd\n");
		LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(dtf));
	}
}
