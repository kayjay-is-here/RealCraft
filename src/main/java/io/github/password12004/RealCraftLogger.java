package io.github.password12004;

import java.util.logging.Logger;

import io.github.password12004.RealCraft.*;
import org.bukkit.*;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import io.github.password12004.*;
 
public class RealCraftLogger extends JavaPlugin implements CommandExecutor {
	
	private RealCraft pdf;
	private Logger log;
	
	public RealCraftLogger(RealCraft pdf) {
		this.pdf = pdf;
		this.log = Logger.getLogger("Minecraft");
	}
	
	private String getFormattedMessage(String message){
		PluginDescriptionFile pdf = this.getDescription();
		
		return "[" + pdf.getName() + " v" + pdf.getVersion() + "]" + message;
	}
	
	public void info(String message){
		this.log.info(this.getFormattedMessage(message));
	}
	
}
