package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class t3DWorld implements Disposable {
  private Environment environment;
  private Camera camera;
  private CameraInputController camInput;
  private Array<tBSPObject> bspObjects;
  private ModelBuilder modelBuilder;
  private ModelBatch modelBatch;

  public t3DWorld() {
    environment = new Environment();
    environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
    environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

    camera = new PerspectiveCamera(70f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    camera.position.set(5f, 5f, 5f);
    camera.lookAt(0f, 0f, 0f);
    camera.near = 0.1f;
    camera.far = 500f;
    camera.update();

    camInput = new CameraInputController(camera);
    Gdx.input.setInputProcessor(camInput);

    bspObjects = new Array<tBSPObject>();

    modelBuilder = new ModelBuilder();
    modelBatch = new ModelBatch();
  }

  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(Environment newEnvironment) {
    environment = newEnvironment;
  }

  public Camera getCamera() {
    return camera;
  }

  public void setCamera(Camera newCamera) {
    camera = newCamera;
  }

  public CameraInputController getCameraInputController() {
    return camInput;
  }

  public void setCameraInputController(CameraInputController newCamInput) {
    camInput = newCamInput;
  }

  public ModelBuilder getModelBuilder() {
    return modelBuilder;
  }

  public void setModelBuilder(ModelBuilder newModelBuilder) {
    modelBuilder = newModelBuilder;
  }

  public Array<tBSPObject> getAllObjects() {
    return bspObjects;
  }

  public void addObject(tBSPObject newObject) {
    bspObjects.add(newObject);
  }

  public void renderAll(){
    camInput.update();
    camera.update();
    
    modelBatch.begin(camera);
    for(tBSPObject obj : bspObjects) {
      modelBatch.render(obj.getInstance(), environment);
    }
    modelBatch.end();
  }

  public void dispose() {
    modelBatch.dispose();
  }
}
