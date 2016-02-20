package com.mygdx.game;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

public interface tBSPObject {
  public void setMaterial(Material newMaterial);
  public Material getMaterial();
  public void setInstance(ModelInstance newInstance);
  public ModelInstance getInstance();
}