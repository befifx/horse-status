package com.example.eventhandling;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import net.kyori.adventure.text.Component;

public class PlayerListener implements Listener {

  @EventHandler
    public void onRightClick(PlayerInteractEntityEvent e) {

      if (!(e.getRightClicked() instanceof Horse)) {
        return;
      }

      Player player = e.getPlayer();
      ItemStack i = player.getInventory().getItemInMainHand();

      if (i.getType() == Material.STICK) {
        e.setCancelled(true);
        Horse horse = (Horse)e.getRightClicked();

        double speed = horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue();
        double jump = horse.getJumpStrength();
        double health = horse.getHealth();

        String str = String.format("Speed:%.2f Jump:%.2f Health:%.2f", speed, jump, health);
        player.sendActionBar(Component.text(str));
      }

  }

}
