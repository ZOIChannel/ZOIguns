package com.zoi.gun;

import java.io.IOException;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.zoi.gun.common.CommonProxyF;
import com.zoi.gun.item.AK47;






/*
 * @Modアノテーションです。
 * MODのID、表示名、起動に必要な他MODなどを記述するところ。
 */
@Mod(modid = "ZOIguns", name = "ZOIguns", version = "1.0.0", dependencies = "required*after:Forge@[10.13.4.1558,)")

public class ZOIguns {

    // プロキシの登録
    @SidedProxy(clientSide = "com.zoi.gun.client.ClientProxyF", serverSide = "com.zoi.gun.common.CommonProxyF")
    public static CommonProxyF proxy;

    // インスタンスの生成
    // @InstanceのStringにはMODのIDを入れます。
    @Instance("ZOIguns")
    public static ZOIguns instance;

    /* Loggerクラス
     * 必須ではありませんが、エラー箇所の調査時など、一時的にコンソールログを出したいときに使用しています。
     * たとえば、FlameCore.logger.info("ログの内容の文字列")のような形でログを出します。
     */
    public static Logger logger = LogManager.getLogger("ZOIguns");

    // AK47のインスタンス。
    public static Item AK47;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        /*
         * FMLPreInitializationEventです。
         * このメソッドをはじめとしたローディングイベントは、マインクラフトの起動時、Forgeによって所定のタイミングで呼ばれます。
         * 実際どんなことが起きているかはコンソールログにでてくるので、
         * 興味があればVersions/logsフォルダにあるfml-client-latest.logを眺めてみると良いです。
         *
         * アイテムやブロックの登録などは、基本的にはここで行われます。
         */
        // conf
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();
            /*
             * Configの項目の生成と読み込み。
             * この段階では、まだ項目はありません。
             */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cfg.save();
        }

        // アイテムやブロックの登録はこのあたりで行う予定。
        // itemの登録。
        this.AK47 = new AK47().setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("dcsflame.flamethrower");
        GameRegistry.registerItem(AK47, "ZOIguns.AK47");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        /*
         * FMLInitializationEventです。全てのMODのPreInitの後、順にInitが呼ばれます。
         * 私の場合、ここではEntity、TileEntity、Render関係、ForgeやFMLのイベント登録などを行っています。
         * レシピもこのあたりで登録することが多いですが、このMODの場合は諸事情によりPostInitで登録します。
         */
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        /*
         * FMLPostInitializationEventです。全てのMODのInitとIMCEventの後、順に呼ばれます。
         * アイテムやブロックなど色々なMODの追加物が揃っていることが多いため、MOD間の連携要素の読み込みによく利用されます。
         */
    }
}
