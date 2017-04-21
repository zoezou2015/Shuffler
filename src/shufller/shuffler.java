package shufller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class shuffler {
		
	public static void main(String[] args) throws NumberFormatException, IOException{
		//file path
	    String filepath = "data/train-N600";          
		BufferedReader scan = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), "UTF8"));
		ArrayList<Integer>full_ids = new ArrayList<Integer>();        
		String line;	
		while((line=scan.readLine())!=null){
			int id = Integer.parseInt(line);
			full_ids.add(id);
		}
		long seed = System.nanoTime();
		scan.close();
		Collections.shuffle(full_ids, new Random(seed));
		ArrayList<Integer>part_ids = new ArrayList<Integer>(full_ids.subList(0, 100));        		       	   
		filepath = "data/train-N100";//+args[1];                
		

		BufferedWriter writer = null;
		try{
		    writer = new BufferedWriter( new FileWriter( filepath));
		    for(int id_index=0; id_index<part_ids.size(); id_index++){
    			String idd = Integer.toString(part_ids.get(id_index))+"\n";
//	    			System.out.println("train_ids"+train_ids);
    			writer.write(idd);
    		}
		}catch ( IOException e){
		}
		finally{
		    try{
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e){
		    }
		}
		
	}	


}
