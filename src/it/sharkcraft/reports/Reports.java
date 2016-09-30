package it.sharkcraft.reports;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Reports extends JavaPlugin{

        @Override
        public void onEnable() {
        }

        @Override
        public void onDisable(){

        }
 
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
                if(cmd.getName().equalsIgnoreCase("report")){
                	Player p = (Player) sender;
                        if(!(sender instanceof Player)){
                                p.sendMessage("§c§l§oSharkReport§8> §7La console non puo reportare!");
                                return true;
                        }
                        if(args.length >= 2){
                           Player target = getServer().getPlayer(args[0]);
                           if(target == null){
                                     p.sendMessage("§c§l§oSharkReport§8> §c§oIl giocatore non risulta online! " );
                                     p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 0);
                                } else {
                                        String reason = "";
                                        int x = 0;
                                        for (String a : args){
                                                if(x == 0){
                                                        x++;
                                                        continue;
                                                }
                                                reason = reason + " " + a;
                                        }
                                        reason = reason.trim();
                                        p.sendMessage("§c§l§oSharkReport§8> §a§oHai Reportato il giocatore!");
                                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 0);
                                        for (Player admin : Bukkit.getServer().getOnlinePlayers()){
                                                if(admin.hasPermission("reports.admin")){
                                                	p.sendMessage("§c§l§oSharkReport§8> §a§o" + p.getName() + "§7 §oha reportato §c§o" + target.getName() + " §7§oper: §e§o" + reason);
                                                       
                                                }
                                        }
                                }
                        } else {
                         p.sendMessage("§c§l§oSharkReport§8> §7/report <giocatore> <motivazione>");
                        }
                }
                return true;
        }
}