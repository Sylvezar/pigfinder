package nl.sylvezar.pigfinder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

import com.google.gson.Gson;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class utils {
    public static void sendMessage(String text, EnumChatFormatting color) {
    	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(text).setChatStyle(new ChatStyle().setColor(color)));
    }
    public static void debugmsg(Object text) {
    	if (Main.debug) {
    		System.out.println(text);
    	}
    }
}
