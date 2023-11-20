package tv.galaxe.smp.cmd;

import com.destroystokyo.paper.profile.PlayerProfile;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerTextures;
import tv.galaxe.smp.Core;

public class HelpCommand implements CommandExecutor {
	private static Player player;
	private static Gui mainHelp = createGui("GalaxeSMP Help Menu", 6, true, false);
	private static Gui generalHelp = createGui("GalaxeSMP General Help", 6, true, true);
	private static Gui lockItemsHelp = createGui("GalaxeSMP Locking Items Help", 6, false, true);
	private static Gui lunarEclipsesHelp = createGui("GalaxeSMP Lunar Eclipses Help", 6, false, true);
	private static Gui mcMMOHelp = createGui("GalaxeSMP mcMMO Help", 6, false, true);
	private static Gui silkSpawnersHelp = createGui("GalaxeSMP Silk Spawners Help", 6, false, true);
	private static Gui townyHelp = createGui("GalaxeSMP Towny Help", 6, false, true);
	private static Gui economyHelp = createGui("GalaxeSMP Economy Help", 6, false, true);
	private static Gui gravesHelp = createGui("GalaxeSMP Graves Help", 6, false, true);
	private static Gui eventsHelp = createGui("GalaxeSMP Events Help", 6, false, true);
	private static Gui pronounsHelp = createGui("GalaxeSMP Pronouns Help", 6, false, true);
	private static final int colorUltraViolet = 0x515979;
	private static final int colorSpaceCadet = 0x262F58;
	private static final int colorLightOrange = 0xFFDAB6;
	private static final int colorDiscordBlurple = 0x5865F2;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) { // Only allow players to run command
			sender.sendMessage("This command must be used as a player!");
			return false;
		}
		player = (Player) sender;
		switch ((args.length == 0) ? "" : args[0].toLowerCase()) {
			case "general" :
				generalHelp.open(player);
				return true;
			case "lockitems" :
				lockItemsHelp.open(player);
				return true;
			case "lunareclipses" :
				lunarEclipsesHelp.open(player);
				return true;
			case "mcmmo" :
				mcMMOHelp.open(player);
				return true;
			case "silkspawners" :
				silkSpawnersHelp.open(player);
				return true;
			case "towny" :
				townyHelp.open(player);
				return true;
			case "sellingitems" :
				economyHelp.open(player);
				return true;
			case "graves" :
				gravesHelp.open(player);
				return true;
			case "events" :
				eventsHelp.open(player);
				return true;
			case "pronouns" :
				pronounsHelp.open(player);
				return true;
			case "" :
			default :
				// Pronouns mainHelp item
				Component pronouns = Component.text("Pronouns").color(TextColor.color(colorUltraViolet))
						.decorate(TextDecoration.BOLD);
				Component pronounsLore = Component.text("How to set your pronouns")
						.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
				mainHelp.setItem(3, 6,
						ItemBuilder.from(createHead(player)).name(pronouns).lore(pronounsLore).asGuiItem(event -> {
							pronounsHelp.open(player);
						}));

				mainHelp.open(player);
				return true;
		}
	}

	// Constructor to prevent instantiation
	public HelpCommand() {
		// Create ItemStack for Discord head
		ItemStack discordHead = createHead("b722098ae79c7abf002fe9684c773ea71db8919bb2ef2053ea0c0684c5a1ce4f");

		// Create ItemStack for Mob Spawner
		ItemStack mobSpawner = new ItemStack(Material.SPAWNER);
		BlockStateMeta mobSpawnerMeta = (BlockStateMeta) mobSpawner.getItemMeta();
		CreatureSpawner spawner = (CreatureSpawner) mobSpawnerMeta.getBlockState();

		spawner.setSpawnedType(org.bukkit.entity.EntityType.PLAYER);
		mobSpawnerMeta.setBlockState(spawner);
		mobSpawner.setItemMeta(mobSpawnerMeta);

		// ====================
		// Main help menu
		// ====================

		// TextComponents for item names
		Component mainGeneral = Component.text("General").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainLockItems = Component.text("Locking Items").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainLunarEclipses = Component.text("Lunar Eclipses").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainMcmmo = Component.text("mcMMO").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainSilkSpawners = Component.text("Silk Spawners").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainTowny = Component.text("Towny").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainEconomy = Component.text("Economy").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainGraves = Component.text("Graves").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component mainEvents = Component.text("Events").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component mainGeneralLore = Component.text("General information about the server")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainLockItemsLore = Component.text("How to lock your items like Fort Knox")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainLunarEclipsesLore = Component.text("Why do I hear boss music?")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainMcmmoLore = Component.text("Hey, you. You're finally awake.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainSilkSpawnersLore = Component.text("Manmade horrors beyond comprehension")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainTownyLore = Component.text("If City Skylines just Minecraft")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainEconomyLore1 = Component.text("How to start your own multi-billion")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainEconomyLore2 = Component.text("dollar company inside of the GalaxeSMP")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainGravesLore1 = Component.text("Have you or a loved one has been diagnosed with death?")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainGravesLore2 = Component.text("You may be entitled to financial compensation!")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainEventsLore1 = Component.text("\"So you just gonna bring me a birthday gift")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainEventsLore2 = Component.text("on my birthday to my birthday party")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainEventsLore3 = Component.text("on my birthday with a birthday gift?\"")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component mainEventsLore4 = Component.text(" - Tyler, The Creator").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// General mainHelp item
		mainHelp.setItem(2, 5,
				ItemBuilder.from(Material.DIAMOND_PICKAXE).name(mainGeneral).lore(mainGeneralLore).asGuiItem(event -> {
					generalHelp.open(player);
				}));

		// Events mainHelp item
		mainHelp.setItem(4, 5, ItemBuilder.from(Material.PHANTOM_MEMBRANE).name(mainEvents)
				.lore(List.of(mainEventsLore1, mainEventsLore2, mainEventsLore3, mainEventsLore4)).asGuiItem(event -> {
					eventsHelp.open(player);
				}));

		// Lock items mainHelp item
		mainHelp.setItem(2, 2,
				ItemBuilder.from(Material.CHEST).name(mainLockItems).lore(mainLockItemsLore).asGuiItem(event -> {
					lockItemsHelp.open(player);
				}));

		// Lunar eclipses mainHelp item
		mainHelp.setItem(5, 2, ItemBuilder.from(Material.CLOCK).name(mainLunarEclipses).lore(mainLunarEclipsesLore)
				.asGuiItem(event -> {
					lunarEclipsesHelp.open(player);
				}));

		// mcMMO mainHelp item
		mainHelp.setItem(4, 3,
				ItemBuilder.from(Material.EXPERIENCE_BOTTLE).name(mainMcmmo).lore(mainMcmmoLore).asGuiItem(event -> {
					mcMMOHelp.open(player);
				}));

		// Silk spawners mainHelp item
		mainHelp.setItem(3, 4,
				ItemBuilder.from(mobSpawner).name(mainSilkSpawners).lore(mainSilkSpawnersLore).asGuiItem(event -> {
					silkSpawnersHelp.open(player);
				}));

		// Towny mainHelp item
		mainHelp.setItem(4, 7,
				ItemBuilder.from(Material.FILLED_MAP).name(mainTowny).lore(mainTownyLore).asGuiItem(event -> {
					townyHelp.open(player);
				}));

		// Selling items mainHelp item
		mainHelp.setItem(2, 8, ItemBuilder.from(Material.GOLD_INGOT).name(mainEconomy)
				.lore(List.of(mainEconomyLore1, mainEconomyLore2)).asGuiItem(event -> {
					economyHelp.open(player);
				}));

		// Graves mainHelp item
		mainHelp.setItem(5, 8, ItemBuilder.from(Material.SKELETON_SKULL).name(mainGraves)
				.lore(List.of(mainGravesLore1, mainGravesLore2)).asGuiItem(event -> {
					gravesHelp.open(player);
				}));

		// ====================
		// General help menu
		// ====================

		// TextComponents for item names
		Component generalServerMove = Component.text("Moving between servers").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component generalRules = Component.text("Rules").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component generalPvp = Component.text("PvP").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component generalTickets = Component.text("Tickets").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component generalTeleporting = Component.text("Teleporting").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component generalDiscord = Component.text("Discord").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component generalServerMoveLore1 = Component
				.text("We have a hub server that you can use to move between servers")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalServerMoveLore2 = Component.text("You can use /server to see what servers are available")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalServerMoveLore3 = Component
				.text("To connect to other servers, use /server [name] to connect to your server")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalRulesLore1 = Component.text("1. No stealing, griefing, or hacking")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalRulesLore2 = Component.text("2. If a player wants you to leave their area, you must leave")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalRulesLore3 = Component.text("3. Replant crops in spawn farms")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalRulesLore4 = Component.text("4. Don't build any base next to spawn, it is a community area")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalRulesLore5 = Component.text("5. Follow Discord rules").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component generalPvpLore1 = Component
				.text("Players always have to agree to PvP each other outside of PvP designated areas")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalPvpLore2 = Component.text("Using cursed items also needs to be agreed upon")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalTicketsLore1 = Component.text("If you have an issue with the server, please submit a ticket")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalTicketsLore2 = Component.text("on Discord under ").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC).append(Component.text("#smp-tickets")
						.color(TextColor.color(colorDiscordBlurple)).decorate(TextDecoration.ITALIC));
		Component generalTicketHover = Component
				.text("Please give a description on what you are experiencing so we can resolve this quickly.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalTicketMessage = Component.text("Direct link to #smp-tickets")
				.color(TextColor.color(colorDiscordBlurple)).decorate(TextDecoration.ITALIC)
				.hoverEvent(HoverEvent.showText(generalTicketHover))
				.clickEvent(ClickEvent.openUrl("https://discord.com/channels/791759753000622602/791759753000622605"));
		Component generalTeleportingLore1 = Component
				.text("To teleport to someone, run /tp [player] to teleport to them")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalTeleportingLore2 = Component
				.text("after they accept the teleport request. You can also use /back")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalTeleportingLore3 = Component.text("to teleport to your previous location.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalDiscordLore1 = Component.text("Join the Discord chats for some chill Minecraft vibes")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalDiscordLore2 = Component.text("Grab some others to join you and talk and chill")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component generalDiscordMessage = Component.text("discord.gg/galaxe").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC).hoverEvent(HoverEvent.showText(generalDiscordLore2))
				.clickEvent(ClickEvent.openUrl("https://discord.gg/galaxe"));

		// Help Items
		// Moving between servers help item
		generalHelp.setItem(2, 5, ItemBuilder.from(Material.NETHER_STAR).name(generalServerMove)
				.lore(List.of(generalServerMoveLore1, generalServerMoveLore2, generalServerMoveLore3)).asGuiItem());

		// Rules help item
		generalHelp.setItem(3, 3,
				ItemBuilder
						.from(Material.WRITTEN_BOOK).name(generalRules).lore(List.of(generalRulesLore1,
								generalRulesLore2, generalRulesLore3, generalRulesLore4, generalRulesLore5))
						.asGuiItem(event -> {
							player.performCommand("rules");
						}));

		// PvP help item
		generalHelp.setItem(3, 7, ItemBuilder.from(Material.NETHERITE_SWORD).name(generalPvp)
				.lore(List.of(generalPvpLore1, generalPvpLore2)).asGuiItem());

		// Ticket help item
		generalHelp.setItem(4, 4, ItemBuilder.from(Material.NAME_TAG).name(generalTickets)
				.lore(List.of(generalTicketsLore1, generalTicketsLore2)).asGuiItem(event -> {
					player.sendMessage(generalTicketMessage);
				}));

		// Teleport help item
		generalHelp.setItem(4, 6, ItemBuilder.from(Material.COMPASS).name(generalTeleporting)
				.lore(List.of(generalTeleportingLore1, generalTeleportingLore2, generalTeleportingLore3)).asGuiItem());

		generalHelp.setItem(5, 5, ItemBuilder.from(discordHead).name(generalDiscord)
				.lore(List.of(generalDiscordLore1, generalDiscordLore2)).asGuiItem(event -> {
					player.sendMessage(generalDiscordMessage);
				}));

		// ====================
		// Lock items help menu
		// ====================

		// TextComponents for item names
		Component lwcExplained = Component.text("Securing your items").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lwcLockItem = Component.text("Locking an item").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lwcUnlockItem = Component.text("Unlocking an item").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lwcShareLockedItem = Component.text("Sharing a locked item").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lwcDisableAutoLock = Component.text("Disabling/enabling auto-lock")
				.color(TextColor.color(colorUltraViolet)).decorate(TextDecoration.BOLD);
		Component lwcProtectionFlags = Component.text("Protection flags").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lwcTypesOfLocking = Component.text("Types of protection").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lwcLockableItems = Component.text("Lockable items").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component lwcExplainedLore1 = Component.text("Protecting your items in your base is quite important. On")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcExplainedLore2 = Component
				.text("the GalaxeSMP, you can protect your chests, doors, and other items")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcExplainedLore3 = Component.text("with a couple of commands, and even give your friends access")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcExplainedLore4 = Component.text("to your protected items!")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcLockItemLore1 = Component.text("To lock an item, run /cprivate to prevent other players to access")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcLockItemLore2 = Component.text("your chest/door/etc. You then punch the block you want to protect")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcUnlockItemLore1 = Component.text("To unlock an item to allow others to freely access your chest,")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcUnlockItemLore2 = Component.text("run /cremove to remove a protected block, and punch the block")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcUnlockItemLore3 = Component.text("you want to not protect anymore.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcShareLockedItemLore1 = Component
				.text("To share a protected chest with someone, run /cmodify. This will")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcShareLockedItemLore2 = Component
				.text("show you all types of options for adding or removing your friends")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcShareLockedItemLore3 = Component.text("to a registered protection")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcDisableAutoLockLore1 = Component
				.text("Locking blocks is enabled by default to help protect all your items.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcDisableAutoLockLore2 = Component
				.text("If you do not want to have this, run /cnolock to disable this action.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcDisableAutoLockLore3 = Component
				.text("To re-enable this, run /cnolock again to toggle it back on.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore1 = Component
				.text("You can use all sorts of nice granular protection flags to make life easier")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore2 = Component
				.text("for you or everyone. Redstone, automatic closing doors, hoppers, etc.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore3 = Component.text("can be used to make things easier for you.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore4 = Component
				.text("/credstone allows redstone to interact with this protection")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore5 = Component
				.text("/cmagnet allows items dropped to be sucked into a chest or nearby items")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore6 = Component.text(
				"/chopper allows hoppers to be used with a chest (for granular control, use /lwc flag hopperin/hopperout)")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore7 = Component.text("/cautoclose automagically closes a door if opened.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcProtectionFlagsLore8 = Component.text("To see all the flags, run /lwc flag")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcTypesOfLockingLore1 = Component
				.text("There are many types of protections to use for your specific needs")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcTypesOfLockingLore2 = Component
				.text("Private: Only you can access your protected item, you have to allow your friends to access it.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcTypesOfLockingLore3 = Component
				.text("Public: Anyone can take or place items from this protection, like a community chest")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcTypesOfLockingLore4 = Component.text(
				"Password: You need to provide a password to access the protection, once entered you won't need it until you log off and log back on.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcTypesOfLockingLore5 = Component.text(
				"Donation: Anyone can place items into the protection but cannot take anything out of the protection, like a mailbox")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcTypesOfLockingLore6 = Component.text(
				"Display: Anyone can see the contents of a protection, but cannot take or place anything into the protection, great for lecterns")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcTypesOfLockingLore7 = Component.text(
				"Supply: Anyone can take the contents of the protection but not add anything to it, like a supply crate.")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcLockableItemsLore1 = Component.text("A whole lot of items can be locked, such as:")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcLockableItemsLore2 = Component
				.text("Chests, Furnaces, Dispensers, Droppers, Barrels, Hoppers, Lecterns, Shulker Boxes")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		Component lwcLockableItemsLore3 = Component
				.text("Doors, Trapdoors, Signs, Fence Gates, Banners, and Composters")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);
		// Help Items

		// ====================
		// Lunar eclipses help menu
		// ====================

		// TextComponents for item names
		Component lunarEclipseExplained = Component.text("What is a lunar eclipse?")
				.color(TextColor.color(colorUltraViolet)).decorate(TextDecoration.BOLD);
		Component lunarEclipseLoot = Component.text("Lunar eclipse loot").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lunarEclipseSchedule = Component.text("Lunar eclipse schedule")
				.color(TextColor.color(colorUltraViolet)).decorate(TextDecoration.BOLD);
		Component lunarEclipseMobs = Component.text("Lunar eclipse mobs").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lunarEclipseHordes = Component.text("Lunar eclipse hordes").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lunarEclipseBosses = Component.text("Lunar eclipse bosses").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);
		Component lunarEclipseTips = Component.text("Lunar eclipse tips").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component lunarEclipseExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseExplainedLore2 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseExplainedLore3 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseLootLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseLootLore2 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseLootLore3 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseScheduleLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseScheduleLore2 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseMobsLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseMobsLore2 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseMobsLore3 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseHordesLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseHordesLore2 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseHordesLore3 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseBossesLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseBossesLore2 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseBossesLore3 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseTipsLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseTipsLore2 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);
		Component lunarEclipseTipsLore3 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items

		// ====================
		// mcMMO help menu
		// ====================

		// TextComponents for item names
		Component mcMMOExplained = Component.text("What is mcMMO?").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component mcMMOExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items

		// ====================
		// Silk spawners help menu
		// ====================

		// TextComponents for item names
		Component silkSpawnersExplained = Component.text("What are Silk Spawners?")
				.color(TextColor.color(colorUltraViolet)).decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component silkSpawnersExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items

		// ====================
		// Towny help menu
		// ====================

		// TextComponents for item names
		Component townyExplained = Component.text("What is Towny?").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component townyExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items

		// ====================
		// Economy help menu
		// ====================

		// TextComponents for item names
		Component ecoExplained = Component.text("Why money?").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component ecoExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items

		// ====================
		// Graves help menu
		// ====================

		// TextComponents for item names
		Component gravesExplained = Component.text("What are graves?").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component gravesExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items

		// ====================
		// Events help menu
		// ====================

		// TextComponents for item names
		Component eventsExplained = Component.text("").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component eventsExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items

		// ====================
		// Pronouns help menu
		// ====================

		// TextComponents for item names
		Component pronounsExplained = Component.text("").color(TextColor.color(colorUltraViolet))
				.decorate(TextDecoration.BOLD);

		// TextComponents for Lore on each item
		Component pronounsExplainedLore1 = Component.text("").color(TextColor.color(colorLightOrange))
				.decorate(TextDecoration.ITALIC);

		// Help Items
	}

	/**
	 * Creates a GUI with the specified title, number of rows, and whether or not to
	 * fill white panes and add a back button
	 * 
	 * @param title
	 *            The title of the GUI
	 * @param rows
	 *            The number of rows in the GUI
	 * @param fillWhitePanes
	 *            Whether or not to fill the white panes
	 * @param addBackButton
	 *            Whether or not to add a back button to go back to the main help
	 *            menu
	 * @return The created GUI
	 */
	private static Gui createGui(String title, int rows, Boolean fillWhitePanes, Boolean addBackButton) {
		// Create title Component for GUI
		Component titleComponent = Component.text(title).color(TextColor.color(colorSpaceCadet))
				.decorate(TextDecoration.BOLD);

		// Create components for back button
		Component back = Component.text("Back").color(TextColor.color(colorUltraViolet)).decorate(TextDecoration.BOLD);
		Component backLore = Component.text("Click to go back to the main help menu")
				.color(TextColor.color(colorLightOrange)).decorate(TextDecoration.ITALIC);

		// Create GUI
		Gui gui = Gui.gui().title(titleComponent).rows(rows).create();

		// Set GUI w/open and close sounds
		gui.setOpenGuiAction(event -> {
			player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_STEP, 1, 1);
		});
		gui.setCloseGuiAction(event -> {
			player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1, 1);
		});

		// Disable taking items from all GUIs
		gui.setDefaultClickAction(event -> {
			event.setCancelled(true);
		});

		// Create empty Component for empty item names
		Component emptyComponent = Component.text("");

		// Fill empty slots with pink and purple glass panes
		gui.getFiller()
				.fill(List.of(ItemBuilder.from(Material.PINK_STAINED_GLASS_PANE).name(emptyComponent).asGuiItem(),
						ItemBuilder.from(Material.PURPLE_STAINED_GLASS_PANE).name(emptyComponent).asGuiItem()));

		// Add white pane filler for some GUIs if specified
		if (fillWhitePanes) {
			// Format: {{row, column}, {row, column}, ...}
			int[][] whitePaneCoords = {{1, 5}, {2, 4}, {2, 6}, {3, 3}, {3, 5}, {3, 7}, {4, 4}, {4, 6}, {5, 5}, {6, 5}};
			for (int[] coordsEntry : whitePaneCoords) {
				gui.setItem(coordsEntry[0], coordsEntry[1],
						ItemBuilder.from(Material.WHITE_STAINED_GLASS_PANE).name(emptyComponent).asGuiItem());
			}
		}

		// Add back button to some GUIs if specified
		if (addBackButton) {
			// Add back button to some GUIs
			gui.setItem(rows, 5, ItemBuilder.from(Material.BARRIER).name(back).lore(backLore).asGuiItem(event -> {
				player.performCommand("help");
			}));
		}
		return gui;
	}

	/**
	 * Creates a player head ItemStack with the specified texture ID
	 * 
	 * @param TextureID
	 *            The texture ID of the head
	 * @return The player head ItemStack
	 */
	public static ItemStack createHead(String textureID) {
		PlayerProfile headProfile = Core.plugin.getServer().createProfile(UUID.randomUUID());
		PlayerTextures headTextures = headProfile.getTextures();

		try {
			headTextures.setSkin(new URL("https://textures.minecraft.net/texture/" + textureID));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		headProfile.setTextures(headTextures);

		ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setPlayerProfile(headProfile);
		skull.setItemMeta(meta);

		return skull;
	}

	/**
	 * Creates a player head ItemStack with the specified player
	 * 
	 * @param player
	 *            The player to get the head of
	 * @return The player head ItemStack
	 */
	public static ItemStack createHead(Player player) {
		ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setPlayerProfile(player.getPlayerProfile());
		skull.setItemMeta(meta);

		return skull;
	}
}
