package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Shape;

public class tBSPCube implements tBSPObject {
  private t3DWorld world;
  private Material material;
  private Model model;
  private ModelInstance instance;

  public tBSPCube(t3DWorld world) {
    this.world = world;
    material = new Material(ColorAttribute.createDiffuse(Color.LIGHT_GRAY));
    model = world.getModelBuilder().createBox(1f, 1f, 1f, material, Usage.Position | Usage.Normal);
    instance = new ModelInstance(model);
    world.addObject(this);
  }

  @Override
  public void setMaterial(Material newMaterial) {
    instance.materials.set(0, newMaterial);
  }

  @Override
  public Material getMaterial() {
    return instance.materials.get(0);
  }

  @Override
  public ModelInstance getInstance() {
    return instance;
  }
}
