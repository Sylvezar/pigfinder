package nl.sylvezar.pigfinder;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PigTracer {
	
	private Main main1;
	
	public PigTracer(Main main) {
		this.main1 = main;
	}
	
	
	@SubscribeEvent
	public void renderOverlay(RenderWorldLastEvent event) {
		try {
			if (main1.findpigs) {
				draw3DLine(main1.goal.addVector(0,1,0), main1.pig.getPositionVector().addVector(0,1,0), event.partialTicks);
			}
		} catch(Exception e) {
			utils.debugmsg(e);
		}
    }
	
	public static void draw3DLine(Vec3 pos1, Vec3 pos2, float partialTicks) {
		Entity render = Minecraft.getMinecraft().getRenderViewEntity();
		WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
		Color colour = new Color(0XFFFFFF);
		
		double realX = render.lastTickPosX + (render.posX - render.lastTickPosX) * partialTicks;
		double realY = render.lastTickPosY + (render.posY - render.lastTickPosY) * partialTicks;
		double realZ = render.lastTickPosZ + (render.posZ - render.lastTickPosZ) * partialTicks;
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(-realX, -realY, -realZ);
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GL11.glLineWidth(3);
		GlStateManager.color(colour.getRed() / 255f, colour.getGreen() / 255f, colour.getBlue() / 255f, colour.getAlpha() / 255f);
		worldRenderer.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
		
		worldRenderer.pos(pos1.xCoord, pos1.yCoord, pos1.zCoord).endVertex();
		worldRenderer.pos(pos2.xCoord, pos2.yCoord, pos2.zCoord).endVertex();
		Tessellator.getInstance().draw();

		GlStateManager.translate(realX, realY, realZ);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.popMatrix();
	}
}
