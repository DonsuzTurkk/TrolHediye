package tr.donsuzturk.trolhediye;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrolHediye extends JavaPlugin
{
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getLogger().info("Eklenti aktif edildi!");
    }

    public boolean onCommand(final CommandSender sender, final Command komut, final String label, final String[] args) {
        if (komut.getName().equalsIgnoreCase("trolhediye") && sender instanceof Player) {
            final Player oyuncu = (Player)sender;
            oyuncu.sendMessage(ChatColor.translateAlternateColorCodes('&', TrolHediye.this.getConfig().getString("Prefix") + " " + getConfig().getString("Mesaj")));
            oyuncu.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000000, 10));
            oyuncu.getInventory().addItem(new ItemStack(Material.valueOf(getConfig().getString("Hediye"))));
            return true;
        }
        return false;
    }
}
