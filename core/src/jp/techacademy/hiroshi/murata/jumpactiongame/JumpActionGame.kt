package jp.techacademy.hiroshi.murata.jumpactiongame

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.Game

class JumpActionGame(val mRequestHandler: ActivityRequestHandler) : Game() {
    lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()

        //show GameScreen
        setScreen(GameScreen(this))
    }

//    override fun render() {
//        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
//        batch.begin()
//        batch.draw(img, 0f, 0f)
//        batch.end()
//    }
//
//    override fun dispose() {
//        batch.dispose()
//        img.dispose()
//    }
}
