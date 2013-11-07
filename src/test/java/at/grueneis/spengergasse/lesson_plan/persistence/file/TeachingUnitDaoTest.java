package at.grueneis.spengergasse.lesson_plan.persistence.file;

import at.grueneis.spengergasse.lesson_plan.domain.TeachingUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TeachingUnitDaoTest {

    @Test
    public void writingIntoFile() throws FileNotFoundException, IOException {
        TeachingUnit teachingUnit = new TeachingUnit("POS");
        ArrayList<TeachingUnit> teachingUnits = new ArrayList<>();
        teachingUnits.add(teachingUnit);

        TeachingUnitDao teachingUnitDao = new TeachingUnitDao("src/test/resources");

        File fileBefore = new File(teachingUnitDao.fileName());
        if (fileBefore.exists()) {
            fileBefore.delete();
        }

        teachingUnitDao.writeAll(teachingUnits);

        assertTrue(fileBefore.exists());
        assertTrue(fileBefore.length() > 4);
    }
}
