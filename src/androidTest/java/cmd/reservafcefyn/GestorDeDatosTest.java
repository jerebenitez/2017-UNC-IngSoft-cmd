package cmd.reservafcefyn;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cmd.controlador.*;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class GestorDeDatosTest {

        private BDDHelper dbh;
        private GestorDeDatos gdd;

        @Before
        public void setUp(){
            dbh = new BDDHelper(InstrumentationRegistry.getTargetContext());
            gdd = new GestorDeDatos(dbh);

        }

        @Test
        public void testPreConditions() {
            assertNotNull(dbh);
        }

        @Test
        public void testPreConditions2() {
            assertNotNull(gdd);
        }

        @Test
        public void addition_isCorrect() throws Exception {
            assertEquals(4, 2 + 2);
        }
}