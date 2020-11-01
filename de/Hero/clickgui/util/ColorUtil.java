package de.Hero.clickgui.util;

import java.awt.Color;

import cf.sqlskid.base.Client;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int) Client.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int)Client.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int) Client.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
