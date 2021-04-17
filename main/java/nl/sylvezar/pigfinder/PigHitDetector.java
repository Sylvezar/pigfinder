package nl.sylvezar.pigfinder;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PigHitDetector {
	
	@SuppressWarnings("unused")
	private Main main;
	public PigHitDetector(Main m) {
		this.main = m;
	}

	@SubscribeEvent
    public void onAttack(AttackEntityEvent e) {
		utils.debugmsg("Attack!");
		pigstuff(e.entityPlayer,e.target, "Attack");
	}

	@SubscribeEvent
    public void onInteract(EntityInteractEvent e) {
		utils.debugmsg("Interaction!");
		pigstuff(e.entityPlayer,e.target, "Interaction");
	}
	@SubscribeEvent
    public void onUse(PlayerUseItemEvent e) {
		utils.debugmsg("ItemUse!");
		try {
		pigstuff(e.entityPlayer,Minecraft.getMinecraft().objectMouseOver.entityHit, "ItemUse");
		} catch (Exception ex){utils.debugmsg(ex);}
	}
	
	private void pigstuff(EntityPlayer p, Entity pig, String type) {
		try {
			if (p.getHeldItem().getDisplayName().toString().contains("Shiny Orb") && pig instanceof EntityPig && Minecraft.getMinecraft().thePlayer.getEntityId() == p.getEntityId()) {
				try {
					if (!(Main.pig.getEntityId() == pig.getEntityId())) {
						Main.goal = pig.getPositionVector();
						Main.pig = pig;
					}
				} catch (Exception ex) {
					Main.goal = pig.getPositionVector();
					Main.pig = pig;
				}
				utils.debugmsg("Found pig! ("+type+")");
			}
		} catch (Exception e) {
			utils.debugmsg(e);
		}
	}
	
}