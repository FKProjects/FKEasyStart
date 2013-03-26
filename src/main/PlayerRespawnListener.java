package main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRespawnListener implements Listener {



		public PlayerRespawnListener(FKEasyStart plugin){
			this.plugin = plugin;
			plugin.getServer().getPluginManager().registerEvents(this, plugin);
			
		}
		
		@EventHandler
		public void onPlayerRespawn (PlayerRespawnEvent event){
			Player p = event.getPlayer();
			
		}
		private FKEasyStart plugin;
}
