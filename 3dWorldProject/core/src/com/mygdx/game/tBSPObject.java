package com.mygdx.game;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

public interface tBSPObject {
  public void setLocation(Vector3 newLocation);
  public Vector3 getLocation();
  public void setRotation(Vector3 newRotation);
  public Vector3 getRotation();
  public void setScale(Vector3 newScale);
  public Vector3 getScale();
  public void setMaterial(Material newMaterial);
  public Material getMaterial();
  public void setInstance(ModelInstance newInstance);
  public ModelInstance getInstance();
}