package lykrast.mysticalwildlife.client.model;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QuadrupedBaseModel<T extends Entity> extends AgeableModel<T> {
    public ModelRenderer head = new ModelRenderer(this, 0, 0);
    public ModelRenderer body;
    public ModelRenderer legRightBack;
    public ModelRenderer legLeftBack;
    public ModelRenderer legRightFront;
    public ModelRenderer legLeftFront;

    public QuadrupedBaseModel(int p_i225948_1_, float p_i225948_2_, boolean p_i225948_3_, float p_i225948_4_, float p_i225948_5_, float p_i225948_6_, float p_i225948_7_, int p_i225948_8_) {
        super(p_i225948_3_, p_i225948_4_, p_i225948_5_, p_i225948_6_, p_i225948_7_, (float)p_i225948_8_);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, p_i225948_2_);
        this.head.setRotationPoint(0.0F, (float)(18 - p_i225948_1_), -6.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F, p_i225948_2_);
        this.body.setRotationPoint(0.0F, (float)(17 - p_i225948_1_), 2.0F);
        this.legRightBack = new ModelRenderer(this, 0, 16);
        this.legRightBack.addBox(-2.0F, 0.0F, -2.0F, 4.0F, (float)p_i225948_1_, 4.0F, p_i225948_2_);
        this.legRightBack.setRotationPoint(-3.0F, (float)(24 - p_i225948_1_), 7.0F);
        this.legLeftBack = new ModelRenderer(this, 0, 16);
        this.legLeftBack.addBox(-2.0F, 0.0F, -2.0F, 4.0F, (float)p_i225948_1_, 4.0F, p_i225948_2_);
        this.legLeftBack.setRotationPoint(3.0F, (float)(24 - p_i225948_1_), 7.0F);
        this.legRightFront = new ModelRenderer(this, 0, 16);
        this.legRightFront.addBox(-2.0F, 0.0F, -2.0F, 4.0F, (float)p_i225948_1_, 4.0F, p_i225948_2_);
        this.legRightFront.setRotationPoint(-3.0F, (float)(24 - p_i225948_1_), -5.0F);
        this.legLeftFront = new ModelRenderer(this, 0, 16);
        this.legLeftFront.addBox(-2.0F, 0.0F, -2.0F, 4.0F, (float)p_i225948_1_, 4.0F, p_i225948_2_);
        this.legLeftFront.setRotationPoint(3.0F, (float)(24 - p_i225948_1_), -5.0F);
    }

    protected Iterable<ModelRenderer> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(this.body, this.legRightBack, this.legLeftBack, this.legRightFront, this.legLeftFront);
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.legRightBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legLeftBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legRightFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legLeftFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
