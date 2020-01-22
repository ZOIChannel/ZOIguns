package com.zoi.gun.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBow;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AK47 extends ItemBow {
    public AK47Clone() {
        // スタックサイズ上限。スタック出来ないようにするので1にする。
        this.setMaxStackSize(1);
        // 耐久値がないとエンチャントできないと判明したので、気持ちだけ付けた
        this.setMaxDamage(4);
        // クラフトでの修理を不可に。
        this.setNoRepair();
    }

    // Icon用テクスチャファイルの指定はここで行う。
    // ItemBowクラスでも、このメソッドでテクスチャパスを指定しているため、
    // オーバーライドして上書きしなければならない。(コンストラクタでのテクスチャパス指定は推奨しない。)
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("zoiguns:gun/AK47");
    }

    // 手に持ったときの見た目が変わります。IItemRenderer調整時にも影響します。
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
}
