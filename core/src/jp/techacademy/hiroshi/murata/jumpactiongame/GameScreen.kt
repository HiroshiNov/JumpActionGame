package jp.techacademy.hiroshi.murata.jumpactiongame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.FitViewport


class GameScreen(private val mGame: JumpActionGame) : ScreenAdapter(){
    companion object {
        val CAMERA_WIDTH =10f
        val CAMERA_HEIGHT = 15f
    }

    private val mBg: Sprite
    private val mCamera: OrthographicCamera
    private val mViewport: FitViewport

    init{
        //prepare BackScreen
        val bgTexture = Texture("back.png")
        //Source point is leftside on top when cut TextureRefion
        mBg = Sprite(TextureRegion(bgTexture,0,0,540,810))
        mBg.setPosition(0f,0f)
        mBg.setPosition(0f,0f)

        mCamera = OrthographicCamera()
        mCamera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT)
        mViewport = FitViewport(CAMERA_WIDTH, CAMERA_HEIGHT,mCamera)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mCamera.update()
        mGame.batch.projectionMatrix = mCamera.combined

        mGame.batch.begin()

        mBg.setPosition(mCamera.position.x - CAMERA_WIDTH / 2, mCamera.position.y - CAMERA_HEIGHT / 2 )
        mBg.draw(mGame.batch)

        mGame.batch.end()
    }

    override fun resize(width: Int, height: Int) {
        mViewport.update(width,height)
    }
}