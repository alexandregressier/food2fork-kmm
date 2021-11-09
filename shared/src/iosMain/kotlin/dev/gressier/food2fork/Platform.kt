package dev.gressier.food2fork

import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String =
        UIDevice.currentDevice.run { "$systemName $systemVersion" }
}