package org.flame_engine.gamepads_android

import android.hardware.input.InputManager
import android.os.Handler
import android.view.InputDevice
import android.view.KeyEvent
import android.view.MotionEvent

interface GamepadsCompatibleActivity {
    fun isGamepadsInputDevice(device: InputDevice): Boolean {
        return (device.sources and InputDevice.SOURCE_GAMEPAD == InputDevice.SOURCE_GAMEPAD ||
                device.sources and InputDevice.SOURCE_JOYSTICK == InputDevice.SOURCE_JOYSTICK) &&
                (device.sources and InputDevice.SOURCE_MOUSE == 0) &&
                (device.sources and InputDevice.SOURCE_KEYBOARD == 0)
    }

    fun registerInputDeviceListener(listener: InputManager.InputDeviceListener, handler: Handler?)
    fun registerKeyEventHandler(handler: (KeyEvent) -> Boolean)
    fun registerLockedKeyEventHandler(handler: (KeyEvent) -> Boolean)
    fun registerMotionEventHandler(handler: (MotionEvent) -> Boolean)
}