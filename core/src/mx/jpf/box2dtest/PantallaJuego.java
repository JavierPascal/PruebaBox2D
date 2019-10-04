package mx.jpf.box2dtest;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

class PantallaJuego extends Pantalla {

    private static final float RADIO = 10f ;
    private World mundo;
    private Body body;
    private Box2DDebugRenderer debugRenderer;

    public PantallaJuego(Game game) {
    }

    @Override
    public void show() {
        crearMundo();
        crearObjetos();

    }

    private void crearObjetos() {
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyDef.BodyType.DynamicBody;
        bodydef.position.set(5,700);
        body = mundo.createBody(bodydef);

        CircleShape circulo =  new CircleShape();
        circulo.setRadius(RADIO);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circulo;
        fixtureDef.density = 0.4f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.2f;

        body.createFixture(fixtureDef);
        circulo.dispose();
    }

    private void crearMundo() {
        Box2D.init();
        Vector2 gravedad = new Vector2(0,-10);
        mundo = new World(gravedad, true);
        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void render(float delta) {
        borrarPantalla(0,0,1);
        debugRenderer.render(mundo,camara.combined);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
