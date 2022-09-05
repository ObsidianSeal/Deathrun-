package page.pinniped.deathrunplus;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {

    public Inventory trapList;

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(this, this);

        createInventory();

        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Deathrun+] " + ChatColor.GREEN + "Deathrun+ has been enabled successfully.");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Deathrun+] " + ChatColor.GREEN + "Goodbye!");

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("traps")) {

            if (!(sender instanceof Player)) {

                sender.sendMessage("Only players can use this command.");

                return true;

            } else {

                Player player = (Player) sender;

                if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {

                    player.openInventory(trapList);

                    return true;

                } else {

                    player.sendMessage(ChatColor.RED + "Only death can use this command.");

                }

            }

        }

        if (label.equalsIgnoreCase("lobby") || label.equalsIgnoreCase("l")) {

            if (!(sender instanceof Player)) {

                sender.sendMessage("Only players can use this command.");

                return true;

            } else {

                Player player = (Player) sender;

                Location location = new Location(player.getWorld(), 30.5, 12, 30.5, 45, 0);
                player.teleport(location);

                player.removePotionEffect(PotionEffectType.SPEED);

                player.setGameMode(GameMode.ADVENTURE);

            }

        }

        return false;

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getInventory().equals(trapList)) return;

        if (event.getCurrentItem() == null) return;

        if (event.getCurrentItem().getItemMeta() == null) return;

        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() == 10) {

            Location location = new Location(player.getWorld(), 1.5, 4, 20.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 11) {

            Location location = new Location(player.getWorld(), 1.5, 4, 45.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 12) {

            player.sendMessage(ChatColor.RED + "That trap doesn't need to be activated.");

        }

        if (event.getSlot() == 13) {

            Location location = new Location(player.getWorld(), 1.5, 4, 79.5, -45, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 14) {

            player.sendMessage(ChatColor.RED + "That trap doesn't need to be activated.");

        }

        if (event.getSlot() == 15) {

            Location location = new Location(player.getWorld(), -36.5, 4, 81.5, 0, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 16) {

            Location location = new Location(player.getWorld(), -44.5, 4, 81.5, 0, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 19) {

            Location location = new Location(player.getWorld(), -70.5, 4, 81.5, 0, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 20) {

            Location location = new Location(player.getWorld(), -86.5, 4, 81.5, 0, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 21) {

            Location location = new Location(player.getWorld(), -97.5, 4, 81.5, 0, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 22) {

            Location location = new Location(player.getWorld(), -108.5, 4, 81.5, 0, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 23) {

            Location location = new Location(player.getWorld(), -126.5, 4, 108.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 24) {

            Location location = new Location(player.getWorld(), -126.5, 4, 148.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 25) {

            player.sendMessage(ChatColor.RED + "That trap doesn't need to be activated.");

        }

        if (event.getSlot() == 28) {

            Location location = new Location(player.getWorld(), -126.5, 4, 260.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 29) {

            Location location = new Location(player.getWorld(), -126.5, 4, 280.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 30) {

            Location location = new Location(player.getWorld(), -126.5, 4, 300.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 31) {

            Location location = new Location(player.getWorld(), -126.5, 4, 313.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 32) {

            Location location = new Location(player.getWorld(), -126.5, 4, 338.5, -90, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 33) {

            Location location = new Location(player.getWorld(), -112.5, 4, 361.5, -180, 0);
            player.teleport(location);

        }

        if (event.getSlot() == 34) {

            player.sendMessage(ChatColor.RED + "That trap doesn't need to be activated.");

        }

    }

    @EventHandler
    public void onPlayerFalling(EntityDamageEvent event) {

        Entity entity = event.getEntity();

        if (entity instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.VOID) {

            Player player = (Player) entity;

            if (player.getGameMode() == GameMode.ADVENTURE) {

                player.damage(20);

            } else {

                Location location = new Location(player.getWorld(), 30.5, 12, 30.5, 45, 0);

                player.teleport(location);

            }

        }

    }

    public void createInventory() {

        trapList = Bukkit.createInventory(null, 45, ChatColor.DARK_AQUA + "Teleport to a trap:");

        ItemStack item = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS);
        ItemMeta meta = item.getItemMeta();

        // #1
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#1");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Click to teleport");
        meta.setLore(lore);
        item.setItemMeta(meta);
        trapList.setItem(10, item);

        // #2
        item.setType(Material.RED_WOOL);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#2");
        item.setItemMeta(meta);
        trapList.setItem(11, item);

        // #3
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#3");
        item.setItemMeta(meta);
        trapList.setItem(12, item);

        // #4
        item.setType(Material.LAVA_BUCKET);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#4");
        item.setItemMeta(meta);
        trapList.setItem(13, item);

        // #5
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#5");
        item.setItemMeta(meta);
        trapList.setItem(14, item);

        // #6
        item.setType(Material.FLINT_AND_STEEL);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#6");
        item.setItemMeta(meta);
        trapList.setItem(15, item);

        // #7
        item.setType(Material.RED_WOOL);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#7");
        item.setItemMeta(meta);
        trapList.setItem(16, item);

        // #8
        item.setType(Material.TIPPED_ARROW);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#8");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
        trapList.setItem(19, item);

        // #9
        item.setType(Material.WHITE_WOOL);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#9");
        item.setItemMeta(meta);
        trapList.setItem(20, item);

        // #10
        item.setType(Material.WHITE_WOOL);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#10");
        item.setItemMeta(meta);
        trapList.setItem(21, item);

        // #11
        item.setType(Material.TNT);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#11");
        item.setItemMeta(meta);
        trapList.setItem(22, item);

        // #12
        item.setType(Material.PISTON);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#12");
        item.setItemMeta(meta);
        trapList.setItem(23, item);

        // #13
        item.setType(Material.GRAY_WOOL);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#13");
        item.setItemMeta(meta);
        trapList.setItem(24, item);

        // #14
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#14");
        item.setItemMeta(meta);
        trapList.setItem(25, item);

        // #15
        item.setType(Material.STICKY_PISTON);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#15");
        item.setItemMeta(meta);
        trapList.setItem(28, item);

        // #16
        item.setType(Material.ARROW);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#16");
        item.setItemMeta(meta);
        trapList.setItem(29, item);

        // #17
        item.setType(Material.ICE);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#17");
        item.setItemMeta(meta);
        trapList.setItem(30, item);

        // #18
        item.setType(Material.SEA_LANTERN);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#18");
        item.setItemMeta(meta);
        trapList.setItem(31, item);

        // #19
        item.setType(Material.SLIME_BLOCK);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#19");
        item.setItemMeta(meta);
        trapList.setItem(32, item);

        // #20
        item.setType(Material.LIGHT_BLUE_STAINED_GLASS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#20");
        item.setItemMeta(meta);
        trapList.setItem(33, item);

        // #21
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "#21");
        item.setItemMeta(meta);
        trapList.setItem(34, item);

    }

}
