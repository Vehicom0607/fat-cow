package com.bika.Anticheat.util;

import static org.bukkit.Material.APPLE;
import static org.bukkit.Material.BAKED_POTATO;
import static org.bukkit.Material.BREAD;
import static org.bukkit.Material.CARROT;
import static org.bukkit.Material.COOKED_BEEF;
import static org.bukkit.Material.COOKED_CHICKEN;
import static org.bukkit.Material.COOKED_FISH;
import static org.bukkit.Material.COOKED_MUTTON;
import static org.bukkit.Material.COOKED_RABBIT;
import static org.bukkit.Material.COOKIE;
import static org.bukkit.Material.FERMENTED_SPIDER_EYE;
import static org.bukkit.Material.GOLDEN_APPLE;
import static org.bukkit.Material.GOLDEN_CARROT;
import static org.bukkit.Material.MILK_BUCKET;
import static org.bukkit.Material.MUSHROOM_SOUP;
import static org.bukkit.Material.POISONOUS_POTATO;
import static org.bukkit.Material.POTATO;
import static org.bukkit.Material.POTATO_ITEM;
import static org.bukkit.Material.POTION;
import static org.bukkit.Material.PUMPKIN_PIE;
import static org.bukkit.Material.RABBIT_STEW;
import static org.bukkit.Material.RAW_BEEF;
import static org.bukkit.Material.RAW_CHICKEN;
import static org.bukkit.Material.RAW_FISH;
import static org.bukkit.Material.ROTTEN_FLESH;
import static org.bukkit.Material.SPIDER_EYE;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;



public class Settings {

	public static final Double MAX_XZ_SPEED = 0.66D;
	public static final Double MAX_XZ_EATING_SPEED = 0.103D; //0.10177
	public static final double MAX_XZ_BLOCKING_SPEED = 0.23D; //0.12?
	public static final Double MAX_XZ_BOW_SPEED = 0.15D;
	
	public static final String NOTIFY = "main.notify"; 
	
	public static final List<Material> FOODS;
	public static final Integer MAX_WARNINGS = 15;
	public static final Double MAX_XZ_BLOCK_SPEED = 0.6714D;
	public static final Long FOOD_MIN = 1000L;
	public static final Long BOW_MIN = 100L;
	public static final String ADMIN = "main.admin";
	public static final Long MIN_HEAL_DELAY = 4500L;
	public static final Double MAX_XZ_SPEED_ONGROUND = 0.287D;
	public static final Double MAX_XZ_SPEED_INAIR = 0.6714D;
	
	public static final Double MAX_JUMP_SECOND = 0.33319999363422426D;
	public static final Double MAX_JUMP_FIRST = 0.41999998688697815D;
	public static final int MAX_JUMP = 5;
	
	static {
		FOODS = new ArrayList<Material>();
		FOODS.add(RAW_CHICKEN);
		FOODS.add(RAW_BEEF);
		FOODS.add(RAW_FISH);
		FOODS.add(COOKED_FISH);
		FOODS.add(COOKED_MUTTON);
		FOODS.add(COOKED_CHICKEN);
		FOODS.add(COOKED_RABBIT);
		FOODS.add(COOKED_BEEF);
		FOODS.add(GOLDEN_APPLE);
		FOODS.add(GOLDEN_CARROT);
		FOODS.add(APPLE);
		FOODS.add(POTATO);
		FOODS.add(CARROT);
		FOODS.add(POTATO_ITEM);
		FOODS.add(BAKED_POTATO);
		FOODS.add(POISONOUS_POTATO);
		FOODS.add(MUSHROOM_SOUP);
		FOODS.add(RABBIT_STEW);
		FOODS.add(BREAD);
		FOODS.add(COOKIE);
		FOODS.add(PUMPKIN_PIE);
		FOODS.add(ROTTEN_FLESH);
		FOODS.add(SPIDER_EYE);
		FOODS.add(FERMENTED_SPIDER_EYE);
		FOODS.add(POTION);
		FOODS.add(MILK_BUCKET);
	}
}
