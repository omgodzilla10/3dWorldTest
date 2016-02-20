package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;

public class t3DWorld implements Disposable {
  private Environment environment;
  private Camera camera;
  private CameraInputController camInput;
  private Array<tBSPObject> bspObjects;
  private ModelBuilder modelBuilder;
  private ModelBatch modelBatch;

  public t3DWorld() {
    environment = new Environment();
    environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f,
        0f, 0f, 0f));

    camera = new PerspectiveCamera();
    camera.lookAt(0f, 0f, 0f);
    camera.translate(-5f, 10f, -5f);

    camInput = new CameraInputController(camera);

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
    modelBatch.begin(camera);
    for(tBSPObject obj : bspObjects) {
      modelBatch.render(obj.getInstance(), environment);
    }
    modelBatch.end();

    camera.update();
  }

  public void dispose() {
    modelBatch.dispose();
    modelBuilder.dispose();
    environment.dispose();
    camera.dispose();
    camInput.dispose();

    for (tBSPObject obj : bspObjects) {
      obj.dispose();
    }
  }
}
