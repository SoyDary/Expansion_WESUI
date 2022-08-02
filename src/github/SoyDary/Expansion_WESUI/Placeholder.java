package github.SoyDary.Expansion_WESUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import eu.kennytv.worldeditsui.WorldEditSUIPlugin;
import eu.kennytv.worldeditsui.user.UserManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class Placeholder extends PlaceholderExpansion {
	
	private WorldEditSUIPlugin wesui;
	private UserManager usermanager;

	public boolean canRegister() {
		return (Bukkit.getPluginManager().getPlugin("WorldEditSUI") != null && Bukkit.getPluginManager().getPlugin("WorldEditSUI").isEnabled());
	}

	public boolean register() {
	    this.wesui = (WorldEditSUIPlugin)Bukkit.getPluginManager().getPlugin("WorldEditSUI");
	    if (this.wesui != null && this.wesui.isEnabled()) {
	    	this.usermanager = this.wesui.getUserManager();
	      return super.register();
	    } 
	    return false;		
	}


	@Override
	public String getAuthor() {
		return "Daryela";
	}

	@Override
	public String getIdentifier() {
		return "wesui";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}
	
	public String onPlaceholderRequest(Player p, String id) {
		if(id.equalsIgnoreCase("enabledselecction")) {
			return String.valueOf((usermanager.getUser(p).isSelectionShown()));
		}
		if(id.equalsIgnoreCase("enabledclipboard")) {
			return String.valueOf((usermanager.getUser(p).isClipboardShown()));
		}
		return null;
		
	}
	
	

}
