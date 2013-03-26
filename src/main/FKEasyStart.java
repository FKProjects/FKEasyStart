package main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class FKEasyStart extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("FK-Easy-Start v" + this.getDescription().getVersion() + " enabled!");
		
		registerEvent();
	}


	@Override
	public void onDisable() {
		System.out.println("FK-Easy-Start v" + this.getDescription().getVersion() + " disabled!");
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg) {
		Player p = (Player) sender;
		if (p.isOp()) {
			
			if(command.getName().equalsIgnoreCase("fk-kill")) {
				
				Player target = getServer().getPlayer(arg[0]);		
				target.setHealth(0);
				target.sendMessage(ChatColor.RED + "[FK-Easy-Start]: " + "Du wurdest per Befehl getötet!");
				p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: " + target.getName() + " wurde getötet.");
				
			}
			if(command.getName().equalsIgnoreCase("fk-starterpack")) {
				p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du wurdest ausgerüstet.");
				p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
				p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
				p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
				p.getInventory().addItem(new ItemStack(Material.WOOD_SWORD, 1));
			}
		
			if(command.getName().equalsIgnoreCase("fk-heal")) {
				if(sender instanceof Player) {
					if(arg.length == 0) {
						p.setHealth(20);
						p.setFoodLevel(20);
						p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du hast dich geheilt.");
					}
					else if(arg.length == 1)	{
						if(this.getServer().getPlayer(arg[0]).isOnline()) {
							Player target = this.getServer().getPlayer(arg[0]);
							target.setHealth(20);
							target.setFoodLevel(20);
							target.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du wurdest geheilt.");
							p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du hast " + target.getName() + " geheilt.");
						}
						else {
							p.sendMessage(ChatColor.RED + "[FK-Easy-Start]: Spieler wurde nicht gefunden!");
						}
					}
				}
				else {
					System.out.println("[FK-Easy-Start]: Dieser Befehl ist nur für Spieler!");
				}
			}
			if(command.getName().equalsIgnoreCase("fk-gethead")) {
				int itemid = new GetItemIDbyName().getItemID(arg[0]);
				p.getInventory().setHelmet(new ItemStack(itemid, 1));
				p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du trägst nun das gewünschte Item auf dem Kopf!");
				if (itemid == -1)  {
					p.sendMessage(ChatColor.RED + "[FK-Easy-Start]: Item nicht gefunden!");
				}
			}
			if(command.getName().equalsIgnoreCase("fk-getchestplate")) {
				int itemid = new GetItemIDbyName().getItemID(arg[0]);
				p.getInventory().setChestplate(new ItemStack(itemid, 1));
				p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du trägst nun das gewünschte Item!");
				if (itemid == -1)  {
					p.sendMessage(ChatColor.RED + "[FK-Easy-Start]: Item nicht gefunden!");
				}
			}
			if(command.getName().equalsIgnoreCase("fk-getleggings")) {
				int itemid = new GetItemIDbyName().getItemID(arg[0]);
				p.getInventory().setLeggings(new ItemStack(itemid, 1));
				p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du trägst nun das gewünschte Item!");
				if (itemid == -1)  {
					p.sendMessage(ChatColor.RED + "[FK-Easy-Start]: Item nicht gefunden!");
				}
			}
			if(command.getName().equalsIgnoreCase("fk-getboots")) {
				int itemid = new GetItemIDbyName().getItemID(arg[0]);
				p.getInventory().setBoots(new ItemStack(itemid, 1));
				p.sendMessage(ChatColor.GREEN + "[FK-Easy-Start]: Du trägst nun das gewünschte Item!");
				if (itemid == -1)  {
					p.sendMessage(ChatColor.RED + "[FK-Easy-Start]: Item nicht gefunden!");
				}
			}
			if(command.getName().equalsIgnoreCase("tc")){
				if (p.getGameMode() == GameMode.SURVIVAL){
					p.setGameMode(GameMode.CREATIVE);
				}
				else {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
		}
		else {
			p.sendMessage(ChatColor.RED + "[FK-Easy-Start]: Du musst op sein um diesen Befehl zu nutzen.");
		}
		return true;	
		
}
	private void registerEvent() {
		prl = new PlayerRespawnListener(this);
	}
	private PlayerRespawnListener prl;
}
