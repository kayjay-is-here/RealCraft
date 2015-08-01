//The Package
package io.github.password12004;

//Imports

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.inventory.meta.*;
import org.bukkit.*;
import java.util.*;
import io.github.password12004.RealCraft.*;


// Privates


// The Main Class
public final class RealCraft extends JavaPlugin implements Listener {
	
	//Protected
	
	protected RealCraftLogger log;
	
	//Booleans
	
	@Override
    public void onEnable() {
		getLogger().info("onEnable for RealCraft has been invoked!");
		getServer().getPluginManager().registerEvents(this, this);
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		this.getCommand("realtime").setExecutor(new PluginCommandExecutor(this));
		this.log = new RealCraftLogger(this);
		
		
		
	}
	
    @Override
    public void onDisable() {
    	getLogger().info("onDisable for RealCraft has been invoked!");
    }
    
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	
    	
    	if (args.length > 4) {
	           sender.sendMessage("Too many arguments!");
	           return false;
	        } 
	        if (args.length < 2) {
	           sender.sendMessage("Not enough arguments!");
	           return false;
	        }
	        Player target = (Bukkit.getServer().getPlayer(args[0]));
	        if (target == null) {
	           sender.sendMessage(args[0] + " is not online!");
	           return false;
	        }
	        for (Player player: Bukkit.getServer().getOnlinePlayers()) {
	            if (player.hasPermission("send.receive.message")) {
	                player.sendMessage("You were sent a message");
	            }
	        }
    	return false;
    	
    }
    /*
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Get the player's location.
        Location loc = event.getPlayer().getLocation();
        // Sets loc to five above where it used to be. Note that this doesn't change the player's position.
        loc.setY(loc.getY() + 5);
        // Gets the block at the new location.
        Block b = loc.getBlock();
        // Sets the block to type id 1 (stone).
        b.setType(Material.STONE);
    }
    */
    
    /*
    public void generateCube(Location loc, int length) {
    // Set one corner of the cube to the given location.
    // Uses getBlockN() instead of getN() to avoid casting to an int later.
    int x1 = loc.getBlockX(); 
    int y1 = loc.getBlockY();
    int z1 = loc.getBlockZ();
 
    // Figure out the opposite corner of the cube by taking the corner and adding length to all coordinates.
    int x2 = x1 + length;
    int y2 = y1 + length;
    int z2 = z1 + length;
 
    World world = loc.getWorld();
 
    // Loop over the cube in the x dimension.
    for (int xPoint = x1; xPoint <= x2; xPoint++) { 
        // Loop over the cube in the y dimension.
        for (int yPoint = y1; yPoint <= y2; yPoint++) {
            // Loop over the cube in the z dimension.
            for (int zPoint = z1; zPoint <= z2; zPoint++) {
                // Get the block that we are currently looping over.
                Block currentBlock = world.getBlockAt(xPoint, yPoint, zPoint);
                // Set the block to type 57 (Diamond block!)
                currentBlock.setType(Material.DIAMOND_BLOCK);
            }
        }
    }
}
     */
    
    public void onPlayerJoin(PlayerJoinEvent evt) {
        Player player = evt.getPlayer(); // The player who joined
        PlayerInventory inventory = player.getInventory(); // The player's inventory
        ItemStack woodstack = new ItemStack(Material.WOOD, 64); // A stack of Oak Wood
        // ItemStack cobblestack = new ItemStack(Material.COBBLESTONE, 64); // A stack of Cobblestone
        ItemStack ExtraCoal = new ItemStack(Material.COAL, 10);
        if (inventory.contains(woodstack)) {
            inventory.addItem(ExtraCoal); // Adds a stack of diamonds to the player's inventory
            player.sendMessage("§2 as a reward for cutting a stack of Wood, So here is 10 free coal!"); }
        }
    
        public void setMetadata(Metadatable object, String key, Object value, Plugin plugin) {
        	  object.setMetadata(key, new FixedMetadataValue(plugin,value));
        	}
        	 
        	public Object getMetadata(Metadatable object, String key, Plugin plugin) {
        	  List<MetadataValue> values = object.getMetadata(key);  
        	  for (MetadataValue value : values) {
        	     // Plugins are singleton objects, so using == is safe here
        	     if (value.getOwningPlugin() == plugin) {
        	        return value.value();
        	     }
        	  }
        	  return null;
        	}

			public String getVersion() {
				// TODO Auto-generated method stub
				return "1.0.0";
			}

        	
        	
}
