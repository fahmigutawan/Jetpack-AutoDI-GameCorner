package com.example.benchmark
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
/**
 * This is an example startup benchmark.
 *
 * It navigates to the device's home screen, and launches the default activity.
 *
 * Before running this benchmark:
 * 1) switch your app's active build variant in the Studio (affects Studio runs only)
 * 2) add `<profileable android:shell="true" />` to your app's manifest, within the `<application>` tag
 *
 * Run this benchmark from Studio to see startup measurements, and captured system traces
 * for investigating your app's performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()
    @Test
    fun guideStartup() = benchmarkRule.measureRepeated(
        packageName = "com.example.autodigamecorner",
        metrics = listOf(StartupTimingMetric()),
        iterations = 2,
        startupMode = StartupMode.COLD
    ) {
        pressHome()
        startActivityAndWait()
        val button = device.findObject(By.text("Petunjuk Peminjaman Game Corner"))
        button.click()
        while (true) {
            if(device.findObject(By.text("Petunjuk Penggunaan")) != null){
                this.pressHome()
                break
            }
        }
    }
    @Test
    fun deviceStartup() = benchmarkRule.measureRepeated(
        packageName = "com.example.autodigamecorner",
        metrics = listOf(StartupTimingMetric()),
        iterations = 2,
        startupMode = StartupMode.COLD
    ) {
        pressHome()
        startActivityAndWait()
        val button = device.findObject(By.text("Informasi Perangkat Game Corner"))
        button.click()
        while (true) {
            if(device.findObject(By.text("Perangkat")) != null){
                this.pressHome()
                break
            }
        }
    }
}