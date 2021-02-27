package com.example.demo;

import java.util.Formatter;
import com.example.Player;
import com.example.PlayerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private Boolean control = true;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(control){
			System.out.println(" ***  MENU *** ");
			System.out.println(" 1. Add New Player ");
			System.out.println(" 2. List Player ");
			System.out.println(" 3. Update Player ");
			System.out.println(" 4. Remove Player ");
			System.out.println(" 100. Exit ");
			System.out.print(" Ange val> ");			
			int sel = Integer.parseInt(System.console().readLine());
			System.out.println("");			
			switch(sel){
				case 100:
				  control = false;				  
				  break;
				case 1:
				  AddPlayer();
				  break;
				case 2:
				  ListPlayer(); 
				  break;
				case 3:
				  UpdatePlayer();				     
				  break;
				case 4:
				  RemovePlayer();				     
				  break;  
				default:
				   System.out.println(" You didn't provide correct selection, please select valid option!!");
				   break;
			}
		}
		
	}

	private void RemovePlayer() {
		System.out.print("Which Player ID number are you going to delete? ");
		int sel = Integer.parseInt(System.console().readLine());
		System.out.println("");
		PlayerRepository.RemovePlayer(sel);
		System.out.println("");

	}

	private void UpdatePlayer() {
		if(PlayerRepository.PlayerList().isEmpty() == false){
			System.out.print("Which Player ID number are you going to update? ");
			int sel = Integer.parseInt(System.console().readLine());
			System.out.println("");
			System.out.println("Which property of the player are you going to update? ");
			System.out.println(" 1. Name of the Player ");
			System.out.println(" 2. Age of the Player ");
			System.out.println(" 3. Jersy number of the Player ");
			System.out.println(" 4. All property of the Player ");
			int val = Integer.parseInt(System.console().readLine());
			for (Player player : PlayerRepository.PlayerList()) {
				if(player.GetId() == sel){
					switch(val){
						case 1:
							System.out.print("Please provide Name of the Player: ");   
							String name = System.console().readLine();
							System.out.println("");				   
							player.SetNamn(name);
							break;
						case 2:
							System.out.print("Please provide Age of the Player: ");   
							int age = Integer.parseInt(System.console().readLine());
							System.out.println("");
							player.SetAge(age);
							break;
						case 3:
							System.out.print("Please provide Jersy Number of the Player: ");   
							int jersy = Integer.parseInt(System.console().readLine());
							System.out.println("");				   
							player.SetJersey(jersy);
							break;
						case 4:
							System.out.print("Please provide Name of the Player ");   
							String playerName = System.console().readLine();
							System.out.println("");
							player.SetNamn(playerName);
							System.out.print("Please provide Age of the Player ");   
							int playerAge = Integer.parseInt(System.console().readLine());
							System.out.println("");
							player.SetAge(playerAge);
							System.out.print("Please provide Jersy Number of the Player ");   
							int playerJersy = Integer.parseInt(System.console().readLine());
							System.out.println("");				     
							player.SetJersey(playerJersy);				     
							break;
						default:
							System.out.println(" You didn't provide correct selection");
							break;
					}					
				}
			}
		}
		else{
			System.out.println("Please Add Player First to the player list!!");
		}
		System.out.println("");
		 
	}

	private void ListPlayer() {
		if(PlayerRepository.PlayerList().isEmpty() == false){
			System.out.printf("%-15s %-15s %-15s %-15s %n", "ID","Name","Age","Jersy");
		    System.out.println("------------------------------------------------------------------");			
			StringBuilder sbuf = new StringBuilder();
			Formatter fmt = new Formatter(sbuf);
		
			for (Player player : PlayerRepository.PlayerList()) {
				
				fmt.format("%-15d %-15s %-15d %-15d %n", player.GetId(), player.GetNamn(),player.GetAge(),player.GetJersey());
				System.out.print(sbuf.toString());
				sbuf.setLength(0);		
		
			}
			System.out.println("------------------------------------------------------------------");
			fmt.close();

		}
		else{
			System.out.println("Please Add Player First to the player list!!");
		}
		System.out.println("");		
	}

	private void AddPlayer() {
		System.out.println(" ***  ADD NEW PLAYER *** ");
		System.out.println("Namn:");
		String namn = System.console().readLine();
		System.out.println("Age:");
		int age = Integer.parseInt(System.console().readLine()); 
		System.out.println("Jerseynumber:");
		int jersey = Integer.parseInt(System.console().readLine()); 

	
		Player p = new Player();
		p.SetAge(age);
		p.SetNamn(namn);
		p.SetJersey(jersey);		
		
		if(PlayerRepository.PlayerList().isEmpty() == true ){
			p.SetId(1);
			PlayerRepository.InsertPlayer(p);
		}
		else{
			int currentId = PlayerRepository.PlayerList().size();
		    p.SetId(currentId +1);
			PlayerRepository.InsertPlayer(p);
		}
		System.out.println("");		
		
	}

}
