package techdread.com.echo

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {

        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("techdread.com.echo", appContext.packageName)
    }
}
