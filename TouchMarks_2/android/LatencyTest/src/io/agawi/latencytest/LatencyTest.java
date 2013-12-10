/**
   LatencyTest - Copyright 2013 Agawi
   @author John Driscoll
 */

package io.agawi.latencytest;

import android.view.MotionEvent;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.opengles.GL10;

public class LatencyTest
    extends android.app.Activity
    implements GLSurfaceView.Renderer
{

    private volatile boolean pressed = false;

    @Override
    public void onCreate( final android.os.Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        final GLSurfaceView surface = new GLSurfaceView( this ) {

                @Override
                public boolean onTouchEvent( MotionEvent e )
                {
                    switch( e.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        pressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        pressed = false;
                        break;
                    }
                    requestRender();
                    return true;
                }
                
            };
        surface.setRenderer( this );
        surface.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        setContentView( surface );
    }

    @Override
    public void onDrawFrame( final GL10 gl )
    {
        clearScreen( gl );
    }
    
    private void clearScreen( final GL10 gl )
    {
        if( pressed ) {
            gl.glClearColor( 1, 1, 1, 1 );
        } else {
            gl.glClearColor( 0, 0, 0, 1 );
        }
        gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
    }
    
    /* Other required methods for GLSurfaceView.Renderer interface */

    @Override
    public void onSurfaceChanged(
        final GL10 gl,
        final int width, final int height )
    {
        gl.glViewport( 0, 0, width, height );
    }

    @Override
    public void onSurfaceCreated(
        final GL10 gl,
        final javax.microedition.khronos.egl.EGLConfig config ) {}
    
}
